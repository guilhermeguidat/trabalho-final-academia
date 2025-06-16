package dao;

import model.Exercicio;
import db.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.FichaExercicio;

public class ExercicioDAO {

    private Connection connection;

    public ExercicioDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Exercicio exercicio) {
        String sql = "INSERT INTO exercicio (nome, grupo_muscular, id_equipamento) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getGrupoMuscular());
            if (exercicio.getIdEquipamento() != null) {
                stmt.setInt(3, exercicio.getIdEquipamento());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        exercicio.setId(rs.getInt(1));
                    }
                }
            } else {
                throw new SQLException("Falha ao inserir exercício, nenhuma linha afetada.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir exercício", e);
        }
    }

    public void atualizar(Exercicio exercicio) {
        String sql = "UPDATE exercicio SET nome = ?, grupo_muscular = ?, id_equipamento = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getGrupoMuscular());
            if (exercicio.getIdEquipamento() != null) {
                stmt.setInt(3, exercicio.getIdEquipamento());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }
            stmt.setInt(4, exercicio.getId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Nenhum exercício atualizado, id não encontrado: " + exercicio.getId());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar exercício", e);
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM exercicio WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Nenhum exercício deletado, id não encontrado: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar exercício", e);
        }
    }

    public Exercicio buscarPorId(int id) {
        String sql = "SELECT * FROM exercicio WHERE id = ?";
        Exercicio exercicio = null;

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    exercicio = new Exercicio();
                    exercicio.setId(rs.getInt("id"));
                    exercicio.setNome(rs.getString("nome"));
                    exercicio.setGrupoMuscular(rs.getString("grupo_muscular"));
                    int idEquip = rs.getInt("id_equipamento");
                    if (!rs.wasNull()) {
                        exercicio.setIdEquipamento(idEquip);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar exercício por id", e);
        }

        return exercicio;
    }

    public List<Exercicio> listarTodos() {
        String sql = "SELECT * FROM exercicio";
        List<Exercicio> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Exercicio exercicio = new Exercicio();
                exercicio.setId(rs.getInt("id"));
                exercicio.setNome(rs.getString("nome"));
                exercicio.setGrupoMuscular(rs.getString("grupo_muscular"));
                int idEquip = rs.getInt("id_equipamento");
                if (!rs.wasNull()) {
                    exercicio.setIdEquipamento(idEquip);
                }
                lista.add(exercicio);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar exercícios", e);
        }

        return lista;
    }
}
