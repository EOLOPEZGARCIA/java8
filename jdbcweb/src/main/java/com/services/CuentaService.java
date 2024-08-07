package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.CuentaDAO;
import com.dto.InventarioPorProductoDTO;
import com.entity.Cuenta;
import com.general.Status;

//Clase de servicio
//Expone la funcionalidad de la logica de la capa anterior
@Path("cuenta/")
public class CuentaService {
	
	//CORS
	//Cross Origin Resource Sharing
	
	CuentaDAO dao =null;
	Cuenta cuenta=null;
	String respuesta = null;
	//http://localhost:8090/jdbcweb/jdbcweb/cuenta/mostrar
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Cuenta> mostrar(){
		dao= new CuentaDAO();
		return dao.mostrar();
	}
	
	@Path("Inventario-por-producto")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<InventarioPorProductoDTO> inventarioPorProductoDTO(){
		dao= new CuentaDAO();
		return dao.inventarioPorProductoDTO();
	}
	
	
	@Path("guardar")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Status guardar(Cuenta cuenta) {
		Status s = new Status();
		s.setOb(cuenta);
		dao = new CuentaDAO();
		respuesta= dao.guardar(cuenta);
		if(respuesta.equals("1")) {
			s.setMensaje("Guardado OK");
			s.setRespuesta(respuesta);
		}else {
			s.setMensaje("No fue posible guardar");
			s.setRespuesta(respuesta);
		}
		return s;
	}
	@Path("actualizar")
	@PUT//NO SE USA PATCH PORQ EL QUERY ES EL RENGLON COMPPLETO NO EN PARTES	
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Status actualizar(Cuenta cuenta) {
		Status s = new Status();
		s.setOb(cuenta);
		dao = new CuentaDAO();
		respuesta= dao.actualizar(cuenta);
		if(respuesta.equals("1")) {
			s.setMensaje("Actualizar OK");
			s.setRespuesta(respuesta);
		}else {
			s.setMensaje("No fue posible actualizar");
			s.setRespuesta(respuesta);
		}
		return s;
	}
	@Path("buscar/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Cuenta buscar(@PathParam("id")int id) {
		Status s = new Status();
		dao = new CuentaDAO();
		cuenta = (Cuenta) dao.buscar(id);
		return cuenta;
	}
	@Path("eliminar/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	public Status eliminar(@PathParam("id")int id) {
		Status s = new Status();
		dao = new CuentaDAO();
		respuesta = dao.eliminar(id);
		if(respuesta.equals("1")) {
			s.setMensaje("Eliminar OK");
			s.setRespuesta(respuesta);
		}else {
			s.setMensaje("No fue posible eliminar");
			s.setRespuesta(respuesta);
		}
		return s;
	}
	
}
