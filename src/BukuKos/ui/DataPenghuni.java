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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import BukuKos.model.DataPenghuni2;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HP
 */
public class DataPenghuni extends javax.swing.JFrame {
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form DataMember
     */
    public DataPenghuni() {
        initComponents();
        updateCombo();
        fitchData();
    }
    
   private void updateCombo() {
        String sql = "Select * from tb_kamar";
        try {
            Connection con = Koneksi2.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
//                comboBoxProfesi.addItem(rs.getString("id_kategori"));
                combo_id_kamar.addItem(rs.getString("id_kamar") + " | " + rs.getString("tarif"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }
   
       //penempatan dan pencocokan data tabel di database dan di tabel JTable
    private void fitchData() {
        ArrayList<DataPenghuni2> list = dataPenghuni();
        DefaultTableModel model = (DefaultTableModel) member_table.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId_member();
            row[1] = list.get(i).getNo_ktp();
            row[2] = list.get(i).getNama_member();
            row[3] = list.get(i).getAlamat();
            row[4] = list.get(i).getId_kamar();
            row[5] = list.get(i).getTgl_masuk();
            model.addRow(row);
        }
    }
    
        //perintah untuk memasukkan data ke dalam tabel dan select data
    public ArrayList<DataPenghuni2> dataPenghuni() {
        ArrayList<DataPenghuni2> dataPenghuni = new ArrayList<>();
        try {
            Connection con = Koneksi2.getConnection();
            String sql = "SELECT id_member, no_ktp, nama_member, alamat, id_kamar, tgl_masuk FROM tb_member";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            DataPenghuni2 DataPenghuni;
            while (rs.next()) {
                DataPenghuni = new DataPenghuni2(rs.getString("id_member"), rs.getInt("no_ktp"), rs.getString("nama_member"), rs.getString("alamat"), rs.getString("id_kamar"), rs.getString("tgl_masuk"));
                dataPenghuni.add(DataPenghuni);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dataPenghuni;
    }
   
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        member_table = new javax.swing.JTable();
        btn_tambah2 = new javax.swing.JButton();
        btn_edit2 = new javax.swing.JButton();
        btn_hapus2 = new javax.swing.JButton();
        btn_resfresh2 = new javax.swing.JButton();
        btn_kembali2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_idmember = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_ktp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tglmasuk = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        combo_id_kamar = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_cari02 = new javax.swing.JLabel();
        txt_cari3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/logo bukukos kcl bgt.png"))); // NOI18N
        jLabel1.setText("BUKUKOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 116, 26));

        jTextField1.setBackground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 30));

        member_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Member", "No. KTP", "Nama", "Alamat", "ID Kamar", "Tgl Masuk"
            }
        ));
        member_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                member_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(member_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 610, 150));

        btn_tambah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/button (1).png"))); // NOI18N
        btn_tambah2.setText("  Data Kamar");
        btn_tambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 130, 30));

        btn_edit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/edit.png"))); // NOI18N
        btn_edit2.setText("Edit");
        btn_edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, -1, 30));

        btn_hapus2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/delete.png"))); // NOI18N
        btn_hapus2.setText("Hapus");
        btn_hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, -1, 30));

        btn_resfresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/refresh.png"))); // NOI18N
        btn_resfresh2.setText("Refresh");
        btn_resfresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resfresh2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_resfresh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, 30));

        btn_kembali2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/previous.png"))); // NOI18N
        btn_kembali2.setText("Kembali");
        btn_kembali2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kembali2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("DATA PENGHUNI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 90, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/women.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, -10, 80, 70));
        jPanel1.add(txt_idmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 220, -1));

        jLabel4.setText("ID Member");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel6.setText("No. KTP");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));
        jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 540, -1));

        jLabel3.setText("Nama ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel5.setText("ID Kamar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        jPanel1.add(txt_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 240, -1));

        jLabel10.setText("Tgl Masuk");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jLabel11.setText("Alamat");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel1.add(txt_tglmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 240, -1));

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane3.setViewportView(txt_alamat);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 540, 50));

        jPanel1.add(combo_id_kamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 150, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/11.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 670, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 670, 280));

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cari02.setForeground(new java.awt.Color(255, 255, 255));
        txt_cari02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/loupe.png"))); // NOI18N
        txt_cari02.setText("Cari Data");
        jPanel2.add(txt_cari02, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 90, 30));

        txt_cari3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cari3ActionPerformed(evt);
            }
        });
        txt_cari3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cari3KeyReleased(evt);
            }
        });
        jPanel2.add(txt_cari3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 200, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 670, 250));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembali2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali2ActionPerformed
        new DashboardAdmin().show();
        this.dispose();
    }//GEN-LAST:event_btn_kembali2ActionPerformed

    private void btn_tambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah2ActionPerformed
        // masukan data ke dalam database
        String penghuniItem = combo_id_kamar.getSelectedItem().toString();
        String penghuni = penghuniItem.split("\\)", 2)[0];
        try {
            Connection con = Koneksi2.getConnection();
            //query insert data ke dalam database mysql
            pst = con.prepareStatement("INSERT INTO tb_member (id_member, no_ktp, nama_member, alamat, id_kamar, tgl_masuk) VALUES(?,?,?,?,?,?)");
            //validasi ketika textField kosong

            if (txt_idmember.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Member tidak boleh kosong");
            } else if (txt_ktp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No KTP tidak boleh kosong");
            } else if (txt_nama.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Member tidak boleh kosong");
            } else if (txt_alamat.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong");
            }  else if (txt_tglmasuk.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tgl Masuk tidak boleh kosong");
            } else {
                //digunakan untuk memasukkan data ke masing2 variabel textfield seperti namaTxt, dll

                //misal bingung pst sama rs bisa diliat di variabel diatas
                pst.setString(1, txt_idmember.getText());
                pst.setString(2, txt_ktp.getText());
                pst.setString(3, txt_nama.getText());
                pst.setString(4, txt_alamat.getText());
                pst.setString(5, penghuni);
                pst.setString(6, txt_tglmasuk.getText());
                pst.executeUpdate();

                //setelah nginput data kasih ini biar textfieldnya kosong lagi
                txt_idmember.setText("");
                txt_ktp.setText("");
                txt_nama.setText("");
                txt_alamat.setText("");
                combo_id_kamar.setSelectedItem("");
                txt_tglmasuk.setText("");

                //setelah daftar muncul pop up dafatar berhasil dan akan tampil frame baru
                JOptionPane.showMessageDialog(null, "Tambah Data Berhasil");
            }

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_tambah2ActionPerformed

    private void btn_resfresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resfresh2ActionPerformed
        //untuk me refresh tabel
        DefaultTableModel model = (DefaultTableModel) member_table.getModel();
        model.setRowCount(0);
        fitchData();
    }//GEN-LAST:event_btn_resfresh2ActionPerformed

    private void btn_edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit2ActionPerformed
        String penghuniItem = combo_id_kamar.getSelectedItem().toString();
        String penghuni = penghuniItem.split("\\)", 2)[0];
        //action button untuk mengedit data
        try {

            Connection con = Koneksi2.getConnection();
            int row = member_table.getSelectedRow();
            String value = (member_table.getModel().getValueAt(row, 0).toString());
            String sql = "UPDATE tb_member SET id_member=?,no_ktp=?,nama_member=?,alamat=?,id_kamar=?,tgl_masuk=? WHERE id_member= '" + value + "'";
            if (txt_idmember.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Member tidak boleh kosong");
            } else if (txt_ktp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No KTP tidak boleh kosong");
            } else if (txt_nama.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Member tidak boleh kosong");
            } else if (txt_alamat.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong");
            }  else if (txt_tglmasuk.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tgl Masuk tidak boleh kosong");
            } else {
                pst = con.prepareStatement(sql);
                pst.setString(1, txt_idmember.getText());
                pst.setString(2, txt_ktp.getText());
                pst.setString(3, txt_nama.getText());
                pst.setString(4, txt_alamat.getText());
                pst.setString(5, penghuni);
                pst.setString(6, txt_tglmasuk.getText());
                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel) member_table.getModel();
                model.setRowCount(0);
                fitchData();
                txt_idmember.setText("");
                txt_ktp.setText("");
                txt_nama.setText("");
                txt_alamat.setText("");
                combo_id_kamar.setSelectedItem("");
                txt_tglmasuk.setText("");
                JOptionPane.showMessageDialog(null, "Edit Selesai");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }//GEN-LAST:event_btn_edit2ActionPerformed

    private void member_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_member_tableMouseClicked
        //code ini berfungsi ngambil value di dalem tabel habisi itu dimasukin lagi ke textfield biar bisa di edit
        int i = member_table.getSelectedRow();
        TableModel model = member_table.getModel();
        txt_idmember.setText(model.getValueAt(i, 0).toString());
        txt_ktp.setText(model.getValueAt(i, 1).toString());
        txt_nama.setText(model.getValueAt(i, 2).toString());
        txt_alamat.setText(model.getValueAt(i, 3).toString());
        txt_tglmasuk.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_member_tableMouseClicked

    private void btn_hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus2ActionPerformed
        try {

            int row = member_table.getSelectedRow();
            Connection con = Koneksi2.getConnection();
            String value = (member_table.getModel().getValueAt(row, 0).toString());
            String sql = "DELETE FROM tb_member WHERE id_member = '" + value + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) member_table.getModel();
            model.setRowCount(0);
            fitchData();
            JOptionPane.showMessageDialog(null, "Data terhapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btn_hapus2ActionPerformed

    private void txt_cari3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cari3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari3ActionPerformed

    private void txt_cari3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari3KeyReleased
        DefaultTableModel table = (DefaultTableModel) member_table.getModel();
        String search = txt_cari3.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        member_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));   
    }//GEN-LAST:event_txt_cari3KeyReleased

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
            java.util.logging.Logger.getLogger(DataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPenghuni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit2;
    private javax.swing.JButton btn_hapus2;
    private javax.swing.JButton btn_kembali2;
    private javax.swing.JButton btn_resfresh2;
    private javax.swing.JButton btn_tambah2;
    private javax.swing.JComboBox<String> combo_id_kamar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable member_table;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JLabel txt_cari02;
    private javax.swing.JTextField txt_cari3;
    private javax.swing.JTextField txt_idmember;
    private javax.swing.JTextField txt_ktp;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_tglmasuk;
    // End of variables declaration//GEN-END:variables
}