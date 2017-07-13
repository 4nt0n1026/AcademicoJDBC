package com.ads.bd2.academico.app;
import java.time.LocalDate;

import com.ads.bd2.academico.modelo.Aluno;
import com.ads.bd2.academico.modelo.Curso;
import com.ads.bd2.academico.persistencia.DAOJDBC;
import com.ads.bd2.academico.persistencia.DAOJDBCAluno;
import com.ads.bd2.academico.persistencia.DAOJDBCCurso;

/**
 * Esta classe simula o uso das especializa��es da interface criada para persist�ncia em JDBC,
 * por meio da classe {@link DAOJDBC}. 
 * 
 * Crie um banco de nome bd2_academico em seu SGBD Postgresql.
 * Aplique o script de banco presente no arquivo BD.sql (acompanha este projeto), para criar as tabelas
 * que permitir�o a persist�ncia de objetos Aluno e Curso, bem como v�nculos entre elas.
 * 
 * Implemente os m�todos de acordo com os coment�rios presentes acima de cada um deles.
 * Esses m�todos s�o est�ticos j� que os chamaremos no m�todo main (que tamb�m � est�tico!), 
 * evitando a necessidade de instanciar essa classe para realiza��o das chamadas. 
 * Deixe-os na ordem de chamada proposta.
 * 
 * Todo o c�digo de uso da API JDBC dever� ficar apenas nos DAOs. 
 * Aqui nesta classe somente chamaremos os m�todos disponibilizados por esses DAOs.
 * 
 * Fa�a em dupla e traga sua implementa��o at� a pr�xima aula de BD2!
 * Adicione os autores para identificar o c�digo da dupla, como abaixo
 *  
 * @author Giuseppe 1
 * @author Giuseppe 2
 *
 */
public class Main {

	public static void main(String[] args) {
		//criando 6 alunos (implemente o m�todo abaixo)
		criarAlunos(6);
		
		//criando 2 cursos (implemente o m�todo abaixo)
		criarCursos(2);
		
		//Matricule 3 alunos num curso e outros 3 num segundo curso.
		//Matricula 1 mesmo aluno nos 2 cursos. 
		//Voc� dever� recuperar o curso passado como par�metro usando o find() da classe {@link DAOJDBCCurso} 
		//Voc� dever� recuperar os alunos passados como par�metro usando o find() da classe {@link DAOJDBCAluno}
		//Voc� dever� adicionar os alunos nos respectivos objetos dos cursos.
		//Para cada matriculada de alunos num curso, chame o m�todo comentado abaixo (implemente-o primeiro)...
		//matricularAlunoNoCurso(alunos, curso); 
		//matricularAlunoNoCurso(alunos, curso); 
		
		//Desmatricule 1 aluno de um curso e 1 do segundo curso.
		//Voc� dever� recuperar o curso passado como par�metro usando o find() da classe {@link DAOJDBCCurso} 
		//Voc� dever� recuperar os alunos passados como par�metro usando o find() da classe {@link DAOJDBCAluno}
		//Voc� dever� retirar os alunos nos respectivos objetos dos cursos.
		//Para cada desmatriculada de um aluno num curso, chame o m�todo comentado abaixo (implemente-o primeiro)...
		//desmatricularAlunoNoCurso(aluno, curso);
		//desmatricularAlunoNoCurso(aluno, curso);
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Crie alunos e persista eles com o DAOJDBCAluno, usando seu m�todo create(), na quantidade indicada no par�metro 
	 * quantidade desse m�todo.
	 * 
	 * COMO VERIFICAR?
	 * Acesse o seu banco de dados e verifique se a tabela cont�m os objetos persistidos.	 * 
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
	 * Crie cursos e persista eles com o DAOJDBCCurso, usando o m�todo create(), na quantidade indicada no par�metro 
	 * quantidade desse m�todo.
	 * 
	 * COMO VERIFICAR?
	 * Acesse o seu banco de dados e verifique se a tabela cont�m os objetos persistidos.	 * 
	 */
	public static void criarCursos(int quantidade) {
		
		
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Voc� dever� fazer um update() dos curso considerado usando {@link DAOJDBCCurso} para persistir as altera��es do curso e de seus alunos.
	 *   
	 * COMO VERIFICAR?
	 * Veja se a tabela para rela��o N:N entre curso e aluno cont�m os valores esperados. 
	 */	
	public static void matricularAlunoNoCurso(Aluno[] alunos, Curso curso) {
		
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Voc� dever� fazer um update() do curso considerado usando {@link DAOJDBCCurso} para persistir as altera��es do curso e de seus alunos.
	 *   
	 * COMO VERIFICAR?
	 * Veja se a tabela para rela��o N:N entre curso e aluno cont�m os valores esperados. 
	 */	
	public static void desmatricularAlunoNoCurso(Aluno aluno, Curso curso) {
		
	}
	
	

}
