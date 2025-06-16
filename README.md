# 🏋️‍♂️ Trabalho Final - Sistema de Academia

Este é um sistema de gerenciamento para academias desenvolvido como projeto final. O sistema permite o cadastro de alunos, instrutores, exercícios, equipamentos, além da criação de fichas de treino personalizadas.

---

> Documentação do projeto [Documentacao_Projeto_Academia.pdf](Documentacao_Projeto_Academia.pdf).

## 📦 Funcionalidades Principais

- Cadastro de alunos, instrutores, exercícios e equipamentos
- Criação e gerenciamento de fichas de treino
- Relatórios em PDF com detalhes das fichas
- Interface gráfica com Java Swing
- Integração com banco de dados MySQL

---

## 🧰 Tecnologias Utilizadas

- Java (JDK 21)
- MySQL
- JDBC
- JasperReports (para geração de relatórios)
- Java Swing (interface gráfica)

---

## 📚 Bibliotecas Necessárias (JARs)  
Como o projeto não utiliza Maven, todas as bibliotecas externas necessárias estão incluídas na pasta:

```bash
/libs
```

Você deve adicioná-las manualmente ao classpath do projeto na sua IDE (ex: NetBeans):

- Clique com o botão direito em Libraries no NetBeans

- Selecione Add JAR/Folder

- Navegue até a pasta libs/ e selecione todos os arquivos .jar

As bibliotecas incluem o driver JDBC do MySQL e os arquivos necessários para o JasperReports.

---

## 🚀 Instruções de Execução

### 1. Clone o repositório

```bash
git clone https://github.com/guilhermeguidat/trabalho-final-academia.git
cd trabalho-final-academia
```

### 2. Configure o banco de dados MySQL

- Crie um banco chamado academia_projeto no seu MySQL
  
```sql
CREATE DATABASE academia_projeto;
```

- Execute o dump SQL de criação das tabelas (dump_mysql_projeto.sql)
  
- Atualize as credenciais de conexão no arquivo ConnectionFactory.java:

```java
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

### 3. Compile e execute o projeto

## ✔️ Usando uma IDE (recomendado)
Importe o projeto no NetBeans.

- Execute a classe TelaPrincipal.java ou Main.java

### 4. Geração de Relatórios

- Os relatórios em PDF são gerados com o JasperReports.

- Verifique se o caminho do arquivo .jrxml no código está correto:

```java
String arquivo = "src/util/reports/fichaAcademia.jrxml";
```

## 📎 Observações
- Para melhor funcionamento, utilize Java 21.

- Certifique-se de que o driver JDBC do MySQL está disponível no classpath.

- Caso os relatórios não sejam gerados, revise os caminhos dos arquivos .jrxml e a estrutura do banco.

## 👨‍💻 Autores

- Guilherme Guida Torres - @guilhermeguidat  
- Pedro Correa De Sousa Quadros - @pedroquadros2005
- Tiago Alves de Souza Lima - @tiagodslima
- João César serwinks silva - @Jaozinn17  
- Gabriel Leal de Oliveira - @Gabrielleal29
