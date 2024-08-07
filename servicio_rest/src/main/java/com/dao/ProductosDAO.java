package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Inventarios;
import com.entity.Productos;
import com.general.Metodos;

public class ProductosDAO implements Metodos{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Tables");
	EntityManager em= emf.createEntityManager();
	Productos producto=null;
	Inventarios inventario=null;
	String resultado=null;
	
	@Override
	public String guardar(Object ob) {
		// TODO Auto-generated method stub
		producto=(Productos)ob;
		em.getTransaction().begin();
		try {
			em.persist(producto);
			em.getTransaction().commit();
			resultado="1";
			System.out.println("Producto insertado");
			
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
		producto=(Productos)ob;
		Productos productodb=em.find(Productos.class,producto.getProductoId());
		Inventarios inventariodb=em.find(Inventarios.class,producto.getInventario().getInventarioId());
		
		em.getTransaction().begin();
		try {
			productodb.setDeptoId(producto.getDeptoId());
			productodb.setFechaCad(producto.getFechaCad());
			productodb.setInventario(inventariodb);
			productodb.setNombre(producto.getNombre());
			productodb.setPrecioCompra(producto.getPrecioCompra());
			productodb.setPrecioVenta(producto.getPrecioVenta());
			productodb.setRefri(producto.getRefri());
			em.getTransaction().commit();
			System.out.println("Producto Editadada correctamente");
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
		// TODO Auto-generated method stub
		producto =em.find(Productos.class,id);
		em.getTransaction().begin();
		try {
			em.remove(producto);
			em.getTransaction().commit();
			System.out.println("Se ha eliminado el producto");
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
		producto =em.find(Productos.class,id);
		
		return producto;
	}

	@Override
	public List mostrar() {
		// TODO Auto-generated method stub
		List<Productos> productos=em.createQuery("from Productos").getResultList();
		
		return productos;
	}

}
