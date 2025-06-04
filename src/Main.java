import db.ConnectionFactory;
import controller.*;
import dao.*;
import model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Cria conexão
            Connection conexao = ConnectionFactory.getConnection();

            // 2. Cria DAOs
            AlunoDAO alunoDAO = new AlunoDAO(conexao);
            InstrutorDAO instrutorDAO = new InstrutorDAO(conexao);
            EquipamentoDAO equipamentoDAO = new EquipamentoDAO(conexao);
            ExercicioDAO exercicioDAO = new ExercicioDAO(conexao);
            FichaDAO fichaDAO = new FichaDAO(conexao);
            FichaExercicioDAO fichaExercicioDAO = new FichaExercicioDAO(conexao);

            // 3. Cria Controllers recebendo os DAOs
            AlunoController alunoController = new AlunoController(alunoDAO);
            InstrutorController instrutorController = new InstrutorController(instrutorDAO);
            EquipamentoController equipamentoController = new EquipamentoController(equipamentoDAO);
            ExercicioController exercicioController = new ExercicioController(exercicioDAO);
            FichaController fichaController = new FichaController(fichaDAO);
            FichaExercicioController fichaExercicioController = new FichaExercicioController(fichaExercicioDAO);

            // --- Criar e adicionar dados ---

            System.out.println("==== ADICIONANDO ALUNO ====");
            alunoController.adicionarAluno("João Silva", "11999998888");

            System.out.println("\n==== ADICIONANDO INSTRUTOR ====");
            instrutorController.adicionarInstrutor("Carlos Souza", "11888887777");

            System.out.println("\n==== ADICIONANDO EQUIPAMENTOS ====");
            equipamentoController.adicionarEquipamento("Leg Press", "Perna");
            equipamentoController.adicionarEquipamento("Supino", "Peito");
            equipamentoController.adicionarEquipamento("Puxada Frontal", "Costas");

            List<Equipamento> equipamentos = equipamentoController.listarTodosEquipamentos();

            int idEquip1 = equipamentos.get(0).getId();
            int idEquip2 = equipamentos.get(1).getId();
            int idEquip3 = equipamentos.get(2).getId();

            System.out.println("\n==== ADICIONANDO EXERCÍCIOS ====");
            exercicioController.adicionarExercicio("Agachamento", "Perna", idEquip1);
            exercicioController.adicionarExercicio("Cadeira Extensora", "Perna", idEquip1);
            exercicioController.adicionarExercicio("Supino Reto", "Peito", idEquip2);
            exercicioController.adicionarExercicio("Crucifixo", "Peito", idEquip2);
            exercicioController.adicionarExercicio("Puxada Frente", "Costas", idEquip3);
            exercicioController.adicionarExercicio("Remada Baixa", "Costas", idEquip3);

            List<Exercicio> exercicios = exercicioController.listarTodosExercicios();

            System.out.println("\n==== CRIANDO FICHA ====");
            Aluno aluno = alunoController.buscarAlunoPorId(1);
            Instrutor instrutor = instrutorController.buscarInstrutorPorId(1);

            if (aluno != null && instrutor != null) {
                fichaController.adicionarFicha(aluno.getId(), instrutor.getId(), "Hipertrofia");
            } else {
                System.out.println("Aluno ou Instrutor não encontrados!");
                return;
            }

            List<Ficha> fichas = fichaController.listarTodasFichas();
            int idFicha = fichas.get(fichas.size() - 1).getId();

            System.out.println("\n==== ADICIONANDO EXERCÍCIOS À FICHA ====");
            int series = 3;
            int repeticoes = 12;

            for (Exercicio ex : exercicios) {
                fichaExercicioController.adicionarExercicio(idFicha, ex.getId(), series, repeticoes);
            }

            // --- Imprimir ficha completa ---
            System.out.println("\n==== FICHA COMPLETA ====");
            Ficha ficha = fichaController.buscarFichaPorId(idFicha);
            if (ficha == null) {
                System.out.println("Ficha não encontrada.");
                return;
            }

            Aluno alunoFicha = alunoController.buscarAlunoPorId(ficha.getIdAluno());
            Instrutor instrutorFicha = instrutorController.buscarInstrutorPorId(ficha.getIdIntrutor());

            System.out.println("Ficha ID: " + ficha.getId());
            System.out.println("Objetivo: " + ficha.getObjetivo());

            if (alunoFicha != null) {
                System.out.println("Aluno: " + alunoFicha.getNome() + " - Telefone: " + alunoFicha.getTelefone());
            }
            if (instrutorFicha != null) {
                System.out.println("Instrutor: " + instrutorFicha.getNome() + " - Telefone: " + instrutorFicha.getTelefone());
            }

            System.out.println("\nExercícios da ficha:");
            List<FichaExercicio> fichaExercicios = fichaExercicioController.listarTodosExerciciosFicha(idFicha);
            for (FichaExercicio fe : fichaExercicios) {
                Exercicio ex = exercicioController.buscarExercicioPorId(fe.getIdExercicio());
                if (ex != null) {
                    System.out.println(" - " + ex.getNome() + " (" + ex.getGrupoMuscular() + ") | Séries: "
                            + fe.getSeries() + ", Repetições: " + fe.getRepeticoes());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
