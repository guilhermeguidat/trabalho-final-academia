package controller;

import dao.AlunoDAO;
import model.Aluno;

import java.sql.SQLException;
import java.util.List;

public class AlunoController {
    private AlunoDAO alunoDAO;

    public AlunoController(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public void adicionarAluno(String nome, String telefone) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        alunoDAO.inserir(aluno);
        System.out.println("Aluno adicionado com sucesso! ID: " + aluno.getId());
    }

    public void atualizarAluno(int id, String nome, String telefone) throws SQLException {
        Aluno aluno = alunoDAO.buscarPorId(id);
        if (aluno != null) {
            aluno.setNome(nome);
            aluno.setTelefone(telefone);
            alunoDAO.atualizar(aluno);
            System.out.println("Aluno atualizado com sucesso!");
        } else {
            System.out.println("Aluno com ID " + id + " não encontrado.");
        }
    }

    public void removerAluno(int id) throws SQLException {
        Aluno aluno = alunoDAO.buscarPorId(id);
        if (aluno != null) {
            alunoDAO.deletar(id);
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno com ID " + id + " não encontrado.");
        }
    }

    public Aluno buscarAlunoPorId(int id) throws SQLException {
        return alunoDAO.buscarPorId(id);
    }

    public List<Aluno> listarTodosAlunos() throws SQLException {
        return alunoDAO.listarTodos();
    }
}
