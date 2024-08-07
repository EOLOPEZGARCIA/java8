package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.InventariosDAO;
import com.entity.Inventarios;
import com.general.Status;

@Path("inventarios")
public class InventariosService {

	Inventarios inventario= null;
	InventariosDAO dao=null;
	
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Inventarios> mostrar(){
		dao= new InventariosDAO();
		List<Inventarios> list=dao.mostrar();
		System.out.println("PRODUCTOS: "+ list);
		return list;
	}
	
	@Path("guardar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status guardar(Inventarios inventar){
		System.out.println("Producto a guardar: "+ inventar);
		Status state= new Status();
		state.setOb(inventar);
		dao= new InventariosDAO();
		String res= dao.guardar(inventar);
		
		if(res.equals("1")) {
			state.setMensaje("Guardado exitosamente el produc");
			state.setRespuesta(res);
		}else {
			state.setMensaje("No fue posible guardar el produc");
			state.setRespuesta(res);
		}
		return state;
	}
	
	
	@Path("editar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status editar(Inventarios inventar){
		Status state= new Status();
		state.setOb(inventar);
		
		dao= new InventariosDAO();
		String res= dao.editar(inventar);
		
		if(res.equals("1")) {
			state.setMensaje("Actualizado exitosamente el produc");
			state.setRespuesta(res);
		}else {
			state.setMensaje("No fue posible actualizar este produc");
			state.setRespuesta(res);
		}
		return state;
	}
	
	@Path("eliminar/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Status eliminar(@PathParam("id")int id){
		Status state= new Status();
		state.setOb(id);
		
		dao= new InventariosDAO();
		String res= dao.eliminar(id);
		
		if(res.equals("1")) {
			state.setMensaje("Eliminado exitosamente el producto");
			state.setRespuesta(res);
		}else {
			state.setMensaje("No fue posible elimnar este producto");
			state.setRespuesta(res);
		}
		return state;
	}
	
	@Path("buscar-por-id/{id}")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Inventarios buscar(@PathParam("id")int id){
		
		dao= new InventariosDAO();
		inventario = (Inventarios)dao.buscar(id);
		System.out.println("Se encontro el auto");
		return inventario;
	}


	
}
