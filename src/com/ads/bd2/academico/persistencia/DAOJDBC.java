package com.ads.bd2.academico.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAOJDBC<O> {
	
	Connection conn  = null;

	public void init() {
		if (conn == null) {
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.108:5432/bd2_academico", "postgres", "1234"); 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void create(O object);
	
	public abstract void delete(O object);
	
	public abstract void update(O object);
	
	public abstract O find(O object);
	
}
