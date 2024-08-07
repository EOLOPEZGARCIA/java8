package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Principal {
	
	public static void main(String[] args) {
		
		//Consumo de la db mediante JDBC
		Connection con=null; //Apertura de la conexion
		PreparedStatement ps = null; // entrada de sentencias
		ResultSet rs = null; //salida de resultados
		
		String query = "select * from autos";
		String insert ="INSERT INTO AUTOS(MODELO,AÑO,TIPO,MARCA_ID) VALUES(?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "admin");
			ps= con.prepareStatement(insert);
			//ps= con.prepareStatement(query);
			//rs=ps.executeQuery(); LECTURA
			
			//LECTURA
//			while(rs.next()) {
//				System.out.println(rs.getInt("MODELO_ID")+":"+rs.getString("MODELO")+":"+
//									rs.getString("TIPO")+":"+rs.getInt("AÑO")+":"+rs.getInt("MARCA_ID"));
//			}
//			
			
			//INSERCION
			//ps.setInt(1,"null" );
			ps.setString(1, "prius"); 
			ps.setInt(2,2016 );
			ps.setString(3, "hatchback");
			ps.setInt(4, 5);
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Insercion exitosa");
			}else {
			System.out.println("Error al insertar");
			}
			
			
					
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
	}

}
