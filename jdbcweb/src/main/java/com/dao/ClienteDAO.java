package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.DetalleVentaDTO;
import com.dto.ProductosPorClienteDTO;
import com.entity.Cliente;
import com.general.Acciones;
import com.general.Database;

//DataAcessObject
//Es el lugar donde se resuelve la logica de acceso a datos
//toda operacion hacia y desde la db, se encapsula aqui
public class ClienteDAO implements Acciones {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//DB
	Database db=new Database();
	
	//Comodin
	Cliente cliente=null;
	String resultado="";
	
	@Override
	public List<Cliente> mostrar() {
		
		String query="SELECT * FROM CLIENTES";
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cliente =new Cliente(rs.getInt("CLIENTE_ID"), rs.getString("NOMBRE"),
									rs.getString("RFC"),rs.getString("DIRECCION"),
									rs.getString("CORREO"),rs.getString("TELEFONO"),rs.getDate("FECHA_NAC"));
				clientes.add(cliente);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return clientes;
	}

	@Override
	public String guardar(Object ob) {
		
		cliente =(Cliente) ob;
		
		String query = "INSERT INTO CLIENTES"
						+"(NOMBRE,RFC,DIRECCION,CORREO,FECHA_NAC,TELEFONO)"
						+" VALUES(?,?,?,?,TO_DATE(?,'DD-MM-YYYY','NLS_DATE_LANGUAGE = American'),?)";
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			ps.setString(1,cliente.getNombre() );
			ps.setString(2,cliente.getRfc());
			ps.setString(3,cliente.getDireccion() );
			ps.setString(4,cliente.getCorreo());
			ps.setDate(5, cliente.getFechaNac() );
			ps.setString(6,cliente.getTelefono() );
			
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Insercion OK");
				resultado = "1";
			}else {
				System.out.println("Error en la insercion");
				resultado="0";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			resultado = ex.getMessage();			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return resultado;
	}

	@Override
	public String actualizar(Object ob) {
		cliente =(Cliente) ob;
		
		String query = "UPDATE CLIENTES SET NOMBRE=?, RFC=?, DIRECCION=?, "
							+"CORREO=? ,FECHA_NAC=? ,TELEFONO=? WHERE CLIENTE_ID=?";
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			ps.setString(1,cliente.getNombre() );
			ps.setString(2,cliente.getRfc());
			ps.setString(3,cliente.getDireccion() );
			ps.setString(4,cliente.getCorreo());
			ps.setDate(5, cliente.getFechaNac() );
			ps.setString(6,cliente.getTelefono() );
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Actualizacion OK");
				resultado = "1";
			}else {
				System.out.println("Error en la actualizacion");
				resultado="0";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			resultado = ex.getMessage();			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return resultado;
	}

	@Override
	public Object buscar(int id) {
		String query="SELECT * FROM CLIENTES WHERE CLIENTE_ID = "+id;
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cliente =new Cliente(rs.getInt("CLIENTE_ID"), rs.getString("NOMBRE"),
						rs.getString("RFC"),rs.getString("DIRECCION"),
						rs.getString("CORREO"),rs.getString("TELEFONO"),rs.getDate("FECHA_NAC"));
	
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return cliente;
	}

	@Override
	public String eliminar(int id) {
		
		String query="DELETE FROM CLIENTES WHERE CLIENTE_ID = "+id;
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			int x =ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Eliminado OK");
				resultado = "1";
			}else {
				System.out.println("Error al eliminar");
				resultado="0";
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			resultado = ex.getMessage();
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return resultado;
	}
	
	public ProductosPorClienteDTO productosPorClienteDTO(String cliente) {
		
		ProductosPorClienteDTO dto= null;
		List<DetalleVentaDTO> detalles=new ArrayList<DetalleVentaDTO>();
		DetalleVentaDTO detalle=null;
		String nombre="";
		String query="SELECT C.NOMBRE AS CLIENTE,D.NOMBRE AS DEPARTAMENTO,V.FECHA_VENTA, DET.CANTIDAD, P.NOMBRE AS PRODUCTO "
				+ "	FROM DEPARTAMENTO D INNER JOIN PRODUCTOS P ON D.DEPTO_ID = P.DEPTO_ID "
				+ " INNER JOIN DET_VENTA DET ON DET.PRODUCTO_ID = P.PRODUCTO_ID INNER JOIN VENTAS V "
				+ " ON V.VENTA_ID = DET.VENTA_ID "
				+ " INNER JOIN CUSTOMERS C ON C.CLIENTE_ID = V.CLIENTE_ID "
				+ " WHERE C.NOMBRE ='"+ cliente + "'";
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				detalle =new DetalleVentaDTO(rs.getString("DEPARTAMENTO"),
											rs.getDate("FECHA_VENTA"),
											rs.getInt("CANTIDAD"),
											rs.getString("PRODUCTO"));
				detalles.add(detalle);
				nombre=rs.getString("CLIENTE");
			}
			dto = new ProductosPorClienteDTO(nombre,detalles);
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			
		}
		
		return dto;
		
	}

}
