package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.ProductosDAO;
import com.entity.Productos;
import com.general.Status;

@Path("productos")
public class ProductosService {
	
	Productos producto= null;
	ProductosDAO dao=null;
	
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Productos> mostrar(){
		dao= new ProductosDAO();
		List<Productos> list=dao.mostrar();
		System.out.println("PRODUCTOS: "+ list);
		return list;
	}
	
	@Path("guardar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status guardar(Productos produc){
		System.out.println("Producto a guardar: "+ produc);
		Status state= new Status();
		state.setOb(produc);
		dao= new ProductosDAO();
		String res= dao.guardar(produc);
		
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
	public Status editar(Productos produc){
		Status state= new Status();
		state.setOb(produc);
		
		dao= new ProductosDAO();
		String res= dao.editar(produc);
		
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
		
		dao= new ProductosDAO();
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
	public Productos buscar(@PathParam("id")int id){
		
		dao= new ProductosDAO();
		producto = (Productos)dao.buscar(id);
		System.out.println("Se encontro el auto");
		return producto;
	}

	

}
