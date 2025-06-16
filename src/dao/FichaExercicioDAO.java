package dao;

import db.ConnectionFactory;
import model.FichaExercicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Exercicio;

public class FichaExercicioDAO {
    private Connection connection;

    public FichaExercicioDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(FichaExercicio fe) {
        String sql = "INSERT INTO Ficha_Exercicio (id_ficha, id_exercicio, series, repeticoes, divisao) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, fe.getIdFicha());
            stmt.setInt(2, fe.getIdExercicio());
            stmt.setInt(3, fe.getSeries());
            stmt.setInt(4, fe.getRepeticoes());
            stmt.setString(5, fe.getDivisao());

            stmt.executeUpdate();
            System.out.println("Exercício adicionado à ficha com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao adicionar exercício na ficha", e);
        }
    }

    public void atualizar(FichaExercicio fe) {
        String sql = "UPDATE Ficha_Exercicio SET series = ?, repeticoes = ?, divisao = ? WHERE id_ficha = ? AND id_exercicio = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, fe.getSeries());
            stmt.setInt(2, fe.getRepeticoes());
            stmt.setString(3, fe.getDivisao());
            stmt.setInt(4, fe.getIdFicha());
            stmt.setInt(5, fe.getIdExercicio());

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
                            rs.getInt("repeticoes"),
                            rs.getString("divisao")
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
                            rs.getInt("repeticoes"),
                            rs.getString("divisao")
                    );
                    lista.add(fe);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar exercícios da ficha", e);
        }

        return lista;
    }
    
    public List<FichaExercicio> listarExerciciosPorFichaEDivisao(int idFicha, String divisao) {
        String sql = """
        SELECT E.id, E.nome, E.grupo_muscular, E.id_equipamento,
               FE.series, FE.repeticoes
        FROM exercicio E
        JOIN ficha_exercicio FE ON E.id = FE.id_exercicio
        WHERE FE.id_ficha = ? AND FE.divisao = ?
    """;

        List<FichaExercicio> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFicha);
            stmt.setString(2, divisao);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Exercicio exercicio = new Exercicio();
                    exercicio.setId(rs.getInt("id"));
                    exercicio.setNome(rs.getString("nome"));
                    exercicio.setGrupoMuscular(rs.getString("grupo_muscular"));
                    int idEquip = rs.getInt("id_equipamento");
                    if (!rs.wasNull()) {
                        exercicio.setIdEquipamento(idEquip);
                    }

                    FichaExercicio fichaEx = new FichaExercicio();
                    fichaEx.setIdExercicio(exercicio.getId());
                    fichaEx.setSeries(rs.getInt("series"));
                    fichaEx.setRepeticoes(rs.getInt("repeticoes"));

                    lista.add(fichaEx);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar exercícios por ficha e divisão", e);
        }

        return lista;
    }
}
