package controller;

import dao.EquipamentoDAO;
import model.Equipamento;

import java.util.List;

public class EquipamentoController {
    private EquipamentoDAO equipamentoDAO;

    public EquipamentoController(EquipamentoDAO equipamentoDAO) {
        this.equipamentoDAO = equipamentoDAO;
    }

    public void adicionarEquipamento(String nome, String tipo) {
        Equipamento equipamento = new Equipamento();
        equipamento.setNome(nome);
        equipamento.setTipo(tipo);
        equipamentoDAO.inserir(equipamento);
        System.out.println("Equipamento adicionado com sucesso! ID: " + equipamento.getId());
    }

    public void atualizarEquipamento(int id, String novoNome, String novoTipo) {
        Equipamento equipamento = new Equipamento();
        equipamento.setId(id);
        equipamento.setNome(novoNome);
        equipamento.setTipo(novoTipo);
        equipamentoDAO.atualizar(equipamento);
        System.out.println("Equipamento atualizado com sucesso! ID: " + id);
    }

    public void removerEquipamento(int id) {
        try {
            Equipamento equipamento = equipamentoDAO.buscarPorId(id);
            if (equipamento != null) {
                equipamentoDAO.deletar(id);
                System.out.println("Equipamento removido com sucesso! ID: " + id);
            } else {
                System.out.println("Equipamento com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover equipamento: " + e.getMessage());
        }
    }

    public Equipamento buscarEquipamentoPorId(int id) {
        return equipamentoDAO.buscarPorId(id);
    }

    public List<Equipamento> listarTodosEquipamentos() {
        return equipamentoDAO.listarTodos();
    }

}
