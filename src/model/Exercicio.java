package model;

import java.util.Objects;

public class Exercicio {
    private Integer id;
    private String nome;
    private String grupoMuscular;
    private String descricao;
    private Integer idEquipamento;

    public Exercicio() {
    }

    public Exercicio(Integer id, String grupoMuscular, String nome, String descricao, Integer idEquipamento) {
        this.id = id;
        this.grupoMuscular = grupoMuscular;
        this.nome = nome;
        this.descricao = descricao;
        this.idEquipamento = idEquipamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exercicio exercicio = (Exercicio) o;
        return Objects.equals(id, exercicio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
