package com.ads.bd2.academico.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DAOJDBC<O> {
	
	Connection conn  = null;

	public void init() {
		if (conn == null) {
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd2_academico", "postgres", "1234"); 
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
	
	public void zerarBanco(){
		try{
			init();
			String sql = "DELETE FROM public.curso_aluno; "
					+ "DELETE FROM public.aluno; "
					+ "DELETE FROM public.curso; "
					+ "ALTER SEQUENCE aluno_matricula_seq RESTART WITH 1; "
					+ "UPDATE aluno SET matricula=nextval('aluno_matricula_seq'); "
					+ "ALTER SEQUENCE curso_codigo_seq RESTART WITH 1; "
					+ "UPDATE curso SET codigo=nextval('curso_codigo_seq'); ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			System.out.println("Banco zerado com sucesso!");
		}catch (Exception e) {
			System.out.println("Erro ao zerar banco!");
		}

	}
	
	public abstract void create(O object);
	
	public abstract void delete(O object);
	
	public abstract void update(O object);
	
	public abstract O find(O object);
	
}
