package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cuenta;
import com.general.Acciones;
import com.general.Database;

//DataAcessObject
public class CuentaDAO implements Acciones {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//DB
	Database db=new Database();
	
	//Comodin
	Cuenta cuenta=null;
	String resultado="";
	
	@Override
	public List<Cuenta> mostrar() {
		
		String query="SELECT * FROM CUENTA";
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cuenta =new Cuenta(rs.getInt("CUENTA_ID"), rs.getString("CLABE"),
									rs.getDouble("SALDO"), rs.getString("NUM_CUENTA"),
									rs.getInt("TIPO_ID"), rs.getInt("CLIENTE_ID"));
				cuentas.add(cuenta);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return cuentas;
	}

	@Override
	public String guardar(Object ob) {
		
		cuenta =(Cuenta) ob;
		
		String query = "INSERT INTO CUENTA"
						+"(CLABE, SALDO,NUM_CUENTA,TIPO_ID,CLIENTE_ID)"
						+" VALUES(?,?,?,?,?)";
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			ps.setString(1, cuenta.getClabe());
			ps.setDouble(2, cuenta.getSaldo());
			ps.setString(3, cuenta.getNumCuenta());
			ps.setInt(4,cuenta.getTipoId());
			ps.setInt(5, cuenta.getClienteId());
			
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
cuenta =(Cuenta) ob;
		
		String query = "UPDATE CUENTA SET CLABE=?, SALDO=?, NUM_CUENTA=?, "
							+"TIPO_ID=? ,CLIENTE_ID=? WHERE CUENTA_ID=?";
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			ps.setString(1, cuenta.getClabe());
			ps.setDouble(2, cuenta.getSaldo());
			ps.setString(3, cuenta.getNumCuenta());
			ps.setInt(4,cuenta.getTipoId());
			ps.setInt(5, cuenta.getClienteId());
			ps.setInt(6, cuenta.getCuentaId());
			
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
		String query="SELECT * FROM CUENTA WHERE CUENTA_ID = "+id;
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				cuenta =new Cuenta(rs.getInt("CUENTA_ID"), rs.getString("CLABE"),
									rs.getDouble("SALDO"), rs.getString("NUM_CUENTA"),
									rs.getInt("TIPO_ID"), rs.getInt("CLIENTE_ID"));
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return cuenta;
	}

	@Override
	public String eliminar(int id) {
		
		String query="DELETE FROM CUENTA WHERE CUENTA_ID = "+id;
		
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
	

}
