package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Inventarios;
import com.entity.Productos;
import com.general.Metodos;

public class InventariosDAO implements Metodos {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tables");
	EntityManager em = emf.createEntityManager();
	Productos producto = null;
	Inventarios inventario = null;
	String resultado = null;

	@Override
	public String guardar(Object ob) {
		// TODO Auto-generated method stub
		inventario = (Inventarios) ob;
		em.getTransaction().begin();
		try {
			em.persist(inventario);
			em.getTransaction().commit();
			resultado = "1";
			System.out.println("Inventario insertado");

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
		// TODO Auto-generated method stub
		inventario = (Inventarios) ob;
		Productos productodb = em.find(Productos.class, inventario.getProducto().getProductoId());
		Inventarios inventariodb = em.find(Inventarios.class, inventario.getInventarioId());

		em.getTransaction().begin();
		try {
			inventariodb.setFecha(inventario.getFecha());
			inventariodb.setProducto(productodb);
			inventariodb.setStock(inventario.getStock());
			em.getTransaction().commit();
			System.out.println("Inventario Editadado correctamente");
			resultado = "1";

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
		// TODO Auto-generated method stub
		inventario = em.find(Inventarios.class, id);
		em.getTransaction().begin();
		try {
			em.remove(inventario);
			em.getTransaction().commit();
			System.out.println("Se ha eliminado el inventario");
			resultado = "1";

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
		// TODO Auto-generated method stub
		inventario = em.find(Inventarios.class, id);

		return inventario;
	}

	@Override
	public List mostrar() {
		// TODO Auto-generated method stub
		List<Inventarios> inventarios = em.createQuery("from Inventarios").getResultList();

		return inventarios;
	}

}
