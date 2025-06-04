package dao;

import model.Instrutor;
import db.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO {
    private Connection connection;

    public InstrutorDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Instrutor instrutor) {
        String sql = "INSERT INTO Instrutor (nome, telefone) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getTelefone());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        instrutor.setId(rs.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir instrutor", e);
        }
    }

    public void atualizar(Instrutor instrutor) {
        String sql = "UPDATE Instrutor SET nome = ?, telefone = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getTelefone());
            stmt.setInt(3, instrutor.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar instrutor", e);
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM Instrutor WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar instrutor", e);
        }
    }

    public Instrutor buscarPorId(int id) {
        String sql = "SELECT * FROM Instrutor WHERE id = ?";
        Instrutor instrutor = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    instrutor = new Instrutor();
                    instrutor.setId(rs.getInt("id"));
                    instrutor.setNome(rs.getString("nome"));
                    instrutor.setTelefone(rs.getString("telefone"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar instrutor por id", e);
        }

        return instrutor;
    }

    public List<Instrutor> listarTodos() {
        String sql = "SELECT * FROM Instrutor";
        List<Instrutor> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Instrutor instrutor = new Instrutor();
                instrutor.setId(rs.getInt("id"));
                instrutor.setNome(rs.getString("nome"));
                instrutor.setTelefone(rs.getString("telefone"));
                lista.add(instrutor);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar instrutores", e);
        }

        return lista;
    }
}
