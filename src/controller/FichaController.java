package controller;

import dao.FichaDAO;
import model.Ficha;

import java.util.List;

public class FichaController {
    private FichaDAO fichaDAO;

    public FichaController(FichaDAO fichaDAO) {
        this.fichaDAO = fichaDAO;
    }

    public Ficha adicionarFicha(int idAluno, int idInstrutor, String objetivo) {
        Ficha ficha = new Ficha();
        ficha.setIdAluno(idAluno);
        ficha.setIdIntrutor(idInstrutor);
        ficha.setObjetivo(objetivo);
        fichaDAO.inserir(ficha);
        System.out.println("Ficha adicionada com sucesso! ID: " + ficha.getId());
        return ficha;
    }

    public void atualizarFicha(int id, int idAluno, int idInstrutor, String objetivo) {
        Ficha ficha = fichaDAO.buscarPorId(id);
        if (ficha != null) {
            ficha.setIdAluno(idAluno);
            ficha.setIdIntrutor(idInstrutor);
            ficha.setObjetivo(objetivo);
            fichaDAO.atualizar(ficha);
            System.out.println("Ficha atualizada com sucesso!");
        } else {
            System.out.println("Ficha com ID " + id + " não encontrada.");
        }
    }

    public void removerFicha(int id) {
        fichaDAO.deletar(id);
        System.out.println("Ficha deletada com sucesso!");
    }

    public Ficha buscarFichaPorId(int id) {
        return fichaDAO.buscarPorId(id);
    }

    public List<Ficha> listarTodasFichas() {
        return fichaDAO.listarTodos();
    }
}
