/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BukuKos.ui;

import BukuKos.helper.Koneksi2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Register extends javax.swing.JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        setLocationRelativeTo(null);
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
        username_txt = new javax.swing.JTextField();
        password_txt = new javax.swing.JPasswordField();
        btn_masukakun2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelRegister.setText("Login Disini");
        labelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(labelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Sudah punya akun ? ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 150, -1));

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

        username_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_txtActionPerformed(evt);
            }
        });
        getContentPane().add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 500, 30));

        password_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_txtActionPerformed(evt);
            }
        });
        getContentPane().add(password_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 500, 30));

        btn_masukakun2.setBackground(new java.awt.Color(0, 0, 204));
        btn_masukakun2.setForeground(new java.awt.Color(255, 255, 255));
        btn_masukakun2.setText("Daftar Akun");
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
    }// </editor-fold>//GEN-END:initComponents

    private void username_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_txtActionPerformed

    private void password_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_txtActionPerformed

    private void btn_masukakun2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_masukakun2ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = Koneksi2.getConnection();
            //query insert data ke dalam database mysql
            pst = con.prepareStatement("INSERT INTO tb_login (username, password_2, id_level) VALUES(?,?,1)");
            //validasi ketika textField kosong

            if (username_txt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username tidak boleh kosong");
            } else if (password_txt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password tidak boleh kosong");
            } else {
                //digunakan untuk memasukkan data ke masing2 variabel textfield seperti namaTxt, dll

                //misal bingung pst sama rs bisa diliat di variabel diatas
                pst.setString(1, username_txt.getText());
                pst.setString(2, password_txt.getText());
                pst.executeUpdate();

                //setelah nginput data kasih ini biar textfieldnya kosong lagi
                username_txt.setText("");
                password_txt.setText("");

                //setelah daftar muncul pop up dafatar berhasil dan akan tampil frame baru
                JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                MasukAkun ma = new MasukAkun();
                ma.setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_masukakun2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void labelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegisterMouseClicked
        // TODO add your handling code here:
        MasukAkun ma = new MasukAkun();
        ma.setVisible(true);
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
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
    private javax.swing.JPasswordField password_txt;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
