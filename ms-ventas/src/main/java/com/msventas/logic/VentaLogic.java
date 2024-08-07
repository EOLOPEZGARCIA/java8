package com.msventas.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.msventas.service.VentaService;
import com.persistence.dto.DetalleVentaDTO;
import com.persistence.entity.Clientes;
import com.persistence.entity.DetVentas;
import com.persistence.entity.Empleados;
import com.persistence.entity.Ventas;
import com.persistence.http.HttpClient;
import com.persistence.repository.ClienteRepository;
import com.persistence.repository.DetVentaRepository;
import com.persistence.repository.EmpleadoRepository;
import com.persistence.repository.VentaRepository;
import com.persistence.request.VentaRequest;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class VentaLogic implements VentaService {
	
	@Autowired //inyeccion de dependencia ventarepository
	VentaRepository repo;
	@Autowired //inyeccion de dependencia ventarepository
	EmpleadoRepository emRepo;
	@Autowired //inyeccion de dependencia ventarepository
	ClienteRepository cliRepo;
	@Autowired //inyeccion de dependencia ventarepository
	DetVentaRepository detRepo;
	
	//Cliente HTTP(como postman)
	//RestTemplate template = new RestTemplate();

	@Override
	public Ventas guardar(VentaRequest request) {
		Ventas prod = new Ventas();
		Empleados em= emRepo.findById(request.getEmpleado().getEmpleadoId()).get();
		Clientes clien= cliRepo.findById(request.getCliente().getClienteId()).get();
		
		prod.setCliente(clien);
		prod.setEmpleado(em);
		prod.setFechaVenta(request.getFechaVenta());
		prod.setSubtotal(0);
		prod.setTotal(0);
		repo.save(prod);
		
		String producto;
		double subtotal=0.0;
		JSONObject json = null;
		//iterar dentro de la lista de dtos
		//para extraer datos, guardar detalles de venta ,calcular subtotal y total
		for(DetalleVentaDTO detalle: request.getDetalles()) {
			
			String descripcion= detalle.getProducto();
			String url="http://localhost:8090/productos/buscar-por-nombre/"+descripcion;
			url = UriComponentsBuilder.fromUriString(url).build().encode().toString();
			try {
				producto = HttpClient.peticionHttpGet(url);
				json = new JSONObject(String.valueOf(producto));
				DetVentas dtv = new DetVentas();
				dtv.setVentaId(prod.getVentaId());
				dtv.setProductoId(json.getInt("productoId"));
				dtv.setCantidad(detalle.getCantidad());
				subtotal+=json.getDouble("precioVenta")*detalle.getCantidad();
				detRepo.save(dtv);
			}catch(Exception ex) {
				ex.printStackTrace();
			}			
		}
		//actualizo subtotal y total de la venta
		
		prod.setSubtotal(subtotal);
		prod.setTotal(subtotal*1.16);
		repo.save(prod);
		return prod;
	}

	@Override
	public Ventas actualizar(VentaRequest request) {
		Ventas prod= repo.findById(request.getVentaId()).get();
		Empleados em= emRepo.findById(request.getEmpleado().getEmpleadoId()).get();
		Clientes clien= cliRepo.findById(request.getCliente().getClienteId()).get();
		
		prod.setCliente(clien);
		prod.setEmpleado(em);
		prod.setFechaVenta(request.getFechaVenta());
		prod.setSubtotal(request.getSubtotal());
		prod.setTotal(request.getTotal());
		repo.save(prod);
		return prod;
	}

	@Override
	public Ventas buscar(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public String eliminar(int id) {
		repo.deleteById(id);
		return "ELIMINADO";
	}

	@Override
	public List mostrar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
