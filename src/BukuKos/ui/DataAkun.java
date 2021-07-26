/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BukuKos.ui;
import BukuKos.helper.Koneksi2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import BukuKos.model.DataAkun2;

public class DataAkun extends javax.swing.JFrame {
    
    PreparedStatement pst = null;
    ResultSet rs = null;

    public DataAkun() {
        initComponents();
        fatchData();
    }
    //penempatan dan pencocokan data tabel di database dan di tabel JTable
    private void fatchData() {
        ArrayList<DataAkun2> list = daftarAkun();
        DefaultTableModel model = (DefaultTableModel) akun_table.getModel();
        Object[] row = new Object[4];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId_login();
            row[1] = list.get(i).getUsername();
            row[2] = list.get(i).getPassword_2();
            row[3] = list.get(i).getId_level();
            model.addRow(row);
        }
    }
    
    //perintah untuk memasukkan data ke dalam tabel dan select data
    public ArrayList<DataAkun2> daftarAkun() {
        ArrayList<DataAkun2> daftarAkun = new ArrayList<>();
        try {
            Connection con = Koneksi2.getConnection();
            String sql = "SELECT id_login, username, password_2, id_level FROM tb_login";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            DataAkun2 DaftarAkun;
            while (rs.next()) {
                DaftarAkun = new DataAkun2(rs.getInt("id_login"), rs.getString("username"), 
                        rs.getString("password_2"), rs.getInt("id_level"));
                daftarAkun.add(DaftarAkun);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return daftarAkun;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btn_tambah5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_idlogin2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        akun_table = new javax.swing.JTable();
        btn_kembali5 = new javax.swing.JButton();
        btn_refresh5 = new javax.swing.JButton();
        btn_edit5 = new javax.swing.JButton();
        btn_hapus5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_katasandi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        combo_level = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 370));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/logo bukukos kcl bgt.png"))); // NOI18N
        jLabel2.setText("BUKUKOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, -1));

        jTextField1.setBackground(new java.awt.Color(102, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 30));

        btn_tambah5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/plus1.png"))); // NOI18N
        btn_tambah5.setText("Pengguna Akun");
        btn_tambah5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/user2.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 50, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("DATA AKUN");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, 20));

        jLabel7.setText("Username");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        jLabel8.setText("Kata Sandi");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jLabel9.setText("ID Login");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 20));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 250, -1));
        getContentPane().add(txt_idlogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 250, -1));

        akun_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Login", "Username", "Password", "ID Level"
            }
        ));
        akun_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                akun_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(akun_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 630, 200));

        btn_kembali5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/back.png"))); // NOI18N
        btn_kembali5.setText("Kembali");
        btn_kembali5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kembali5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, 40));

        btn_refresh5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/circular-arrow.png"))); // NOI18N
        btn_refresh5.setText("Refresh");
        btn_refresh5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_refresh5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, 40));

        btn_edit5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/pencilll.png"))); // NOI18N
        btn_edit5.setText("Edit");
        btn_edit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 90, 40));

        btn_hapus5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/delete1.png"))); // NOI18N
        btn_hapus5.setText("Hapus");
        btn_hapus5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, -1, 40));

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 680, 300));

        txt_katasandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_katasandiActionPerformed(evt);
            }
        });
        getContentPane().add(txt_katasandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 200, -1));

        jLabel10.setText("ID Level");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, 20));

        combo_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        getContentPane().add(combo_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 200, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/11.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 680, 240));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btn_tambah5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah5ActionPerformed
        // masukan data ke dalam database
        String levelItem = combo_level.getSelectedItem().toString();
        String level = levelItem.split("\\)", 2)[0];
        try {
            Connection con = Koneksi2.getConnection();
            //query insert data ke dalam database mysql
            pst = con.prepareStatement("INSERT INTO tb_login (id_login, username, "
                    + "password_2, id_level) VALUES(?,?,?,?)");
            //validasi ketika textField kosong

            if (txt_idlogin2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Login tidak boleh kosong");
            } else if (txt_username.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username tidak boleh kosong");
            } else if (txt_katasandi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kata Sandi tidak boleh kosong");   
            } else {
                //digunakan untuk memasukkan data ke masing2 variabel textfield 

                //misal bingung pst sama rs bisa diliat di variabel diatas
                pst.setString(1, txt_idlogin2.getText());
                pst.setString(2, txt_username.getText());
                pst.setString(3, txt_katasandi.getText());
                pst.setString(4, combo_level.getSelectedItem().toString());
                pst.executeUpdate();

                //setelah nginput data kasih ini biar textfieldnya kosong lagi
                txt_idlogin2.setText("");
                txt_username.setText("");
                txt_katasandi.setText("");
                combo_level.setSelectedItem("");

                //setelah daftar muncul pop up dafatar berhasil dan akan tampil frame baru
                JOptionPane.showMessageDialog(null, "Tambah Data Berhasil");
            }

        } catch (Exception e) {
            //            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_tambah5ActionPerformed

    private void akun_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_akun_tableMouseClicked
        //code ini berfungsi ngambil value di dalem tabel habisi itu dimasukin lagi ke textfield biar bisa di edit
        int i = akun_table.getSelectedRow();
        TableModel model = akun_table.getModel();
        txt_idlogin2.setText(model.getValueAt(i, 0).toString());
        txt_username.setText(model.getValueAt(i, 1).toString());
        txt_katasandi.setText(model.getValueAt(i, 2).toString());
        combo_level.setSelectedItem(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_akun_tableMouseClicked

    private void btn_kembali5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali5ActionPerformed
        new DashboardAdmin().show();
        this.dispose();
    }//GEN-LAST:event_btn_kembali5ActionPerformed

    private void btn_refresh5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh5ActionPerformed
        //untuk me refresh tabel
        DefaultTableModel model = (DefaultTableModel) akun_table.getModel();
        model.setRowCount(0);
        fatchData();
    }//GEN-LAST:event_btn_refresh5ActionPerformed

    private void btn_edit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit5ActionPerformed
        String levelItem = combo_level.getSelectedItem().toString();
        String level = levelItem.split("\\)", 2)[0];
        
        //action button untuk mengedit data
        try {

            Connection con = Koneksi2.getConnection();
            int row = akun_table.getSelectedRow();
            String value = (akun_table.getModel().getValueAt(row, 0).toString());
            String sql = "UPDATE tb_login SET id_login=?,username=?,password_2=?, "
                    + "id_level=? WHERE id_login= " + value;
            if (txt_idlogin2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Login tidak boleh kosong");
            } else if (txt_username.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username tidak boleh kosong");
            } else if (txt_katasandi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kata Sandi tidak boleh kosong");   
            } else {
                pst = con.prepareStatement(sql);
                pst.setString(1, txt_idlogin2.getText());
                pst.setString(2, txt_username.getText());
                pst.setString(3, txt_katasandi.getText());
                pst.setString(4, combo_level.getSelectedItem().toString());
                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel) akun_table.getModel();
                model.setRowCount(0);
                fatchData();
                txt_idlogin2.setText("");
                txt_username.setText("");
                txt_katasandi.setText("");
                combo_level.setSelectedItem("");
                JOptionPane.showMessageDialog(null, "Edit Selesai");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btn_edit5ActionPerformed

    private void btn_hapus5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus5ActionPerformed
        try {

            int row = akun_table.getSelectedRow();
            Connection con = Koneksi2.getConnection();
            String value = (akun_table.getModel().getValueAt(row, 0).toString());
            String sql = "DELETE FROM tb_login WHERE id_login = '" + value + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) akun_table.getModel();
            model.setRowCount(0);
            fatchData();
            JOptionPane.showMessageDialog(null, "Data terhapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btn_hapus5ActionPerformed

    private void txt_katasandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_katasandiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_katasandiActionPerformed

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
            java.util.logging.Logger.getLogger(DataAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataAkun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable akun_table;
    private javax.swing.JButton btn_edit5;
    private javax.swing.JButton btn_hapus5;
    private javax.swing.JButton btn_kembali5;
    private javax.swing.JButton btn_refresh5;
    private javax.swing.JButton btn_tambah5;
    private javax.swing.JComboBox<String> combo_level;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txt_idlogin2;
    private javax.swing.JTextField txt_katasandi;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}