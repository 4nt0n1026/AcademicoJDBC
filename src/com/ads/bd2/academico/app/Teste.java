package com.ads.bd2.academico.app;

import com.ads.bd2.academico.modelo.Curso;
import com.ads.bd2.academico.persistencia.DAOJDBCCurso;

public class Teste {

	public static void main(String[] args) {
		Curso curso = new Curso();
		curso.setCodigo(1);	
		curso.setCoordenador("Renata");
		curso.setCargaHoraria(120);
		DAOJDBCCurso dao = new DAOJDBCCurso();
		dao.update(curso, true);
		
	}

}
