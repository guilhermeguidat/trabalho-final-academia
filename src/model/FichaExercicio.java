package model;

public class FichaExercicio {
    private int idFicha;
    private int idExercicio;
    private int series;
    private int repeticoes;

    public FichaExercicio() {

    }

    public FichaExercicio(int idFicha, int idExercicio, int series, int repeticoes) {
        this.idFicha = idFicha;
        this.idExercicio = idExercicio;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return "FichaExercicio{" +
                "idFicha=" + idFicha +
                ", idExercicio=" + idExercicio +
                ", series=" + series +
                ", repeticoes=" + repeticoes +
                '}';
    }
}
