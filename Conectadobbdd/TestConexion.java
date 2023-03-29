package Conectadobbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {
	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM credenciales");
			
			while (rs.next()) {
				String nombre = rs.getString(1);
				String mail = rs.getString(2);
				String contraseña = rs.getString(3);
				
				System.out.println(nombre + " - " + mail + " - " + contraseña);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("INSERT INTO credenciales(nombre,mail,contraseña) VALUES (?,?,?)");
			stm2.setString(1 , "paco");
			stm2.setString(2 , "paco@mail.es");
			stm2.setString(3 , "12345678!");
			
			stm2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("UPDATE credenciales SET nombre = ?  WHERE contraseña = ?");
			stm2.setString(1 , "paco");
			stm2.setString(3 , "12345678!");
			
			
			stm2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("DELETE FROM credenciales  WHERE contraseña = ?");
			stm2.setString(1 , "12345678!");
			
			
			stm2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}