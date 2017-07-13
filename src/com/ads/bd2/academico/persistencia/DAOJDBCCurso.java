package com.ads.bd2.academico.persistencia;

import com.ads.bd2.academico.modelo.Curso;

public class DAOJDBCCurso extends DAOJDBC<Curso> {

	@Override
	public void create(Curso object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Curso object) {
		// TODO Auto-generated method stub

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

		return null;
	}

	public Curso find(Curso object, boolean cascade) {
		//colete o atributo que identifica o curso e o recupere do banco.
		//devolva um objeto curso com essas informações, mapeando as colunas do
		//ResultSet como atributos desse curso.

		//se cascade for true, traga os alunos e os adicione ao curso, se tiverem alunos neste curso no banco.
		return null;
	}

}
