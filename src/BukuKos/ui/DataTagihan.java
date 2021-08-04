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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import BukuKos.model.DataTagihan2;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class DataTagihan extends javax.swing.JFrame {

    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form DataTagihan
     */
    public DataTagihan() {
        initComponents();
        futchData();
        setDateDefault();
        updateCombo();
    }

    private void setDateDefault() {
        try {
            String date = "01 Jan 0000";
            Date date2 = new SimpleDateFormat("dd MMM yyyy").parse(date);
            txt_tglbayar.setDate(date2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void updateCombo() {
        String sql = "Select * from tb_member";
        try {
            Connection con = Koneksi2.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
//                comboBoxProfesi.addItem(rs.getString("id_kategori"));
                combo_nama_member.addItem(rs.getString("nama_member"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }

    //penempatan dan pencocokan data tabel di database dan di tabel JTable
    private void futchData() {

        ArrayList<DataTagihan2> list = dataTagihan();
        DefaultTableModel model = (DefaultTableModel) tagihan_table.getModel();

        Object[] row = new Object[6];
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId_tagihan();
            row[1] = list.get(i).getNama_member();
            row[2] = list.get(i).getTagihan();
            row[3] = list.get(i).getStatus_tagihan();
            row[4] = list.get(i).getTgl_bayar();
            model.addRow(row);
        }
    }

    //perintah untuk memasukkan data ke dalam tabel dan select data
    public ArrayList<DataTagihan2> dataTagihan() {
        ArrayList<DataTagihan2> dataTagihan = new ArrayList<>();
        try {
            Connection con = Koneksi2.getConnection();
            String sql = "SELECT id_tagihan, nama_member, tagihan, status_tagihan, tgl_bayar FROM tb_tagihan";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            DataTagihan2 DataTagihan;
            while (rs.next()) {
                DataTagihan = new DataTagihan2(rs.getString("id_tagihan"), rs.getString("nama_member"), rs.getInt("tagihan"), rs.getString("status_tagihan"), rs.getString("tgl_bayar"));
                dataTagihan.add(DataTagihan);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dataTagihan;
    }

    public void tambahDataTemp() {
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");

        String statusItem = combo_status.getSelectedItem().toString();
        String status = statusItem.split("\\)", 2)[0];
        try {
            Connection con = Koneksi2.getConnection();
            //query insert data ke dalam database mysql
            pst = con.prepareStatement("INSERT INTO tb_tagihan_nota (id_tagihan, nama_member, tagihan, status_tagihan, tgl_bayar) VALUES(?,?,?,?,?)");
            //validasi ketika textField kosong

            if (txt_idtagihan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Tagihan tidak boleh kosong");
            } else if (txt_tagihan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tagihan tidak boleh kosong");
            } else {
                //digunakan untuk memasukkan data ke masing2 variabel textfield seperti namaTxt, dll
                
                //misal bingung pst sama rs bisa diliat di variabel diatas
                pst.setString(1, txt_idtagihan.getText());
                pst.setString(2, combo_nama_member.getSelectedItem().toString());
                pst.setString(3, txt_tagihan.getText());
                pst.setString(4, combo_status.getSelectedItem().toString());
                pst.setString(5, Date_Format.format(txt_tglbayar.getDate()));
                pst.executeUpdate();

                //setelah nginput data kasih ini biar textfieldnya kosong lagi
                txt_idtagihan.setText("");
                //txt_idmember.setText("");
                txt_tagihan.setText("");
                combo_status.setSelectedItem("");

                //setelah daftar muncul pop up dafatar berhasil dan akan tampil frame baru
                JOptionPane.showMessageDialog(null, "Tambah Data Berhasil");
            }

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void tambahDataTemp2(){
         SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");

        String statusItem = combo_status.getSelectedItem().toString();
        String status = statusItem.split("\\)", 2)[0];
        try {
            Connection con = Koneksi2.getConnection();
            //query insert data ke dalam database mysql
            pst = con.prepareStatement("INSERT INTO tb_tagihan (id_tagihan, nama_member, tagihan, status_tagihan, tgl_bayar) VALUES(?,?,?,?,?)");
            //validasi ketika textField kosong

            if (txt_idtagihan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Tagihan tidak boleh kosong");
            } else if (txt_tagihan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tagihan tidak boleh kosong");
            } else {
                //digunakan untuk memasukkan data ke masing2 variabel textfield seperti namaTxt, dll

                //misal bingung pst sama rs bisa diliat di variabel diatas
                pst.setString(1, txt_idtagihan.getText());
                pst.setString(2, combo_nama_member.getSelectedItem().toString());
                pst.setString(3, txt_tagihan.getText());
                pst.setString(4, combo_status.getSelectedItem().toString());
                pst.setString(5, Date_Format.format(txt_tglbayar.getDate()));
                pst.executeUpdate();

              

                //setelah daftar muncul pop up dafatar berhasil dan akan tampil frame baru
                JOptionPane.showMessageDialog(null, "Tambah Data Berhasil");
               

            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void tampilkanData() {
        Koneksi2 koneksi = new Koneksi2();
        int jumlahrow = tagihan_table.getRowCount();
        for (int n = 0; n < jumlahrow; n++) {

        }

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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        combo_nama_member = new javax.swing.JComboBox<>();
        txt_tglbayar = new com.toedter.calendar.JDateChooser();
        btn_tambah3 = new javax.swing.JButton();
        txt_idtagihan = new javax.swing.JTextField();
        txt_tagihan = new javax.swing.JTextField();
        combo_status = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tagihan_table = new javax.swing.JTable();
        btn_kembali3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_cari2 = new javax.swing.JTextField();
        btn_cetak = new javax.swing.JButton();
        txt_edit3 = new javax.swing.JButton();
        btn_refresh3 = new javax.swing.JButton();
        txt_hapus3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/logo bukukos kcl bgt.png"))); // NOI18N
        jLabel1.setText("BUKUKOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 116, 26));

        jTextField1.setBackground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/invoice.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 70, 70));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("DATA TAGIHAN");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 90, 20));

        jPanel1.setBackground(new java.awt.Color(220, 221, 225));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(combo_nama_member, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 190, -1));

        txt_tglbayar.setDateFormatString("yyyy, MM, dd");
        jPanel1.add(txt_tglbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 130, 210, -1));

        btn_tambah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/button (1).png"))); // NOI18N
        btn_tambah3.setText("  Data Kamar");
        btn_tambah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 130, 30));
        jPanel1.add(txt_idtagihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 200, -1));
        jPanel1.add(txt_tagihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 200, -1));

        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Lunas", "Lunas", " " }));
        combo_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_statusActionPerformed(evt);
            }
        });
        jPanel1.add(combo_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 200, -1));

        jLabel4.setText("Nama");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel10.setText("Tgl Bayar");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        jLabel6.setText("ID Tagihan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel3.setText("Tagihan ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel11.setText("Status Tagihan");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/11.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 670, 240));

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tagihan_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tagihan", "Nama Member", "Tagihan", "Status Tagihan", "Tgl Bayar"
            }
        ));
        tagihan_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tagihan_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tagihan_table);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 600, 190));

        btn_kembali3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/previous.png"))); // NOI18N
        btn_kembali3.setText("Kembali");
        btn_kembali3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_kembali3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/loupe.png"))); // NOI18N
        jLabel5.setText("Cari Data");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 90, -1));

        txt_cari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cari2ActionPerformed(evt);
            }
        });
        txt_cari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cari2KeyReleased(evt);
            }
        });
        jPanel2.add(txt_cari2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 180, 30));

        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/printer.png"))); // NOI18N
        btn_cetak.setText("CETAK TAGIHAN");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        jPanel2.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 150, -1));

        txt_edit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/edit.png"))); // NOI18N
        txt_edit3.setText("Edit");
        txt_edit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_edit3ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_edit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        btn_refresh3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/refresh.png"))); // NOI18N
        btn_refresh3.setText("Refresh");
        btn_refresh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_refresh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 30));

        txt_hapus3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/delete.png"))); // NOI18N
        txt_hapus3.setText("Hapus");
        txt_hapus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hapus3ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_hapus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 670, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah3ActionPerformed
        // masukan data ke dalam database
        tambahDataTemp2();
        tambahDataTemp();
        
       
    }//GEN-LAST:event_btn_tambah3ActionPerformed

    private void btn_kembali3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali3ActionPerformed
        new DashboardAdmin().show();
        this.dispose();
    }//GEN-LAST:event_btn_kembali3ActionPerformed

    private void btn_refresh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh3ActionPerformed
        //untuk me refresh tabel
        DefaultTableModel model = (DefaultTableModel) tagihan_table.getModel();
        model.setRowCount(0);
        futchData();
    }//GEN-LAST:event_btn_refresh3ActionPerformed

    private void txt_edit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_edit3ActionPerformed
        String statusItem = combo_status.getSelectedItem().toString();
        String status = statusItem.split("\\)", 2)[0];
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
        //action button untuk mengedit data
        try {

            Connection con = Koneksi2.getConnection();
            int row = tagihan_table.getSelectedRow();
            String value = (tagihan_table.getModel().getValueAt(row, 0).toString());
            String sql = "UPDATE tb_tagihan SET id_tagihan=?,nama_member=?,tagihan=?,"
                    + "status_tagihan=?,tgl_bayar=? WHERE id_tagihan= '" + value + "'";
            if (txt_idtagihan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Tagihan tidak boleh kosong");
            } else if (txt_tagihan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tagihan tidak boleh kosong");
            } else {
                pst = con.prepareStatement(sql);
                pst.setString(1, txt_idtagihan.getText());
                pst.setString(2, combo_nama_member.getSelectedItem().toString());
                pst.setString(3, txt_tagihan.getText());
                pst.setString(4, combo_status.getSelectedItem().toString());
                pst.setString(5, Date_Format.format(txt_tglbayar.getDate()));
                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel) tagihan_table.getModel();
                model.setRowCount(0);
                futchData();
                txt_idtagihan.setText("");
                //txt_idmember.setText("");
                txt_tagihan.setText("");
                combo_status.setSelectedItem("");

                JOptionPane.showMessageDialog(null, "Edit Selesai");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }//GEN-LAST:event_txt_edit3ActionPerformed

    private void tagihan_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tagihan_tableMouseClicked
        //code ini berfungsi ngambil value di dalem tabel habisi itu dimasukin lagi ke textfield biar bisa di edit
        int i = tagihan_table.getSelectedRow();
        TableModel model = tagihan_table.getModel();
        txt_idtagihan.setText(model.getValueAt(i, 0).toString());
        // txt_idmember.setText(model.getValueAt(i, 1).toString());
        txt_tagihan.setText(model.getValueAt(i, 2).toString());
        // txt_tglbayar.setDate(model.getValueAt(i, 5));
        combo_status.setSelectedItem(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_tagihan_tableMouseClicked

    private void txt_hapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hapus3ActionPerformed
        try {

            int row = tagihan_table.getSelectedRow();
            Connection con = Koneksi2.getConnection();
            String value = (tagihan_table.getModel().getValueAt(row, 0).toString());
            String sql = "DELETE FROM tb_tagihan WHERE id_tagihan = '" + value + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tagihan_table.getModel();
            model.setRowCount(0);
            futchData();
            JOptionPane.showMessageDialog(null, "Data terhapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_txt_hapus3ActionPerformed

    private void txt_cari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cari2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari2ActionPerformed

    private void txt_cari2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari2KeyReleased
        DefaultTableModel table = (DefaultTableModel) tagihan_table.getModel();
        String search = txt_cari2.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tagihan_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_cari2KeyReleased

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        int selectedRow = tagihan_table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih Baris Dulu");
        } else {
            try {
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportTagihan.jasper"), null, Koneksi2.getConnection());
                JasperViewer.viewReport(jp, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }

//        try {
//            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportTagihan.jasper"), null, Koneksi2.getConnection());
//            JasperViewer.viewReport(jp, false);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, e);
//        }

    }//GEN-LAST:event_btn_cetakActionPerformed

    private void combo_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_statusActionPerformed

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
            java.util.logging.Logger.getLogger(DataTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataTagihan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetak;
    private javax.swing.JButton btn_kembali3;
    private javax.swing.JButton btn_refresh3;
    private javax.swing.JButton btn_tambah3;
    private javax.swing.JComboBox<String> combo_nama_member;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tagihan_table;
    private javax.swing.JTextField txt_cari2;
    private javax.swing.JButton txt_edit3;
    private javax.swing.JButton txt_hapus3;
    private javax.swing.JTextField txt_idtagihan;
    private javax.swing.JTextField txt_tagihan;
    private com.toedter.calendar.JDateChooser txt_tglbayar;
    // End of variables declaration//GEN-END:variables
}
