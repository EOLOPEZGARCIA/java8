package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.AutosDAO;
import com.entity.Autos;
import com.general.Status;

@Path("autos")
public class AutosService {
	Autos auto=null;
	AutosDAO dao=null;
	
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Autos> mostrar(){
		dao= new AutosDAO();
		List<Autos> list=dao.mostrar();
		System.out.println("autos: "+ list);
		return list;
	}
	
	@Path("guardar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status guardar(Autos aut){
		System.out.println("Auto a guardar: "+ aut);
		Status state= new Status();
		state.setOb(aut);
		dao= new AutosDAO();
		String res= dao.guardar(aut);
		
		if(res.equals("1")) {
			state.setMensaje("Guardado exitosamente el auto");
			state.setRespuesta(res);
		}else {
			state.setMensaje("No fue posible guardar el auto");
			state.setRespuesta(res);
		}
		return state;
	}
	
	
	@Path("editar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status editar(Autos aut){
		Status state= new Status();
		state.setOb(aut);
		
		dao= new AutosDAO();
		String res= dao.editar(aut);
		
		if(res.equals("1")) {
			state.setMensaje("Actualizado exitosamente el auto");
			state.setRespuesta(res);
		}else {
			state.setMensaje("No fue posible actualizar este auto");
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
		
		dao= new AutosDAO();
		String res= dao.eliminar(id);
		
		if(res.equals("1")) {
			state.setMensaje("Eliminado exitosamente el auto");
			state.setRespuesta(res);
		}else {
			state.setMensaje("No fue posible elimnar este auto");
			state.setRespuesta(res);
		}
		return state;
	}
	
	@Path("buscar-por-id/{id}")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Autos buscar(@PathParam("id")int id){
		
		dao= new AutosDAO();
		auto = (Autos)dao.buscar(id);
		System.out.println("Se encontro el auto");
		return auto;
	}
	

}
