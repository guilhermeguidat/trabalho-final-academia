package dto;

public class ExercicioDTO {

    private String nome;
    private int series;
    private int repeticoes;
    private String divisao;

    public ExercicioDTO(String nome, int series, int repeticoes, String divisao) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.divisao = divisao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }
}
