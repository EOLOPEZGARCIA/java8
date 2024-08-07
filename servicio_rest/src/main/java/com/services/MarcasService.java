package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.MarcasDAO;
import com.entity.Marcas;
import com.general.Status;

@Path("marcas")
public class MarcasService {
	Marcas marca=null;
	MarcasDAO dao=null;
	
	@Path("mostrar")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Marcas> mostrar(){
		dao= new MarcasDAO();
		List<Marcas> list=dao.mostrar();
		System.out.println("marcas: "+ list);
		return list;
	}
	
	@Path("guardar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status guardar(Marcas marc){
		System.out.println("Marca a guardar: "+ marc);
		Status state= new Status();
		state.setOb(marc);
		dao= new MarcasDAO();
		String res= dao.guardar(marc);
		
		if(res.equals("1")) {
			state.setMensaje("La Marca fue guardada exitosamente");
			state.setRespuesta(res);
		}else {
			state.setMensaje("La Marca no fue posible guardar");
			state.setRespuesta(res);
		}
		return state;
	}
	

	@Path("editar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Status editar(Marcas marc){
		Status state= new Status();
		state.setOb(marc);
		
		dao= new MarcasDAO();
		String res= dao.editar(marc);
		
		if(res.equals("1")) {
			state.setMensaje("Marca actualizada exitosamente");
			state.setRespuesta(res);
		}else {
			state.setMensaje("Marca no fue posible actualizar ");
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
		
		dao= new MarcasDAO();
		String res= dao.eliminar(id);
		
		if(res.equals("1")) {
			state.setMensaje("Marca eliminada exitosamente");
			state.setRespuesta(res);
		}else {
			state.setMensaje("La Marca no fue posible elimnar");
			state.setRespuesta(res);
		}
		return state;
	}
	
	@Path("buscar-por-id/{id}")
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Marcas buscar(@PathParam("id")int id){
		
		dao= new MarcasDAO();
		marca = (Marcas)dao.buscar(id);
		System.out.println("Se encontro la marca");
		return marca;
	}
	
	
	
	
	
}
