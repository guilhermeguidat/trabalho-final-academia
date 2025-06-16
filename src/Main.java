import src.view.TelaPrincipal;

import db.ConnectionFactory;
import controller.*;
import dao.*;
import model.*;
import dto.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TelaPrincipal t = new TelaPrincipal();

        /* testes da impressão
        ExercicioDTO ex1 = new ExercicioDTO("Supino Reto", 4, 12, "A");
        ExercicioDTO ex2 = new ExercicioDTO("Puxada Frontal", 3, 10, "B");
        ExercicioDTO ex3 = new ExercicioDTO("Agachamento", 5, 8, "C");
        ExercicioDTO ex4 = new ExercicioDTO("Elevação Lateral", 3, 15, "D");
        ExercicioDTO ex6 = new ExercicioDTO("Tríceps Pulley", 3, 12, "A");
        ExercicioDTO ex7 = new ExercicioDTO("Remada Curvada", 4, 10, "B");

        List<ExercicioDTO> listaExercicios = Arrays.asList(ex1, ex2, ex3, ex4, ex6, ex7);
       

     
        FichaDTO ficha = new FichaDTO(
                "Carlos Silva",
                "Ana Maria",
                "Hipertrofia muscular",
                listaExercicios
        );

        
        boolean gerou = util.GeradorRelatorios.gerarFichaPDF(ficha);
        System.out.println("Relatório gerado? " + gerou);
*/
    }
}
