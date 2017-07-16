package com.ads.bd2.academico.persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ads.bd2.academico.modelo.Aluno;
import com.ads.bd2.academico.modelo.Curso;

public class DAOJDBCCurso extends DAOJDBC<Curso> {

	@Override
	public void create(Curso object) {
		String sql = "INSERT INTO public.curso(	nome, coodernador, cargahoraria)	VALUES (?, ?, ?);";
		if (object != null) {
			init();
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, object.getNome());
				statement.setString(2, object.getCoordenador());
				statement.setInt(3, object.getCargaHoraria());
				statement.executeUpdate();
				System.out.println("Curso cadastrado com sucesso!");

			} catch (SQLException e) {
				e.printStackTrace();
			}
			close();
		}
	}

	@Override
	public void delete(Curso object) {
		String sql = "DELETE FROM curso	WHERE codigo=?;";
		if (object != null){
			init();
			try{
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, object.getCodigo());
				statement.executeUpdate();
				System.out.println("Curso removido com sucesso!");
			}catch (Exception e) {
				e.printStackTrace();
			}
			close();
		}

	}

	@Override
	public void update(Curso object) {


	}

	public void update(Curso object, boolean cascade) {
		//Implementaremos um update em cascata aqui (o curso + os alunos).
		//chame o update do curso para atualizar o o curso em si.
		
		//se cascade true, caso não haja nenhum aluno no curso passado, remover vínculos dos alunos no banco também.
		//Caso haja algum aluno, remova os vínculos dos alunos que o curso já tinha no banco primeiro, para limpar. 
		//Em seguida, vincule os alunos contidos no curso passado como parâmetro neste método.
		//Caso alguns dos alunos presentes no curso passado como parâmetro já exista no banco, considerando que eles
		//podem ter algum atributo atualizado, atualize esses alunos também (use o dao do aluno nessa situação para evitar retrabalho)
	}

	@Override
	public Curso find(Curso object) {
		//colete o atributo que identifica o curso e o recupere do banco.
		//devolva um objeto curso com essas informações, mapeando as colunas do
		//ResultSet como atributos desse curso.
		String sql = "SELECT nome, codigo, coodernador, cargahoraria FROM public.curso WHERE codigo = ?;";
		if(object != null){
			init();
			try{				
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, object.getCodigo());
				ResultSet resultado = statement.executeQuery();
				if(resultado.next()){
					Curso curso = new Curso();
					curso.setNome(resultado.getString(1));
					curso.setCodigo(resultado.getInt(2));
					curso.setCoordenador(resultado.getString(3));
					curso.setCargaHoraria(resultado.getInt(4));
					return curso;
				}
				else{
					throw new Exception("Curso não encontrado!");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		close();
		return null;
	}

	public Curso find(Curso object, boolean cascade) {
		//colete o atributo que identifica o curso e o recupere do banco.
		//devolva um objeto curso com essas informações, mapeando as colunas do
		//ResultSet como atributos desse curso.
		DAOJDBCAluno daoAluno = new DAOJDBCAluno();
		Curso curso = find(object);
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		//se cascade for true, traga os alunos e os adicione ao curso, se tiverem alunos neste curso no banco.
		if (cascade == true){
			String sql = "SELECT matricula_aluno FROM public.curso_aluno WHERE codigo_curso=?;";
			try{
				init();
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, curso.getCodigo());
				ResultSet resultado = statement.executeQuery();
				while(resultado.next()){
					Aluno aluno = new Aluno();
					aluno.setMatricula(resultado.getInt("matricula_aluno"));
					Aluno alunoCerto = daoAluno.find(aluno);
					alunos.add(alunoCerto);
				}
				curso.setAlunos(alunos);
				return curso;
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return null;
	}
	
	public void matricularAluno(Aluno aluno, Curso curso){
		System.out.println(curso.getCodigo());
		String sql = "INSERT INTO curso_aluno(matricula_aluno, codigo_curso)	VALUES (?, ?);";
		DAOJDBCAluno a = new DAOJDBCAluno();
		if (aluno != null && curso != null){
			
			if(find(curso) != null && a.find(aluno) != null){				
				try {		
					init();
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, aluno.getMatricula());					
					statement.setInt(2, curso.getCodigo());
					statement.executeUpdate();
					System.out.println("Aluno cadastrado no curso com sucesso!");								
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}				
			}			
		}
		
	}
	
	public void desmatricularAluno(Aluno aluno, Curso curso) {
		String sql = "DELETE FROM public.curso_aluno WHERE matricula_aluno = ? and codigo_curso = ?;";
		DAOJDBCAluno a = new DAOJDBCAluno();
		if (aluno != null && curso != null){
			if(find(curso) != null && a.find(aluno) != null){
				try {		
					init();
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, aluno.getMatricula());					
					statement.setInt(2, curso.getCodigo());
					statement.executeUpdate();
					System.out.println("Aluno desmatriculado do curso com sucesso!");
					close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}					
			}
		}		
	}
	
	public void delete(Curso curso, boolean cascade) {
		
		if(cascade==true && curso.getCodigo()>0) {			
			String sql = "DELETE FROM public.curso_aluno WHERE codigo_curso = ?;";
			try {		
				init();
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, curso.getCodigo());					
				statement.executeUpdate();						
				delete(curso);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}				
		}	
	}
}
