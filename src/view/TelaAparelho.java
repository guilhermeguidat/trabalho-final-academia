package src.view;

import controller.EquipamentoController;
import dao.EquipamentoDAO;
import model.Equipamento;
import db.ConnectionFactory;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaAparelho extends javax.swing.JFrame {

    private EquipamentoController equipamentoController;
    private Connection conn;
    private EquipamentoDAO equipamentoDAO;

    public TelaAparelho() throws SQLException {
        initComponents();
        tfId.setEnabled(false);
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        btAdicionar1.setEnabled(false);
        LimparCampos.setEnabled(false);
        nomeAdicionar.setEnabled(false);
        tipoAdicionar.setEnabled(false);

        this.conn = new ConnectionFactory().getConnection();

        this.equipamentoDAO = new EquipamentoDAO(this.conn);
        this.equipamentoController = new EquipamentoController(this.equipamentoDAO);

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

        preencherTabela();
    }

    /* public void conectarBanco() throws SQLException {

        java.sql.Connection conn = null;
        this.conn = new ConnectionFactory().getConnection();
        //alunoDAO = new AlunoDAO(conn);
    }*/
    public void LIMPAR_CAMPOS() {
        nomeAdicionar.setText("");
        tipoAdicionar.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdicionarPrincipal = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnProcurar = new javax.swing.JButton();
        tfProcurar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeAdicionar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tipoAdicionar = new javax.swing.JTextField();
        btAdicionar1 = new javax.swing.JButton();
        LimparCampos = new javax.swing.JButton();
        tfId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1068, 723));

        AdicionarPrincipal.setText("Adicionar");
        AdicionarPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarPrincipalActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tipo"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        tfProcurar.setActionCommand("<Not Set>");
        tfProcurar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Nome:");

        jLabel2.setText("ADICIONAR APARELHO");

        jLabel3.setText("NOME");

        jLabel4.setText("TIPO");

        btAdicionar1.setText("ADICIONAR");
        btAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionar1ActionPerformed(evt);
            }
        });

        LimparCampos.setText("LIMPAR CAMPOS");
        LimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparCamposActionPerformed(evt);
            }
        });

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        jLabel5.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAdicionar1)
                                .addGap(56, 56, 56)
                                .addComponent(LimparCampos))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tipoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AdicionarPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(100, 100, 100))))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tipoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdicionar1)
                            .addComponent(LimparCampos))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void preencherTabela() throws SQLException {

        List<Equipamento> equipamentos = equipamentoController.listarTodosEquipamentos();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);

        for (int i = 0; i < equipamentos.size(); i++) {
            Equipamento equipamento = equipamentos.get(i);
            model.addRow(new String[]{
                String.valueOf(equipamento.getId()),
                String.valueOf(equipamento.getNome()),
                String.valueOf(equipamento.getTipo())

            });
        }

    }

    private void btAdicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionar1ActionPerformed

        List<Equipamento> equipamentos = equipamentoController.listarTodosEquipamentos();
        
        String nome = nomeAdicionar.getText();
        String tipo = tipoAdicionar.getText();
        Equipamento eqInserir = new Equipamento();
        eqInserir.setNome(nome);
        eqInserir.setTipo(tipo);
        
        for(Equipamento equipamento : equipamentos){
           if(equipamento.getNome().toUpperCase().equals(nome.toUpperCase())){
               JOptionPane.showMessageDialog(this, "Equipamento ja cadastrado!");
            return;
           }
        }

        if (nome.trim().isEmpty() || tipo.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nome e Telefone são obrigatórios.", "Erro de Validação", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            equipamentoDAO = new EquipamentoDAO(conn);   
            equipamentoDAO.inserir(eqInserir);

            javax.swing.JOptionPane.showMessageDialog(this, "Aparelho adicionado com sucesso!", "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            LIMPAR_CAMPOS();
            preencherTabela();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao adicionar aparelho: " + e.getMessage(), "Erro no Banco de Dados", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAdicionar1ActionPerformed

    private void LimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparCamposActionPerformed
        LIMPAR_CAMPOS();
    }//GEN-LAST:event_LimparCamposActionPerformed

    private void AdicionarPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarPrincipalActionPerformed
        LIMPAR_CAMPOS();
        btExcluir.setEnabled(false);
        btEditar.setEnabled(false);
        btAdicionar1.setEnabled(true);
        LimparCampos.setEnabled(true);
        nomeAdicionar.setEnabled(true);
        tipoAdicionar.setEnabled(true);
    }//GEN-LAST:event_AdicionarPrincipalActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        btAdicionar1.setEnabled(false);
        LimparCampos.setEnabled(false);
        btExcluir.setEnabled(true);
        btEditar.setEnabled(true);
        int linha = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        tfId.setText(model.getValueAt(linha, 0).toString());
        nomeAdicionar.setText((String) model.getValueAt(linha, 1));
        tipoAdicionar.setText((String) model.getValueAt(linha, 2));
        nomeAdicionar.setEnabled(true);
        tipoAdicionar.setEnabled(true);

    }//GEN-LAST:event_jTable1MouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        
        Equipamento eq = new Equipamento();
        eq.setId(Integer.valueOf(tfId.getText()));
        eq.setNome(nomeAdicionar.getText());
        eq.setTipo(tipoAdicionar.getText());

        try {
            equipamentoController.removerEquipamento(eq.getId());
            preencherTabela();
            JOptionPane.showMessageDialog(null, "Aparelho excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o aparelho");
            Logger.getLogger(TelaAparelho.class.getName()).log(Level.SEVERE, null, ex);
        }
        LIMPAR_CAMPOS();

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        
        int idFormatado = Integer.parseInt(tfId.getText());

        try {
            equipamentoController.atualizarEquipamento(idFormatado, nomeAdicionar.getText(), tipoAdicionar.getText());
            JOptionPane.showMessageDialog(null, "Aparelho editado com sucesso !");
            preencherTabela();
            LIMPAR_CAMPOS();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel editar o aparelho");
            Logger.getLogger(TelaAparelho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
    String equipamentoProcurado = tfProcurar.getText();
        
        List<Equipamento> equipamentos = null;
        equipamentos = equipamentoController.listarTodosEquipamentos();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);

        if (equipamentos != null) {
            for (Equipamento equipamento : equipamentos) {
                if (equipamento.getNome().equalsIgnoreCase(equipamentoProcurado)) {
                    model.addRow(new Object[]{
                        equipamento.getId(),
                        equipamento.getNome(),
                        equipamento.getTipo()
                    });
                }
            }
        }
        
        if(equipamentoProcurado.equals("")){
            try {
                preencherTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel buscar o aparelho");
                Logger.getLogger(TelaAlunos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnProcurarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAparelho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAparelho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAparelho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAparelho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaAparelho().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaAparelho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarPrincipal;
    private javax.swing.JButton LimparCampos;
    private javax.swing.JButton btAdicionar1;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nomeAdicionar;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfProcurar;
    private javax.swing.JTextField tipoAdicionar;
    // End of variables declaration//GEN-END:variables
}
