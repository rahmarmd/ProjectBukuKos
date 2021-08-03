/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BukuKos.ui;

import BukuKos.helper.Koneksi2;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MasukAkun extends javax.swing.JFrame {

    public MasukAkun() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelRegister = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_user2 = new javax.swing.JTextField();
        txt_pass2 = new javax.swing.JPasswordField();
        btn_masukakun2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelRegister.setText("Register Disini ");
        labelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(labelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Belum punya akun ?");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 130, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/loginnnn.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 41, -1, 50));

        jLabel1.setText("PENGGUNA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/logo bukukos kcl bgt.png"))); // NOI18N
        jLabel3.setText("BUKUKOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 295, 33));

        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, -1));

        txt_user2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_user2ActionPerformed(evt);
            }
        });
        getContentPane().add(txt_user2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 500, 30));

        txt_pass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pass2ActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 500, 30));

        btn_masukakun2.setBackground(new java.awt.Color(0, 0, 204));
        btn_masukakun2.setForeground(new java.awt.Color(255, 255, 255));
        btn_masukakun2.setText("Masuk Akun");
        btn_masukakun2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_masukakun2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_masukakun2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 500, 30));

        jTextField1.setBackground(new java.awt.Color(102, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 30));

        jLabel6.setText("Kata Sandi");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 100, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/11.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 670, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_user2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_user2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_user2ActionPerformed

    private void btn_masukakun2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_masukakun2ActionPerformed
        // TODO add your handling code here:

        try {
            Connection kon = Koneksi2.getConnection();
            Statement st = kon.createStatement();
            String sql = "SELECT * FROM tb_login WHERE username='" + txt_user2.getText() + "' "
                    + "and password_2='" + txt_pass2.getText() + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                if (rs.getString("id_level").equals("1")) {
                    new DashboardAdmin().show();
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Maaf Username atau Password Salah");
                txt_user2.setText("");
                txt_pass2.setText("");
                txt_user2.requestFocus();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btn_masukakun2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txt_pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pass2ActionPerformed

    private void labelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegisterMouseClicked
        // TODO add your handling code here:
        Register re = new Register();
        re.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_labelRegisterMouseClicked

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
            java.util.logging.Logger.getLogger(MasukAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasukAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasukAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasukAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasukAkun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_masukakun2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelRegister;
    private javax.swing.JPasswordField txt_pass2;
    private javax.swing.JTextField txt_user2;
    // End of variables declaration//GEN-END:variables
}
