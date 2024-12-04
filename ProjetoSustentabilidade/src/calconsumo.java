/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel_bartholdy
 */
public class calconsumo extends javax.swing.JFrame {

    private DefaultTableModel model;

    /**
     * Creates new form calculadoradedispositivos
     *
     * @param model
     */
    public calconsumo(DefaultTableModel model) {
        initComponents();
        double custo;
        double tempoStr;
        DefaultTableModel novoModel = (DefaultTableModel) jTable2.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            novoModel.addRow(new Object[]{
                model.getValueAt(i, 0),
                model.getValueAt(i, 1),
                model.getValueAt(i, 2)

            });
            jcmembro.addItem(model.getValueAt(i, 0).toString());

        }

    }

    calconsumo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    calconsumo(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluirfam() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selecteRow = jTable1.getSelectedRow();

        if (selecteRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o cliente?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                model.removeRow(selecteRow);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um cliente!");
            }
        }

    }

    public void passar_info() {
        String nome = (String) jcmembro.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.addRow(new Object[]{nome});

    }

    public void cadastro_dispo() {

        String dispositivo = (String) jcdispo.getSelectedItem();
        String local = jtlocal.getText();
        String tempoStr = jtuso.getText();
        String membro = (String) jcmembro.getSelectedItem();

        String regiao = (String) jcregiao.getSelectedItem();

        double tarifaPorM3 = 0.0;

        switch (regiao) {
            case "Sudeste":
                tarifaPorM3 = 2.45;
                break;
            case "Centro-Oeste":
                tarifaPorM3 = 3.19;
                break;
            case "Sul":
                tarifaPorM3 = 3.16;
                break;
            case "Nordeste":
                tarifaPorM3 = 2.59;
                break;
            case "Norte":
                tarifaPorM3 = 2.56;
                break;
            default:

                JOptionPane.showMessageDialog(null, "Região não encontrada.");
                return;
        }
        double dispositivoporum = 0.0;

        switch (dispositivo) {
            case "Torneira":
                dispositivoporum = 0.012;//L por minuto
                break;
            case "Irrigação":
                dispositivoporum = 0.00125;
                break;
            case "Chuveiro":
                dispositivoporum = 0.018;
                break;
            case "Máquina de Lavar":
                dispositivoporum = 0.09;
                break;
            default:
        }

        try {
            // tempo em horas ou minutos
            double tempo = Double.parseDouble(tempoStr);

            double volume = tempo * dispositivoporum;

            // calc do custo 
            double custo = volume * tarifaPorM3;

            // add os dados na tabela 
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{membro, dispositivo, local, tempoStr + "Min", "R$" + custo, volume});

        } catch (NumberFormatException e) {
            // Caso o usuário insira um valor inválido para o tempo
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido para o tempo de uso.");
        }
    }

    public void alterarmembro() {
        int linhaselecionada = jTable1.getSelectedRow();
        if (linhaselecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para alterar.");
            return;
        }
        int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente alterar o cliente selecionado?", "confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            String dispositivo = (String) jcdispo.getSelectedItem();
            String local = jtlocal.getText();
            String tempoStr = jtuso.getText();
            String membro = (String) jcmembro.getSelectedItem();

            String regiao = (String) jcregiao.getSelectedItem();

            double tarifaPorM3 = 0.0;

            switch (regiao) {
                case "Sudeste":
                    tarifaPorM3 = 2.45;
                    break;
                case "Centro-Oeste":
                    tarifaPorM3 = 3.19;
                    break;
                case "Sul":
                    tarifaPorM3 = 3.16;
                    break;
                case "Nordeste":
                    tarifaPorM3 = 2.59;
                    break;
                case "Norte":
                    tarifaPorM3 = 2.56;
                    break;
                default:

                    JOptionPane.showMessageDialog(null, "Região não encontrada.");
                    return;
            }
            double dispositivoporum = 0.0;

            switch (dispositivo) {
                case "Torneira":
                    dispositivoporum = 0.012;//L por minuto
                    break;
                case "Irrigação":
                    dispositivoporum = 0.00125;
                    break;
                case "Chuveiro":
                    dispositivoporum = 0.018;
                    break;
                case "Máquina de Lavar":
                    dispositivoporum = 0.09;
                    break;
                default:
            }

            try {
                // tempo em horas ou minutos
                double tempo = Double.parseDouble(tempoStr);

                double volume = tempo * dispositivoporum;

                // calc do custo 
                double custo = volume * tarifaPorM3;

                // add os dados na tabela 
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                model.setValueAt(tempoStr + " Min.", linhaselecionada, 3);
                model.setValueAt("R$" + custo, linhaselecionada, 4);
                model.setValueAt(volume + "L", linhaselecionada, 6);

            } catch (NumberFormatException e) {
                // Caso o usuário insira um valor inválido para o tempo
                JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido para o tempo de uso.");
            }

            limparCampos();
            JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!");
        }

    }

void gerarelatorio() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int selectedRow = jTable1.getSelectedRow(); 

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String clienteSelecionado = model.getValueAt(selectedRow, 0).toString(); // Obtém o nome do cliente
    double gastoTotal = 0.0;
    double tempoTotal = 0.0;
    StringBuilder locais = new StringBuilder();

   for (int i = 0; i < model.getRowCount(); i++) {
        String membro = model.getValueAt(i, 0).toString();
        if (membro.equals(clienteSelecionado)) {
            String gastoStr = model.getValueAt(i, 4).toString().replace("R$", "").trim();
            gastoTotal += Double.parseDouble(gastoStr);
            String tempoStr = model.getValueAt(i, 3).toString().replace(" Min", "").trim();
            tempoTotal += Double.parseDouble(tempoStr);

            String local = model.getValueAt(i, 2).toString();
            if (!locais.toString().contains(local)) {
                if (locais.length() > 0) {
                    locais.append(", ");
                }
                locais.append(local);
            }
        }
    }

    String mensagem = "Resumo de Consumo para " + clienteSelecionado + ":\n" +
                      "Valor gastado da Água: R$" + String.format("%.2f", gastoTotal) + "\n" +
                      "Tempo Total de Uso: " + String.format("%.2f", tempoTotal) + " Min.\n" +                    
                      "Locais Registrados: " + locais.toString();

    JOptionPane.showMessageDialog(null, mensagem, "Resumo de Consumo", JOptionPane.INFORMATION_MESSAGE);

    
}

    public class calc extends javax.swing.JFrame {

        /**
         * Creates new form NewJFrame1
         */
    }

    public void limparCampos() {

        jtlocal.setText("");
        jtuso.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jtlocal = new javax.swing.JTextField();
        jtuso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jbadicionar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcdispo = new javax.swing.JComboBox<>();
        jcregiao = new javax.swing.JComboBox<>();
        jBExcluir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jcmembro = new javax.swing.JComboBox<>();
        jBAlterar = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jBSUPER = new javax.swing.JButton();
        jLFundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(null);

        jtlocal.setText(" ");
        jPanel1.add(jtlocal);
        jtlocal.setBounds(96, 130, 110, 30);

        jtuso.setText(" ");
        jtuso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtusoActionPerformed(evt);
            }
        });
        jPanel1.add(jtuso);
        jtuso.setBounds(410, 70, 100, 30);

        jLabel1.setText("Dispositivo:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 100, 70, 30);

        jLabel2.setText("Local:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 120, 60, 50);

        jLabel3.setText("Tempo de Uso (H):");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(290, 80, 110, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Membro", "Dispositivo", "Local", "Tempo de uso", "Gasto (R$)", "Uso p/ Litro (L)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 230, 590, 93);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Consulta de consumo por");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(176, 11, 228, 22);

        jbadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/9133514_signup_register_login_icon (1).png"))); // NOI18N
        jbadicionar.setText("Registrar");
        jbadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbadicionarActionPerformed(evt);
            }
        });
        jPanel1.add(jbadicionar);
        jbadicionar.setBounds(20, 200, 110, 25);

        jLabel5.setText("Região:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(347, 100, 60, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("Dispositivo");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(229, 39, 110, 25);

        jcdispo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Torneira", "Irrigação", "Máquina de Lavar", "Chuveiro" }));
        jcdispo.setBorder(null);
        jPanel1.add(jcdispo);
        jcdispo.setBounds(96, 100, 110, 20);

        jcregiao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Sul", "Sudeste", "Centro-Oeste", "Nordeste", "Norte" }));
        jcregiao.setBorder(null);
        jPanel1.add(jcregiao);
        jcregiao.setBounds(410, 100, 100, 20);

        jBExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/10758949_x_icon.png"))); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jBExcluir);
        jBExcluir.setBounds(140, 200, 100, 25);

        jLabel9.setText("Membro: ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(45, 70, 60, 20);

        jcmembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmembroActionPerformed(evt);
            }
        });
        jPanel1.add(jcmembro);
        jcmembro.setBounds(96, 70, 110, 20);

        jBAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/9068701_change_icon.png"))); // NOI18N
        jBAlterar.setText("Editar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jBAlterar);
        jBAlterar.setBounds(250, 200, 110, 25);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 360, 61, 23);

        jBSUPER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/5975175_coronavirus_report_clipboard_medical_virus_icon.png"))); // NOI18N
        jBSUPER.setText("Gerar Relatório");
        jBSUPER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSUPERActionPerformed(evt);
            }
        });
        jPanel1.add(jBSUPER);
        jBSUPER.setBounds(370, 200, 130, 25);

        jLFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1G.png"))); // NOI18N
        jPanel1.add(jLFundo);
        jLFundo.setBounds(-60, -170, 800, 660);

        jMenu1.setText("Cadastro");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/9133514_signup_register_login_icon (1).png"))); // NOI18N
        jMenuItem1.setText("Cadastro de membros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consulta");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/3045419_accounting_budget_calc_calculator_math_icon (1).png"))); // NOI18N
        jMenuItem2.setText("Consulta de consumo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Relatório");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/5975175_coronavirus_report_clipboard_medical_virus_icon.png"))); // NOI18N
        jMenuItem3.setText("Relatórios");
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        jMenu9.setText("Sobre");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/4213426_about_description_help_info_information_icon.png"))); // NOI18N
        jMenuItem5.setText("Sobre");
        jMenu9.add(jMenuItem5);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbadicionarActionPerformed
        // TODO add your handling code here:
        cadastro_dispo();
        limparCampos();
    }//GEN-LAST:event_jbadicionarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        // TODO add your handling code here:
        excluirfam();
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        // TODO add your handling code here:
        alterarmembro();
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        new Menu().show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jBSUPERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSUPERActionPerformed
        // TODO add your handling code here:
        gerarelatorio();
    }//GEN-LAST:event_jBSUPERActionPerformed

    private void jcmembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmembroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmembroActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new Cadastro().show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jtusoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtusoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtusoActionPerformed

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
            java.util.logging.Logger.getLogger(calconsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calconsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calconsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calconsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calconsumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jBAlterar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSUPER;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbadicionar;
    private javax.swing.JComboBox<String> jcdispo;
    private javax.swing.JComboBox<String> jcmembro;
    private javax.swing.JComboBox<String> jcregiao;
    private javax.swing.JTextField jtlocal;
    private javax.swing.JTextField jtuso;
    // End of variables declaration//GEN-END:variables
}
