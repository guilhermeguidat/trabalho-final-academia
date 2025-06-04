package controller;

import dao.InstrutorDAO;
import model.Instrutor;

import java.util.List;

public class InstrutorController {
    private InstrutorDAO instrutorDAO;

    public InstrutorController(InstrutorDAO instrutorDAO) {
        this.instrutorDAO = instrutorDAO;
    }

    public void adicionarInstrutor(String nome, String telefone) {
        Instrutor instrutor = new Instrutor();
        instrutor.setNome(nome);
        instrutor.setTelefone(telefone);
        instrutorDAO.inserir(instrutor);
        System.out.println("Instrutor adicionado com sucesso!");
    }

    public void atualizarInstrutor(int id, String nome, String telefone) {
        Instrutor instrutor = instrutorDAO.buscarPorId(id);
        if (instrutor != null) {
            instrutor.setNome(nome);
            instrutor.setTelefone(telefone);
            instrutorDAO.atualizar(instrutor);
            System.out.println("Instrutor atualizado com sucesso!");
        } else {
            System.out.println("Instrutor com ID " + id + " não encontrado.");
        }
    }

    public void removerInstrutor(int id) {
        instrutorDAO.deletar(id);
        System.out.println("Instrutor deletado com sucesso!");
    }

    public Instrutor buscarInstrutorPorId(int id) {
        return instrutorDAO.buscarPorId(id);
    }

    public List<Instrutor> listarTodosInstrutores() {
        return instrutorDAO.listarTodos();
    }
}
