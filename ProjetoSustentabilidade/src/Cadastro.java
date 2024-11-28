
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author isaac_s_souza
 */
public class Cadastro extends javax.swing.JFrame {

    private DefaultTableModel model;

    public Cadastro() {
        initComponents();
        
    }

    public void cadastro() {
        String nome = JLNOME.getText();
        String idade = JLIDADE.getText();
        String sexo = JLSEXO.getText();
        DefaultTableModel model = (DefaultTableModel) JTABELA.getModel();
        model.addRow(new Object[]{nome, idade, sexo});
        LimparCampos();

        int resposta = JOptionPane.showConfirmDialog(this, "Deseja cadrastar outro cliente?", "Cadastro", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            LimparCampos();
        } else {
            calconsumo novoFrame = new calconsumo(model);
            novoFrame.setVisible(true);
            this.dispose();
            Relatório newFrame = new Relatório(model);

        }

    }

    public void LimparCampos() {
        JLNOME.setText("");
        JLIDADE.setText("");
        JLSEXO.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLNOME = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JLIDADE = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        JTLOGIN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABELA = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        JLSEXO = new javax.swing.JTextField();
        jBVoltar = new javax.swing.JButton();
        jLFundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(601, 450));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("CADASTRO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 20, 110, 22);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("INSIRA SEU NOME:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 50, 190, 17);

        JLNOME.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(JLNOME);
        JLNOME.setBounds(40, 70, 201, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("INSIRA SUA IDADE:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 110, 130, 17);
        getContentPane().add(JLIDADE);
        JLIDADE.setBounds(40, 130, 201, 30);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JTLOGIN.setBackground(new java.awt.Color(0, 0, 0));
        JTLOGIN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JTLOGIN.setText("Cadastrar");
        JTLOGIN.setBorder(null);
        JTLOGIN.setBorderPainted(false);
        JTLOGIN.setContentAreaFilled(false);
        JTLOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTLOGINActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTLOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTLOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(290, 130, 90, 30);

        JTABELA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome:", "Região:", "Sexo:"
            }
        ));
        jScrollPane1.setViewportView(JTABELA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(74, 226, 452, 129);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("INSIRA SEU GÊNERO:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 170, 160, 17);

        JLSEXO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(JLSEXO);
        JLSEXO.setBounds(40, 190, 201, 30);

        jBVoltar.setText("Voltar");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jBVoltar);
        jBVoltar.setBounds(20, 360, 61, 23);

        jLFundo.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruan_a_alves\\Downloads\\Water Systems Earth Science Presentation in Blue White Illustrated Style\\1.png")); // NOI18N
        jLFundo.setText("jLabel6");
        getContentPane().add(jLFundo);
        jLFundo.setBounds(0, -10, 610, 420);

        jMenu1.setText("Cadastro");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruan_a_alves\\Desktop\\ProjetoSustentabilidade\\icones\\9133514_signup_register_login_icon (1).png")); // NOI18N
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
        jMenuItem2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruan_a_alves\\Desktop\\ProjetoSustentabilidade\\icones\\3045419_accounting_budget_calc_calculator_math_icon (1).png")); // NOI18N
        jMenuItem2.setText("Consulta de consumo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruan_a_alves\\Desktop\\ProjetoSustentabilidade\\icones\\5975175_coronavirus_report_clipboard_medical_virus_icon.png")); // NOI18N
        jMenuItem3.setText("Relatórios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Metas");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruan_a_alves\\Desktop\\ProjetoSustentabilidade\\icones\\290108_achievement_award_badge_medal_prize_icon.png")); // NOI18N
        jMenuItem4.setText("Metas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Sobre");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruan_a_alves\\Desktop\\ProjetoSustentabilidade\\icones\\4213426_about_description_help_info_information_icon.png")); // NOI18N
        jMenuItem5.setText("Sobre");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTLOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTLOGINActionPerformed
        cadastro();
    }//GEN-LAST:event_JTLOGINActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        // TODO add your handling code here:
        new Menu(model).show();
        this.dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new Cadastro().show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new calconsumo().show();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new Relatório().show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        new Sobre().show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JLIDADE;
    private javax.swing.JTextField JLNOME;
    private javax.swing.JTextField JLSEXO;
    private javax.swing.JTable JTABELA;
    private javax.swing.JButton JTLOGIN;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private static class relatório {

        public relatório(DefaultTableModel model) {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
