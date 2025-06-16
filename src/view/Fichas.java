/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AlunoController;
import dao.AlunoDAO;
import model.Aluno;

import controller.ExercicioController;
import dao.ExercicioDAO;
import model.Exercicio;

import controller.FichaController;
import dao.FichaDAO;
import model.FichaExercicio;

import controller.FichaExercicioController;
import dao.ExercicioDAO;
import model.Exercicio;

import controller.InstrutorController;
import dao.FichaExercicioDAO;
import dao.InstrutorDAO;
import model.Instrutor;
import dto.*;

import java.sql.Connection;
import db.ConnectionFactory;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Equipamento;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Ficha;

public class Fichas extends javax.swing.JFrame {
    
    private Aluno aluno;
    private AlunoController alunoController;
    private AlunoDAO alunoDAO;
    
    
    private ExercicioController exercicioController;
    private ExercicioDAO exercicioDAO;
    
    private FichaController fichaController;
    private FichaDAO fichaDAO;
    private Ficha ficha;
    
    private FichaExercicioController fichaExercicioController;
    private FichaExercicio fichaExercicio;
    private FichaExercicioDAO fichaExercicioDAO;
    
    private InstrutorController instrutorController;
    private InstrutorDAO instrutorDAO;
   
    private Connection conn;
    private int exercicioAux;

    public Fichas() throws SQLException {
        initComponents();
        
        this.conn = new ConnectionFactory().getConnection();

        this.exercicioDAO = new ExercicioDAO(this.conn);
        this.exercicioController = new ExercicioController(this.exercicioDAO);
        
        this.alunoDAO = new AlunoDAO(this.conn);
        this.alunoController = new AlunoController(this.alunoDAO);
        
        this.instrutorDAO = new InstrutorDAO(this.conn);
        this.instrutorController = new InstrutorController(this.instrutorDAO);
        
        this.fichaDAO = new FichaDAO(this.conn);
        this.fichaController = new FichaController(this.fichaDAO);
        
        this.fichaExercicioDAO = new FichaExercicioDAO(this.conn);
        this.fichaExercicioController = new FichaExercicioController(this.fichaExercicioDAO);
        
        ComboBoxABCD.setEnabled(false);
        ComboBoxExercicios.setEnabled(false);
        tfSeries.setEnabled(false);
        tfRepeticao.setEnabled(false);
        btnAdicionarFicha.setEnabled(false);
        btnLimparCampos.setEnabled(false);
        
        
        ComboBoxAluno.setEnabled(false);
        ComboBoxInstrutor.setEnabled(false);
        tfObjetivo.setEnabled(false);
        btnAdicionarExercicio.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
        
        preencherComboBox();

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                        System.out.println("Conexão com o banco fechada com sucesso.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProcurar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboBoxABCD = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxExercicios = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfRepeticao = new javax.swing.JTextField();
        btnAdicionarFicha = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        btnAdicionarPrincipal = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        ComboBoxAluno = new javax.swing.JComboBox<>();
        ComboBoxInstrutor = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfSeries = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfObjetivo = new javax.swing.JTextField();
        btnAdicionarExercicio = new javax.swing.JButton();
        ComboBoxProcurado = new javax.swing.JComboBox<>();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 800));
        setSize(new java.awt.Dimension(1920, 1080));

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        jLabel1.setText("              Adicionar ficha / editar");
        jLabel1.setPreferredSize(new java.awt.Dimension(205, 205));
        jLabel1.setRequestFocusEnabled(false);

        jLabel2.setText("Aluno");

        jLabel4.setText("Professor");

        jLabel3.setText("Divisão");

        ComboBoxABCD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        ComboBoxABCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxABCDActionPerformed(evt);
            }
        });

        jLabel5.setText("Exercicios");

        ComboBoxExercicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        ComboBoxExercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxExerciciosActionPerformed(evt);
            }
        });

        jLabel6.setText("N Repetição");

        btnAdicionarFicha.setText("Adicionar");
        btnAdicionarFicha.setMaximumSize(new java.awt.Dimension(113, 23));
        btnAdicionarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFichaActionPerformed(evt);
            }
        });

        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        btnAdicionarPrincipal.setText("Adcionar");
        btnAdicionarPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPrincipalActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
            },
            new String [] {
                "ID_Exercício", "Exercício", "Repetições", "Séries", "Divisão"
            }
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Aluno pesquisado");

        ComboBoxAluno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        ComboBoxAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxAlunoActionPerformed(evt);
            }
        });

        ComboBoxInstrutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jLabel9.setText("N° de Séries");

        jLabel10.setText("Objetivo");

        tfObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfObjetivoActionPerformed(evt);
            }
        });

        btnAdicionarExercicio.setText("Adicionar Exercício");
        btnAdicionarExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarExercicioActionPerformed(evt);
            }
        });

        ComboBoxProcurado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        ComboBoxProcurado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxProcuradoActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar PDF");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRepeticao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfSeries))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxABCD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxExercicios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBoxAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxInstrutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfObjetivo))))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdicionarFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionarExercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparCampos)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionarPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 176, 176)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 633, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxProcurado, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ComboBoxProcurado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAdicionarPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxABCD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxExercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfRepeticao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionarFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAdicionarExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void preencherComboBox() {
         try {
            List<Aluno> alunos = alunoController.listarTodosAlunos();
            List<Exercicio> exercicios = exercicioController.listarTodosExercicios();
            List<Instrutor> instrutores = instrutorController.listarTodosInstrutores();
                                         
            ComboBoxAluno.addItem("Selecione um aluno");
            ComboBoxProcurado.addItem("Selecione um aluno para buscar");
            ComboBoxExercicios.addItem("Selecione um exercicio");
            ComboBoxInstrutor.addItem("Selecione um instrutor");

            for (Aluno eq : alunos) {
                ComboBoxAluno.addItem(eq);
                ComboBoxProcurado.addItem(eq);
            }
            
            for (Exercicio eq : exercicios) {
                ComboBoxExercicios.addItem(eq);
            }
            
            for (Instrutor eq : instrutores) {
                ComboBoxInstrutor.addItem(eq);
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os Dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
   }
    
    private void ComboBoxABCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxABCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxABCDActionPerformed

    private void ComboBoxAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxAlunoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {     
        int linha = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        tfSeries.setText(model.getValueAt(linha, 3).toString());      
        tfRepeticao.setText(model.getValueAt(linha, 2).toString());   
        ComboBoxABCD.setSelectedItem(model.getValueAt(linha, 4));     
        exercicioAux = (int) model.getValueAt(linha, 0);
        ComboBoxExercicios.setEnabled(false);
        btnExcluir.setEnabled(true);
        btnEditar.setEnabled(true);
        btnAdicionarExercicio.setEnabled(false);
    }       
    
    private void btnAdicionarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarFichaActionPerformed
        try{
        btnAdicionarFicha.setEnabled(false);
        Aluno alunoSelecionado = (Aluno) ComboBoxAluno.getSelectedItem();
        List<Ficha> fichas = fichaController.listarTodasFichas();
        for(Ficha ficha : fichas){
            if(ficha.getIdAluno().equals(alunoSelecionado.getId())) throw new IllegalArgumentException();
        }
        Instrutor instrutorSelecionado = (Instrutor) ComboBoxInstrutor.getSelectedItem();
        String objetivo = tfObjetivo.getText();
        
        this.ficha = fichaController.adicionarFicha(alunoSelecionado.getId(), instrutorSelecionado.getId(), objetivo);
        
        btnAdicionarExercicio.setEnabled(true);
        btnAdicionarFicha.setEnabled(false);
        ComboBoxABCD.setEnabled(true);
        ComboBoxExercicios.setEnabled(true);
        tfSeries.setEnabled(true);
        tfRepeticao.setEnabled(true);
        btnLimparCampos.setEnabled(true);
        
        btnProcurar.setEnabled(true);
        
        ComboBoxAluno.setEnabled(false);
        ComboBoxInstrutor.setEnabled(false);
        tfObjetivo.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Ficha criada!");
        }
        catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, "Esse aluno já possui uma ficha!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Preencha os dados corretamente!");
        }
    }//GEN-LAST:event_btnAdicionarFichaActionPerformed

    private void limparCampos(){
        tfSeries.setText("");
        tfRepeticao.setText("");
        ComboBoxExercicios.setSelectedIndex(0);
        
    }
    
    private void ComboBoxExerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxExerciciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxExerciciosActionPerformed

    private void tfObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfObjetivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfObjetivoActionPerformed

    private void btnAdicionarPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPrincipalActionPerformed
        ComboBoxProcurado.setEnabled(true);
        ComboBoxAluno.setEnabled(true);
        ComboBoxInstrutor.setEnabled(true);
        tfObjetivo.setEnabled(true);
        
        btnAdicionarFicha.setEnabled(true);
        btnLimparCampos.setEnabled(true);
    }//GEN-LAST:event_btnAdicionarPrincipalActionPerformed

    private void btnAdicionarExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarExercicioActionPerformed
        try{
        int series = Integer.parseInt(tfSeries.getText());
        int repeticao = Integer.parseInt(tfRepeticao.getText());
        Exercicio exercicioSelecionado = (Exercicio) ComboBoxExercicios.getSelectedItem();

        String opcaoSelecionada = (String) ComboBoxABCD.getSelectedItem();

        fichaExercicioController.adicionarExercicio(ficha.getId(), exercicioSelecionado.getId(), series, repeticao, opcaoSelecionada);
        
       
        List<FichaExercicio> exercicios = fichaExercicioController.listarTodosExerciciosFicha(ficha.getId());
        List<Exercicio> exercicioTodos = new ArrayList<>();
        for(FichaExercicio exercicio : exercicios){
            exercicioTodos.add(exercicioController.buscarExercicioPorId(exercicio.getIdExercicio()));
        }
        

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
    
        for (int i = 0; i < exercicios.size(); i++) {
            int ID = i < exercicios.size() ? exercicios.get(i).getIdExercicio() : null;
            String a = i < exercicioTodos.size() ? exercicioTodos.get(i).getNome() : "";
            int b = i < exercicios.size() ? exercicios.get(i).getRepeticoes() : null;
            int c = i < exercicios.size() ? exercicios.get(i).getSeries() : null;
            String d = i < exercicios.size() ? exercicios.get(i).getDivisao() : "";

            model.addRow(new Object[]{ID,a, b, c, d});
}   
        limparCampos();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Preencha os dados corretamente!");
        }
        
    }//GEN-LAST:event_btnAdicionarExercicioActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try{
        Integer novaSerie = Integer.parseInt(tfSeries.getText());
        Integer novaRepeticao = Integer.parseInt(tfRepeticao.getText());
        String novaDivisao = (String) ComboBoxABCD.getSelectedItem();
                           
        fichaExercicioController.atualizarExercicioFicha(ficha.getId(), exercicioAux, novaSerie, novaRepeticao, novaDivisao);
        
        List<FichaExercicio> exercicios = fichaExercicioController.listarTodosExerciciosFicha(ficha.getId());
        List<Exercicio> exercicioTodos = new ArrayList<>();
        for(FichaExercicio exercicio : exercicios){
            exercicioTodos.add(exercicioController.buscarExercicioPorId(exercicio.getIdExercicio()));
        }
        

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
    
        for (int i = 0; i < exercicios.size(); i++) {
            int ID = i < exercicios.size() ? exercicios.get(i).getIdExercicio() : null;
            String a = i < exercicioTodos.size() ? exercicioTodos.get(i).getNome() : "";
            int b = i < exercicios.size() ? exercicios.get(i).getRepeticoes() : null;
            int c = i < exercicios.size() ? exercicios.get(i).getSeries() : null;
            String d = i < exercicios.size() ? exercicios.get(i).getDivisao() : "";

            model.addRow(new Object[]{ID,a, b, c, d});
}   
        limparCampos();
        ComboBoxExercicios.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
        btnAdicionarExercicio.setEnabled(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        fichaExercicioController.removerExercicioFicha(ficha.getId(), exercicioAux);
        List<FichaExercicio> exercicios = fichaExercicioController.listarTodosExerciciosFicha(ficha.getId());
        List<Exercicio> exercicioTodos = new ArrayList<>();
        for(FichaExercicio exercicio : exercicios){
            exercicioTodos.add(exercicioController.buscarExercicioPorId(exercicio.getIdExercicio()));
        }
        

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);
    
        for (int i = 0; i < exercicios.size(); i++) {
            int ID = i < exercicios.size() ? exercicios.get(i).getIdExercicio() : null;
            String a = i < exercicioTodos.size() ? exercicioTodos.get(i).getNome() : "";
            int b = i < exercicios.size() ? exercicios.get(i).getRepeticoes() : null;
            int c = i < exercicios.size() ? exercicios.get(i).getSeries() : null;
            String d = i < exercicios.size() ? exercicios.get(i).getDivisao() : "";

            model.addRow(new Object[]{ID,a, b, c, d});
}   
        limparCampos();
        ComboBoxExercicios.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void ComboBoxProcuradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxProcuradoActionPerformed

    }//GEN-LAST:event_ComboBoxProcuradoActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
       try{
        btnAdicionarFicha.setEnabled(false);
        tfSeries.setEnabled(true);
        tfRepeticao.setEnabled(true);
        ComboBoxABCD.setEnabled(true);
        ComboBoxExercicios.setEnabled(true);
        btnAdicionarExercicio.setEnabled(true);

        List<Ficha> fichas = fichaController.listarTodasFichas();
        List<Ficha> fichaAux = new ArrayList<>();
        Aluno aluno = (Aluno) ComboBoxProcurado.getSelectedItem();

        for(Ficha ficha : fichas){
            if(ficha.getIdAluno().equals(aluno.getId())){
                fichaAux.add(ficha);
            }
        }

        ficha = fichaAux.get(0);
        List<FichaExercicio> fichaEx  = fichaExercicioController.listarTodosExerciciosFicha(fichaAux.get(0).getId());
         System.out.println("TAmanho ficha ex: " + fichaEx.size());
         System.out.println("id ficha: " + fichaAux.get(0).getId());
        List<Exercicio> exercicios = exercicioController.listarTodosExercicios();
        List<Exercicio> exAux = new ArrayList<>();

        for(Exercicio ex : exercicios){
            for(FichaExercicio fichaExc : fichaEx){
                if(ex.getId().equals(fichaExc.getIdExercicio())){
                    exAux.add(ex);
                }
            }
        }

         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
         model.setNumRows(0);
         
         for (int i = 0; i < exAux.size(); i++) {
             int ID = i < exAux.size() ? exAux.get(i).getId() : null;
             String a = i < exAux.size() ? exAux.get(i).getNome() : "";
             int b = i < fichaEx.size() ? fichaEx.get(i).getRepeticoes() : null;
             int c = i < fichaEx.size() ? fichaEx.get(i).getSeries() : null;
             String d = i < fichaEx.size() ? fichaEx.get(i).getDivisao() : "";

             model.addRow(new Object[]{ID,a, b, c, d});
 }   }
     catch(IndexOutOfBoundsException e){
             JOptionPane.showMessageDialog(null, "Esse aluno não possui ficha");
             DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
             model.setNumRows(0);
             btnAdicionarFicha.setEnabled(false);
            tfSeries.setEnabled(false);
            tfRepeticao.setEnabled(false);
            ComboBoxABCD.setEnabled(false);
            ComboBoxExercicios.setEnabled(false);
            btnAdicionarExercicio.setEnabled(false);

             }  
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        
      Aluno aluno = (Aluno) ComboBoxProcurado.getSelectedItem();

            if (aluno != null) {
                List<FichaExercicio> fichaEx = fichaExercicioController.listarTodosExerciciosFicha(ficha.getId());
                List<Exercicio> exercicios = exercicioController.listarTodosExercicios();

                List<ExercicioDTO> exDto = new ArrayList<>();

           
                for (FichaExercicio fichaExc : fichaEx) {
                    for (Exercicio ex : exercicios) {
                        if (ex.getId().equals(fichaExc.getIdExercicio())) {
                            
                            ExercicioDTO exDtoAux = new ExercicioDTO(
                                ex.getNome(),
                                fichaExc.getSeries(),
                                fichaExc.getRepeticoes(),
                                fichaExc.getDivisao()
                            );
                            exDto.add(exDtoAux);
                            break;
                        }
                    }
                }

                Instrutor instrutor = instrutorController.buscarInstrutorPorId(ficha.getIdIntrutor());

                FichaDTO fichaDto = new FichaDTO(
                    aluno.getNome(),
                    instrutor != null ? instrutor.getNome() : "Sem Instrutor",
                    ficha.getObjetivo(),
                    exDto
                );

                boolean gerou = util.GeradorRelatorios.gerarFichaPDF(fichaDto);
                JOptionPane.showMessageDialog(null, "PDF gerado");
                System.out.println("Relatório gerado? " + gerou);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado.");
            }
    }//GEN-LAST:event_btnExportarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fichas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Fichas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Fichas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxABCD;
    private javax.swing.JComboBox<Object> ComboBoxAluno;
    private javax.swing.JComboBox<Object> ComboBoxExercicios;
    private javax.swing.JComboBox<Object> ComboBoxInstrutor;
    private javax.swing.JComboBox<Object> ComboBoxProcurado;
    private javax.swing.JButton btnAdicionarExercicio;
    private javax.swing.JButton btnAdicionarFicha;
    private javax.swing.JButton btnAdicionarPrincipal;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfObjetivo;
    private javax.swing.JTextField tfRepeticao;
    private javax.swing.JTextField tfSeries;
    // End of variables declaration//GEN-END:variables
}
