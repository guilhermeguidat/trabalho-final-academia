package model;

public class FichaExercicio {
    private int id;
    private int idFicha;
    private int idExercicio;
    private int series;
    private int repeticoes;
    private String divisao;

    public FichaExercicio() {

    }

    public FichaExercicio(int idFicha, int idExercicio, int series, int repeticoes, String divisao) {
        this.idFicha = idFicha;
        this.idExercicio = idExercicio;
        this.series = series;
        this.repeticoes = repeticoes;
        this.divisao = divisao;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
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

    public String getDivisao() {return divisao;}

    public void setDivisao(String divisao) {this.divisao = divisao;}

    @Override
    public String toString() {
        return "FichaExercicio{" +
                "idFicha=" + idFicha +
                ", idExercicio=" + idExercicio +
                ", series=" + series +
                ", repeticoes=" + repeticoes +
                ", divisao=" + divisao +
                '}';
    }
}
