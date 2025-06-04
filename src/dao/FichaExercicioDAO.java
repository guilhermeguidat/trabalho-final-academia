package dao;

import db.ConnectionFactory;
import model.FichaExercicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FichaExercicioDAO {
    private Connection connection;

    public FichaExercicioDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(FichaExercicio fe) {
        String sql = "INSERT INTO Ficha_Exercicio (id_ficha, id_exercicio, series, repeticoes) VALUES (?, ?, ?, ?)";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, fe.getIdFicha());
            stmt.setInt(2, fe.getIdExercicio());
            stmt.setInt(3, fe.getSeries());
            stmt.setInt(4, fe.getRepeticoes());

            stmt.executeUpdate();
            System.out.println("Exercício adicionado à ficha com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar exercício na ficha", e);
        }
    }

    public void atualizar(FichaExercicio fe) {
        String sql = "UPDATE Ficha_Exercicio SET series = ?, repeticoes = ? WHERE id_ficha = ? AND id_exercicio = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, fe.getSeries());
            stmt.setInt(2, fe.getRepeticoes());
            stmt.setInt(3, fe.getIdFicha());
            stmt.setInt(4, fe.getIdExercicio());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new RuntimeException("Nenhum exercício foi atualizado. Verifique se a ficha e o exercício existem.");
            }

            System.out.println("Exercício da ficha atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar exercício na ficha", e);
        }
    }

    public void deletar(int idFicha, int idExercicio) {
        String sql = "DELETE FROM Ficha_Exercicio WHERE id_ficha = ? AND id_exercicio = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, idFicha);
            stmt.setInt(2, idExercicio);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new RuntimeException("Nenhum exercício foi removido. Verifique se a ficha e o exercício existem.");
            }

            System.out.println("Exercício removido da ficha com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover exercício da ficha", e);
        }
    }

    public FichaExercicio buscarPorId(int idFicha, int idExercicio) {
        String sql = "SELECT * FROM Ficha_Exercicio WHERE id_ficha = ? AND id_exercicio = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, idFicha);
            stmt.setInt(2, idExercicio);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new FichaExercicio(
                            rs.getInt("id_ficha"),
                            rs.getInt("id_exercicio"),
                            rs.getInt("series"),
                            rs.getInt("repeticoes")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar exercício na ficha", e);
        }

        return null;
    }

    public List<FichaExercicio> listarTodos(int idFicha) {
        List<FichaExercicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ficha_Exercicio WHERE id_ficha = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, idFicha);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FichaExercicio fe = new FichaExercicio(
                            rs.getInt("id_ficha"),
                            rs.getInt("id_exercicio"),
                            rs.getInt("series"),
                            rs.getInt("repeticoes")
                    );
                    lista.add(fe);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar exercícios da ficha", e);
        }

        return lista;
    }
}
