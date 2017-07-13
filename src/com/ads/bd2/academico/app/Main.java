package com.ads.bd2.academico.app;
import java.time.LocalDate;

import com.ads.bd2.academico.modelo.Aluno;
import com.ads.bd2.academico.modelo.Curso;
import com.ads.bd2.academico.persistencia.DAOJDBC;
import com.ads.bd2.academico.persistencia.DAOJDBCAluno;
import com.ads.bd2.academico.persistencia.DAOJDBCCurso;

/**
 * Esta classe simula o uso das especializações da interface criada para persistência em JDBC,
 * por meio da classe {@link DAOJDBC}. 
 * 
 * Crie um banco de nome bd2_academico em seu SGBD Postgresql.
 * Aplique o script de banco presente no arquivo BD.sql (acompanha este projeto), para criar as tabelas
 * que permitirão a persistência de objetos Aluno e Curso, bem como vínculos entre elas.
 * 
 * Implemente os métodos de acordo com os comentários presentes acima de cada um deles.
 * Esses métodos são estáticos já que os chamaremos no método main (que também é estático!), 
 * evitando a necessidade de instanciar essa classe para realização das chamadas. 
 * Deixe-os na ordem de chamada proposta.
 * 
 * Todo o código de uso da API JDBC deverá ficar apenas nos DAOs. 
 * Aqui nesta classe somente chamaremos os métodos disponibilizados por esses DAOs.
 * 
 * Faça em dupla e traga sua implementação até a próxima aula de BD2!
 * Adicione os autores para identificar o código da dupla, como abaixo
 *  
 * @author Giuseppe 1
 * @author Giuseppe 2
 *
 */
public class Main {

	public static void main(String[] args) {
		//criando 6 alunos (implemente o método abaixo)
		criarAlunos(6);
		
		//criando 2 cursos (implemente o método abaixo)
		criarCursos(2);
		
		//Matricule 3 alunos num curso e outros 3 num segundo curso.
		//Matricula 1 mesmo aluno nos 2 cursos. 
		//Você deverá recuperar o curso passado como parâmetro usando o find() da classe {@link DAOJDBCCurso} 
		//Você deverá recuperar os alunos passados como parâmetro usando o find() da classe {@link DAOJDBCAluno}
		//Você deverá adicionar os alunos nos respectivos objetos dos cursos.
		//Para cada matriculada de alunos num curso, chame o método comentado abaixo (implemente-o primeiro)...
		//matricularAlunoNoCurso(alunos, curso); 
		//matricularAlunoNoCurso(alunos, curso); 
		
		//Desmatricule 1 aluno de um curso e 1 do segundo curso.
		//Você deverá recuperar o curso passado como parâmetro usando o find() da classe {@link DAOJDBCCurso} 
		//Você deverá recuperar os alunos passados como parâmetro usando o find() da classe {@link DAOJDBCAluno}
		//Você deverá retirar os alunos nos respectivos objetos dos cursos.
		//Para cada desmatriculada de um aluno num curso, chame o método comentado abaixo (implemente-o primeiro)...
		//desmatricularAlunoNoCurso(aluno, curso);
		//desmatricularAlunoNoCurso(aluno, curso);
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Crie alunos e persista eles com o DAOJDBCAluno, usando seu método create(), na quantidade indicada no parâmetro 
	 * quantidade desse método.
	 * 
	 * COMO VERIFICAR?
	 * Acesse o seu banco de dados e verifique se a tabela contém os objetos persistidos.	 * 
	 */
	public static void criarAlunos(int quantidade) {
		for (int i = 0; i < quantidade-1; i++) {
			Aluno aluno = new Aluno();
			//aluno.setDataMatricula(LocalDate.now());
			aluno.setMatricula(1);
			aluno.setNome("Giuseppe");
			
			DAOJDBC<Aluno> daoAluno = new DAOJDBCAluno();
			daoAluno.create(aluno);
		}
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Crie cursos e persista eles com o DAOJDBCCurso, usando o método create(), na quantidade indicada no parâmetro 
	 * quantidade desse método.
	 * 
	 * COMO VERIFICAR?
	 * Acesse o seu banco de dados e verifique se a tabela contém os objetos persistidos.	 * 
	 */
	public static void criarCursos(int quantidade) {
		
		
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Você deverá fazer um update() dos curso considerado usando {@link DAOJDBCCurso} para persistir as alterações do curso e de seus alunos.
	 *   
	 * COMO VERIFICAR?
	 * Veja se a tabela para relação N:N entre curso e aluno contém os valores esperados. 
	 */	
	public static void matricularAlunoNoCurso(Aluno[] alunos, Curso curso) {
		
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Você deverá fazer um update() do curso considerado usando {@link DAOJDBCCurso} para persistir as alterações do curso e de seus alunos.
	 *   
	 * COMO VERIFICAR?
	 * Veja se a tabela para relação N:N entre curso e aluno contém os valores esperados. 
	 */	
	public static void desmatricularAlunoNoCurso(Aluno aluno, Curso curso) {
		
	}
	
	

}
