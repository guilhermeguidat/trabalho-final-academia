CREATE DATABASE academia_projeto;
USE academia_projeto;

CREATE TABLE Instrutor (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome TEXT NOT NULL,
    telefone TEXT
);

CREATE TABLE Aluno (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome TEXT NOT NULL,
    telefone TEXT
);

CREATE TABLE Equipamento (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome TEXT NOT NULL,
    tipo TEXT
);

CREATE TABLE Exercicio (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome TEXT NOT NULL,
    grupo_muscular TEXT,
    id_equipamento INTEGER,
    FOREIGN KEY (id_equipamento) REFERENCES Equipamento(id)
);

CREATE TABLE Ficha (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_aluno INTEGER NOT NULL,
    id_instrutor INTEGER,
    objetivo TEXT,
    FOREIGN KEY (id_aluno) REFERENCES Aluno(id),
    FOREIGN KEY (id_instrutor) REFERENCES Instrutor(id)
);

CREATE TABLE Ficha_Exercicio (
    id_ficha INTEGER,
    id_exercicio INTEGER,
    series INTEGER,
    repeticoes INTEGER,
    PRIMARY KEY (id_ficha, id_exercicio),
    FOREIGN KEY (id_ficha) REFERENCES Ficha(id),
    FOREIGN KEY (id_exercicio) REFERENCES Exercicio(id)
);
