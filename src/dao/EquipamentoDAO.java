package dao;

import model.Equipamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    private Connection connection;

    public EquipamentoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Equipamento equipamento) {
        String sql = "INSERT INTO Equipamento (nome, tipo) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getTipo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                equipamento.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir equipamento", e);
        }
    }

    public void atualizar(Equipamento equipamento) {
        String sql = "UPDATE Equipamento SET nome = ?, tipo = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getTipo());
            stmt.setInt(3, equipamento.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar equipamento com ID: " + equipamento.getId(), e);
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM Equipamento WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar equipamento com ID: " + id, e);
        }
    }

    public Equipamento buscarPorId(int id) {
        String sql = "SELECT * FROM Equipamento WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setId(rs.getInt("id"));
                equipamento.setNome(rs.getString("nome"));
                equipamento.setTipo(rs.getString("tipo"));
                return equipamento;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar equipamento por ID", e);
        }

        return null;
    }

    public List<Equipamento> listarTodos() {
        List<Equipamento> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM Equipamento";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setId(rs.getInt("id"));
                equipamento.setNome(rs.getString("nome"));
                equipamento.setTipo(rs.getString("tipo"));
                equipamentos.add(equipamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar equipamentos", e);
        }

        return equipamentos;
    }
}
