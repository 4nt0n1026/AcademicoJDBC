CREATE TABLE aluno (
	matricula int NOT NULL,
	nome VARCHAR(255) NOT NULL,
	dataMatricula DATE NOT NULL,   
    CONSTRAINT matricula_pk PRIMARY KEY (matricula)    
);

CREATE TABLE curso (
    nome VARCHAR(255) NOT NULL,
	codigo VARCHAR(255) NOT NULL,
	coordenador VARCHAR(255) NOT NULL,   
    cargaHoraria INT NOT NULL,
    CONSTRAINT codigo_pk PRIMARY KEY (codigo)    
);

CREATE TABLE curso_aluno (
    codigo_curso VARCHAR(255) NOT NULL REFERENCES curso(codigo),
    matricula_aluno INT NOT NULL REFERENCES aluno(matricula),	
    CONSTRAINT curso_aluno_pk PRIMARY KEY (codigo_curso, matricula_aluno)    
)

