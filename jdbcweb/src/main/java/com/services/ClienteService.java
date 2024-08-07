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

import com.dao.ClienteDAO;
import com.dto.ProductosPorClienteDTO;
import com.entity.Cliente;
import com.general.Status;

//Clase de servicio
//Expone la funcionalidad de la logica de la capa anterior
@Path("cliente/")
public class ClienteService {
	
	//CORS
	//Cross Origin Resource Sharing
	
	ClienteDAO dao =null;
	Cliente cliente=null;
	String respuesta = null;
	//http://localhost:8090/jdbcweb/jdbcweb/cuenta/mostrar
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Cliente> mostrar(){
		dao= new ClienteDAO();
		return dao.mostrar();
	}
	
	@Path("productos-por-cliente/{nombre}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public ProductosPorClienteDTO productosPorClienteDTO(@PathParam("nombre")String nombre){
		dao= new ClienteDAO();
		return dao.productosPorClienteDTO(nombre);
	}
	
	@Path("guardar")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Status guardar(Cliente cliente) {
		Status s = new Status();
		s.setOb(cliente);
		dao = new ClienteDAO();
		respuesta= dao.guardar(cliente);
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
	public Status actualizar(Cliente cliente) {
		Status s = new Status();
		s.setOb(cliente);
		dao = new ClienteDAO();
		respuesta= dao.actualizar(cliente);
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
	public Cliente buscar(@PathParam("id")int id) {
		Status s = new Status();
		dao = new ClienteDAO();
		cliente = (Cliente) dao.buscar(id);
		return cliente;
	}
	@Path("eliminar/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	public Status eliminar(@PathParam("id")int id) {
		Status s = new Status();
		dao = new ClienteDAO();
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
