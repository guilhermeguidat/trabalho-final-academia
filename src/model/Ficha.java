package model;

import java.util.Objects;

public class Ficha {
    private Integer id;
    private Integer idAluno;
    private Integer idIntrutor;
    private String objetivo;

    public Ficha() {
    }

    public Ficha(Integer idAluno, Integer idIntrutor, String objetivo) {
        this.idAluno = idAluno;
        this.idIntrutor = idIntrutor;
        this.objetivo = objetivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdIntrutor() {
        return idIntrutor;
    }

    public void setIdIntrutor(Integer idIntrutor) {
        this.idIntrutor = idIntrutor;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "Ficha{" +
                "id=" + id +
                ", idAluno=" + idAluno +
                ", idIntrutor=" + idIntrutor +
                ", objetivo='" + objetivo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ficha ficha = (Ficha) o;
        return Objects.equals(getId(), ficha.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
