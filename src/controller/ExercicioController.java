package controller;

import dao.ExercicioDAO;
import model.Exercicio;

import java.util.List;
import model.Ficha;

public class ExercicioController {
    private ExercicioDAO exercicioDAO;

    public ExercicioController(ExercicioDAO exercicioDAO) {
        this.exercicioDAO = exercicioDAO;
    }

    public void adicionarExercicio(String nome, String grupoMuscular, Integer idEquipamento) {
        Exercicio exercicio = new Exercicio();
        exercicio.setNome(nome);
        exercicio.setGrupoMuscular(grupoMuscular);
        exercicio.setIdEquipamento(idEquipamento);
        exercicioDAO.inserir(exercicio);
        System.out.println("Exercício adicionado com sucesso! ID: " + exercicio.getId());
    }

    public void atualizarExercicio(int id, String nome, String grupoMuscular, Integer idEquipamento) {
        Exercicio exercicio = exercicioDAO.buscarPorId(id);
        if (exercicio != null) {
            exercicio.setNome(nome);
            exercicio.setGrupoMuscular(grupoMuscular);
            exercicio.setIdEquipamento(idEquipamento);
            exercicioDAO.atualizar(exercicio);
            System.out.println("Exercício atualizado com sucesso!");
        } else {
            System.out.println("Exercício com ID " + id + " não encontrado.");
        }
    }

    public void removerExercicio(int id) {
        exercicioDAO.deletar(id);
        System.out.println("Exercício deletado com sucesso!");
    }

    public Exercicio buscarExercicioPorId(int id) {
        return exercicioDAO.buscarPorId(id);
    }

    public List<Exercicio> listarTodosExercicios() {
        return exercicioDAO.listarTodos();
    }
}
