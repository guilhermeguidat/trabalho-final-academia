package dao;

import model.Ficha;
import db.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FichaDAO {
    private Connection connection;

    public FichaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Ficha ficha) {
        String sql = "INSERT INTO Ficha (id_aluno, id_instrutor, objetivo) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, ficha.getIdAluno());
            stmt.setInt(2, ficha.getIdIntrutor());
            stmt.setString(3, ficha.getObjetivo());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        ficha.setId(rs.getInt(1));
                    }
                }
            } else {
                throw new SQLException("Falha ao inserir ficha, nenhuma linha afetada.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir ficha", e);
        }
    }

    public void atualizar(Ficha ficha) {
        String sql = "UPDATE Ficha SET id_aluno = ?, id_instrutor = ?, objetivo = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ficha.getIdAluno());
            stmt.setInt(2, ficha.getIdIntrutor());
            stmt.setString(3, ficha.getObjetivo());
            stmt.setInt(4, ficha.getId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Nenhuma ficha atualizada, id não encontrado: " + ficha.getId());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar ficha", e);
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM Ficha WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Nenhuma ficha deletada, id não encontrado: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar ficha", e);
        }
    }

    public Ficha buscarPorId(int id) {
        String sql = "SELECT * FROM Ficha WHERE id = ?";
        Ficha ficha = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ficha = new Ficha();
                    ficha.setId(rs.getInt("id"));
                    ficha.setIdAluno(rs.getInt("id_aluno"));
                    ficha.setIdIntrutor(rs.getInt("id_instrutor"));
                    ficha.setObjetivo(rs.getString("objetivo"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ficha por id", e);
        }

        return ficha;
    }

    public List<Ficha> listarTodos() {
        List<Ficha> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ficha";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ficha ficha = new Ficha();
                ficha.setId(rs.getInt("id"));
                ficha.setIdAluno(rs.getInt("id_aluno"));
                ficha.setIdIntrutor(rs.getInt("id_instrutor"));
                ficha.setObjetivo(rs.getString("objetivo"));
                lista.add(ficha);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar fichas", e);
        }

        return lista;
    }
}
