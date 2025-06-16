package util;

import dto.ExercicioDTO;
import dto.FichaDTO;
import net.sf.jasperreports.engine.*;

import java.util.*;

public class GeradorRelatorios {

    public static boolean gerarFichaPDF(FichaDTO ficha) {
        try {
            List<ExercicioDTO> exerciciosA = new ArrayList<>();
            List<ExercicioDTO> exerciciosB = new ArrayList<>();
            List<ExercicioDTO> exerciciosC = new ArrayList<>();
            List<ExercicioDTO> exerciciosD = new ArrayList<>();
            List<ExercicioDTO> exerciciosE = new ArrayList<>();

            for(ExercicioDTO exercicio : ficha.getExercicios()) {
                switch (exercicio.getDivisao()) {
                    case "A" -> exerciciosA.add(exercicio);
                    case "B" -> exerciciosB.add(exercicio);
                    case "C" -> exerciciosC.add(exercicio);
                    case "D" -> exerciciosD.add(exercicio);
                    case "E" -> exerciciosE.add(exercicio);
                    default -> throw new IllegalArgumentException();
                }
            }

            String arquivo = "C:\\Ws\\ws-netbeans\\trabalho-academia-final\\trabalho-academia-final\\src\\util\\reports\\fichaAcademia.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(arquivo);

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("nomeAluno", ficha.getNomeAluno());
            parametros.put("nomeInstrutor", ficha.getNomeInstrutor());
            parametros.put("objetivo", ficha.getObjetivo());
            parametros.put("divisaoA", exerciciosA);
            parametros.put("divisaoB", exerciciosB);
            parametros.put("divisaoC", exerciciosC);
            parametros.put("divisaoD", exerciciosD);
            parametros.put("divisaoE", exerciciosE);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());

            String caminhoSalvar = "C:\\relatorios\\" + ficha.getNomeAluno().trim() + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, caminhoSalvar);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
