package dto;

import java.util.List;

public class FichaDTO {

    private String nomeAluno;
    private String nomeInstrutor;
    private String objetivo;

    private List<ExercicioDTO> exercicios;

    public FichaDTO(String nomeAluno, String nomeInstrutor, String objetivo, List<ExercicioDTO> exercicios) {
        this.nomeAluno = nomeAluno;
        this.nomeInstrutor = nomeInstrutor;
        this.objetivo = objetivo;
        this.exercicios = exercicios;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public List<ExercicioDTO> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExercicioDTO> exercicios) {
        this.exercicios = exercicios;
    }
}
