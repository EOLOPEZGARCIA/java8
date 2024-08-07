package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Autos;
import com.entity.Marcas;
import com.general.Metodos;

public class MarcasDAO implements Metodos {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Tables");
	EntityManager em= emf.createEntityManager();
	Marcas marca=null;
	String resultado=null;
	
	@Override
	public String guardar(Object ob) {
		marca=(Marcas)ob;
		em.getTransaction().begin();
		try {
			em.persist(marca);
			em.getTransaction().commit();
			resultado="1";
			System.out.println("Marca insertado");
			
		} catch (Exception ex) {
			em.getTransaction().rollback();
			resultado = ex.getMessage();
			System.out.println(resultado);
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		em.close();
		return resultado;
	}
	@Override
	public String editar(Object ob) {
		marca =(Marcas)ob;
		
		Marcas marcadb = em.find(Marcas.class, marca.getMarcaId());
		em.getTransaction().begin();
		try {
			marcadb.setNombre(marca.getNombre());
			marcadb.setCeo(marca.getCeo());
			marcadb.setPaisId(marca.getPaisId());
			em.getTransaction().commit();
			System.out.println("Marca Editadada correctamente");
			resultado="1";
			
		} catch (Exception ex) {
			em.getTransaction().rollback();
			resultado = ex.getMessage();
			System.out.println(resultado);
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return resultado;	
	}
	@Override
	public String eliminar(int id) {
		marca= em.find(Marcas.class, id);
		
		em.getTransaction().begin();
		try {
			em.remove(marca);
			em.getTransaction().commit();
			System.out.println("Se ha eliminado la marca");
			resultado="1";
			
		} catch (Exception ex) {
			em.getTransaction().rollback();
			resultado = ex.getMessage();
			System.out.println(resultado);
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return resultado;
	}
	@Override
	public Object buscar(int id) {
		// TODO Auto-generated method stub
		marca=em.find(Marcas.class, id);
		return marca;
	}
	@Override
	public List mostrar() {
		List<Marcas> marcas=em.createQuery("from Marcas").getResultList();
		return marcas;
	}
	
}
