package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Autos;
import com.entity.Marcas;
import com.general.Metodos;

public class AutosDAO implements Metodos {
	//CARGA LOS OBJETOS(LAS CLASES DEFINIDAS EN EL PERSISTENCE)
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Tables");
	EntityManager em= emf.createEntityManager();
	Autos auto=null;
	Marcas marca=null;
	String resultado=null;
			
	@Override
	public String guardar(Object ob) {
		auto=(Autos)ob;
		em.getTransaction().begin();
		try {
			em.persist(auto);
			em.getTransaction().commit();
			resultado="1";
			System.out.println("Auto insertado");
			
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
		auto =(Autos)ob;
		
		Autos autodb = em.find(Autos.class, auto.getModeloId());
		Marcas marcadb = em.find(Marcas.class, auto.getMarca().getMarcaId());
		em.getTransaction().begin();
		try {
			autodb.setModelo(auto.getModelo());
			autodb.setMarca(marcadb);
			autodb.setAno(auto.getAno());
			autodb.setTipo(auto.getTipo());
			em.getTransaction().commit();
			System.out.println("Auto Editado correctamente");
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
		auto= em.find(Autos.class, id);
		
		em.getTransaction().begin();
		try {
			em.remove(auto);
			em.getTransaction().commit();
			System.out.println("Se ha eliminado el auto");
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
		auto=em.find(Autos.class, id);
		
		// TODO Auto-generated method stub
		return auto;
	}

	@Override
	public List mostrar() {
		List<Autos> autos=em.createQuery("from Autos").getResultList();
		// TODO Auto-generated method stub
		return autos;
	}

}
