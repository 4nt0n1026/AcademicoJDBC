package com.ads.bd2.academico.app;

import java.awt.geom.CubicCurve2D;
import java.time.LocalDate;

import com.ads.bd2.academico.modelo.Aluno;
import com.ads.bd2.academico.modelo.Curso;
import com.ads.bd2.academico.persistencia.DAOJDBC;
import com.ads.bd2.academico.persistencia.DAOJDBCAluno;
import com.ads.bd2.academico.persistencia.DAOJDBCCurso;

public class Teste {

	public static void main(String[] args) {
		DAOJDBCCurso dao = new DAOJDBCCurso();
		Curso curso = new Curso();
		curso.setCodigo(1);
		Curso curso2 = dao.find(curso, true);
		System.out.println(curso2.getAlunos().size());
	}

}
