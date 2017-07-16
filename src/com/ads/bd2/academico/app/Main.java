package com.ads.bd2.academico.app;
import java.time.LocalDate;
import java.util.ArrayList;

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
 * @author Jadson 1
 * @author Vitor 2
 *
 */
public class Main {
	

	public static void main(String[] args) {
		
		DAOJDBCAluno DAOAluno = new DAOJDBCAluno();
		DAOJDBCCurso DAOCurso = new DAOJDBCCurso();
		
		DAOAluno.zerarBanco();
		//criando 6 alunos (implemente o m�todo abaixo)
		criarAlunos(6);
		
		
		//criando 2 cursos (implemente o m�todo abaixo)
		criarCursos(2);
		
		
		//Matricule 3 alunos num curso e outros 3 num segundo curso.
		//CRIANDO ALUNOS
		Aluno aluno1 = new Aluno();
		aluno1.setMatricula(1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setMatricula(2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setMatricula(3);				
		
		Aluno aluno4 = new Aluno();
		aluno4.setMatricula(4);
		
		Aluno aluno5 = new Aluno();
		aluno5.setMatricula(5);
		
		Aluno aluno6 = new Aluno();
		aluno6.setMatricula(6);
		
		//ENTURMANDO ALUNOS
		ArrayList<Aluno>turma1 = new ArrayList<Aluno>();
		turma1.add(aluno1);turma1.add(aluno2);turma1.add(aluno3);
		
		ArrayList<Aluno>turma2 = new ArrayList<Aluno>();
		turma2.add(aluno4);turma2.add(aluno5);turma2.add(aluno6);
		
		//CRIANDO CURSOS
		Curso curso1 = new Curso();
		curso1.setCodigo(1);
		
		Curso curso2 = new Curso();
		curso2.setCodigo(2);
		
		
		//MATRICULANDO
		matricularAlunoNoCurso(turma1, curso1);
		matricularAlunoNoCurso(turma2, curso2);
		
		
		//Matricula 1 mesmo aluno nos 2 cursos. 
		ArrayList<Aluno> turma3 = new ArrayList<Aluno>();
		turma3.add(aluno1);
		matricularAlunoNoCurso(turma3, curso1);
		matricularAlunoNoCurso(turma3, curso2);
		
		
		//Voc� dever� recuperar o curso passado como par�metro usando o find() da classe {@link DAOJDBCCurso} 
		curso1 = DAOCurso.find(curso1);
		System.out.println(curso1.getNome());
				
		//Voc� dever� recuperar os alunos passados como par�metro usando o find() da classe {@link DAOJDBCAluno}
		aluno1 = DAOAluno.find(aluno1);
		System.out.println(aluno1.getNome());		
		
		//Voc� dever� adicionar os alunos nos respectivos objetos dos cursos.
		curso1 = DAOCurso.find(curso1,true);
		curso2 = DAOCurso.find(curso2,true);
		System.out.println(curso1.getAlunos().size());
		System.out.println(curso2.getAlunos().size());
		
		
		//Para cada matriculada de alunos num curso, chame o m�todo comentado abaixo (implemente-o primeiro)...
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(aluno1);alunos.add(aluno2);alunos.add(aluno3);
		alunos.add(aluno4);alunos.add(aluno5);alunos.add(aluno6);
		
		criarCursos(2);
		
		Curso curso3 = new Curso();
		curso3.setCodigo(3);		
		Curso curso4 = new Curso();
		curso4.setCodigo(4);
		
		matricularAlunoNoCurso(alunos, curso3); 
		matricularAlunoNoCurso(alunos, curso4); 
		
		//Desmatricule 1 aluno de um curso e 1 do segundo curso.
		desmatricularAlunoNoCurso(aluno1, curso1);
		desmatricularAlunoNoCurso(aluno3, curso2);
		
		//Voc� dever� recuperar o curso passado como par�metro usando o find() da classe {@link DAOJDBCCurso} 
		curso3 = DAOCurso.find(curso3);
		
		//Voc� dever� recuperar os alunos passados como par�metro usando o find() da classe {@link DAOJDBCAluno}
		aluno1 = DAOAluno.find(aluno1);aluno2 = DAOAluno.find(aluno2);aluno3 = DAOAluno.find(aluno3);
		aluno4 = DAOAluno.find(aluno4);aluno5 = DAOAluno.find(aluno5);aluno6 = DAOAluno.find(aluno6);
		
		//Voc� dever� retirar os alunos nos respectivos objetos dos cursos.
		alunos = (ArrayList<Aluno>) curso3.getAlunos();
		
		//Para cada desmatriculada de um aluno num curso, chame o m�todo comentado abaixo (implemente-o primeiro)...
		desmatricularAlunoNoCurso(aluno1, curso3);
		desmatricularAlunoNoCurso(aluno2, curso3);
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
		for (int i = 0; i < quantidade; i++) {
			Aluno aluno = new Aluno();
			aluno.setDataMatricula(LocalDate.now());
			//aluno.setMatricula(1);
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
		
		for (int i = 0; i < quantidade; i++) {
			Curso curso = new Curso();
			curso.setNome("ADS");
			curso.setCoordenador("Emanuel");
			curso.setCargaHoraria(120);
			
			DAOJDBC<Curso> daoCurso = new DAOJDBCCurso();
			daoCurso.create(curso);
		}
		
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Voc� dever� fazer um update() dos curso considerado usando {@link DAOJDBCCurso} para persistir as altera��es do curso e de seus alunos.
	 *   
	 * COMO VERIFICAR?
	 * Veja se a tabela para rela��o N:N entre curso e aluno cont�m os valores esperados. 
	 */	
	public static void matricularAlunoNoCurso(ArrayList<Aluno> alunos, Curso curso) {
		DAOJDBCCurso daoCurso = new DAOJDBCCurso();
		for(Aluno a: alunos) {
			daoCurso.matricularAluno(a, curso);			
		}
		daoCurso.close();                            
	}
	
	/**
	 * COMO IMPLEMENTAR?
	 * Voc� dever� fazer um update() do curso considerado usando {@link DAOJDBCCurso} para persistir as altera��es do curso e de seus alunos.
	 *   
	 * COMO VERIFICAR?
	 * Veja se a tabela para rela��o N:N entre curso e aluno cont�m os valores esperados. 
	 */	
	public static void desmatricularAlunoNoCurso(Aluno aluno, Curso curso) {
		DAOJDBCCurso daoCurso = new DAOJDBCCurso();
		daoCurso.desmatricularAluno(aluno, curso);
	}
	

}
