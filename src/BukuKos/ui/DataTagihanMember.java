/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BukuKos.ui;

import BukuKos.helper.Koneksi2;
import BukuKos.model.DataTagihan2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HP
 */
public class DataTagihanMember extends javax.swing.JFrame {
   PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form PenggunaMember
     */
    public DataTagihanMember() {
        initComponents();
         futchData();
    }
        //penempatan dan pencocokan data tabel di database dan di tabel JTable
    private void futchData() {
        ArrayList<DataTagihan2> list = dataTagihan();
        DefaultTableModel model = (DefaultTableModel) tagihan2_table.getModel();
        Object[] row = new Object[6];

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
            String sql = "SELECT id_tagihan, nama_member, tagihan, status_tagihan, "
                    + "tgl_bayar FROM tb_tagihan";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            DataTagihan2 DataTagihan;
            while (rs.next()) {
                DataTagihan = new DataTagihan2(rs.getString("id_tagihan"), rs.getString
                ("nama_member"), rs.getInt("tagihan"), rs.getString("status_tagihan"), 
                        rs.getString("tgl_bayar"));
                dataTagihan.add(DataTagihan);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dataTagihan;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tagihan2_table = new javax.swing.JTable();
        btn_kembali4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_refresh4 = new javax.swing.JButton();
        btn_cetak2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/logo bukukos kcl bgt.png"))); // NOI18N
        jLabel2.setText("BUKUKOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 102, -1));

        jTextField1.setBackground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 30));

        tagihan2_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tagihan", "ID Member", "Tagihan", "Status Tagihan", "Tgl Bayar"
            }
        ));
        jScrollPane1.setViewportView(tagihan2_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 610, 200));

        btn_kembali4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/previous.png"))); // NOI18N
        btn_kembali4.setText("Kembali");
        btn_kembali4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kembali4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/invoice.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 70, 70));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("DATA TAGIHAN");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 90, 20));

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });
        getContentPane().add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/11.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 680, 120));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/loupe.png"))); // NOI18N
        jLabel3.setText("Cari Data");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, 30));

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_refresh4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/refresh.png"))); // NOI18N
        btn_refresh4.setText("Refresh");
        btn_refresh4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_refresh4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, 30));

        btn_cetak2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BukuKos/icon/printer.png"))); // NOI18N
        btn_cetak2.setText("CETAK TAGIHAN");
        btn_cetak2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetak2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cetak2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 680, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembali4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali4ActionPerformed
        new DashboardMember().show();
        this.dispose();
    }//GEN-LAST:event_btn_kembali4ActionPerformed

    private void btn_refresh4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh4ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tagihan2_table.getModel();
        model.setRowCount(0);
        futchData();
    }//GEN-LAST:event_btn_refresh4ActionPerformed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        DefaultTableModel table = (DefaultTableModel) tagihan2_table.getModel();
        String search = txt_cari.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tagihan2_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_cariKeyReleased

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void btn_cetak2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetak2ActionPerformed
        try {
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream
        ("reportTagihan.jasper"), null, Koneksi2.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_btn_cetak2ActionPerformed

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
            java.util.logging.Logger.getLogger(DataTagihanMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataTagihanMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataTagihanMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataTagihanMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataTagihanMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetak2;
    private javax.swing.JButton btn_kembali4;
    private javax.swing.JButton btn_refresh4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tagihan2_table;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
