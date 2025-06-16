package controller;

import dao.FichaExercicioDAO;
import model.FichaExercicio;

import java.util.List;

public class FichaExercicioController {
    private FichaExercicioDAO fichaExercicioDAO;

    public FichaExercicioController(FichaExercicioDAO fichaExercicioDAO) {
        this.fichaExercicioDAO = fichaExercicioDAO;
    }

    public void adicionarExercicio(int idFicha, int idExercicio, int series, int repeticoes, String divisao) {
        FichaExercicio fe = new FichaExercicio(idFicha, idExercicio, series, repeticoes, divisao);
        fichaExercicioDAO.inserir(fe);
        System.out.println("Exercício adicionado à ficha com sucesso.");
    }

    public void atualizarExercicioFicha(int idFicha, int idExercicio, int novasSeries, int novasRepeticoes, String divisao) {
        FichaExercicio fe = new FichaExercicio(idFicha, idExercicio, novasSeries, novasRepeticoes, divisao);
        fichaExercicioDAO.atualizar(fe);
        System.out.println("Exercício da ficha atualizado com sucesso.");
    }

    public void removerExercicioFicha(int idFicha, int idExercicio) {
        fichaExercicioDAO.deletar(idFicha, idExercicio);
        System.out.println("Exercício removido da ficha com sucesso.");
    }

    public FichaExercicio buscarExercicioFichaPorId(int idFicha, int idExercicio) {
        return fichaExercicioDAO.buscarPorId(idFicha, idExercicio);
    }

    public List<FichaExercicio> listarTodosExerciciosFicha(int idFicha) {
        return fichaExercicioDAO.listarTodos(idFicha);
    }
    
    public List<FichaExercicio> listarTodosExerciciosFichaEDivisao(int idFicha, String divisao) {
        return fichaExercicioDAO.listarExerciciosPorFichaEDivisao(idFicha, divisao);
    }
}
