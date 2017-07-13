package com.ads.bd2.academico.app;

import java.time.LocalDate;

import com.ads.bd2.academico.modelo.Aluno;
import com.ads.bd2.academico.persistencia.DAOJDBC;
import com.ads.bd2.academico.persistencia.DAOJDBCAluno;

public class Teste {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setNome("JADSON");
		aluno.setDataMatricula(LocalDate.now());
		
		DAOJDBC<Aluno> db = new DAOJDBCAluno();
		db.create(aluno);
		//Aluno aluno2 = db.find(aluno);
		//System.out.println(aluno2.getNome());

	}

}
