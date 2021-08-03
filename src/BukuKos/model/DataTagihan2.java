/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BukuKos.model;

/**
 *
 * @author HP
 */
public class DataTagihan2 {
    int tagihan;
    String id_tagihan, nama_member, status_tagihan, tgl_bayar;

    public DataTagihan2(String id_tagihan, String nama_member, int tagihan, String status_tagihan, String tgl_bayar){
         this.id_tagihan = id_tagihan;
         this.nama_member = nama_member;
         this.tagihan = tagihan;
         this.status_tagihan = status_tagihan;
         this.tgl_bayar = tgl_bayar;
    }

    public int getTagihan() {
        return tagihan;
    }

    public void setTagihan(int tagihan) {
        this.tagihan = tagihan;
    }

    public String getId_tagihan() {
        return id_tagihan;
    }

    public void setId_tagihan(String id_tagihan) {
        this.id_tagihan = id_tagihan;
    }

    public String getNama_member() {
        return nama_member;
    }

    public void setNama_member(String nama_member) {
        this.nama_member = nama_member;
    }

   

    public String getStatus_tagihan() {
        return status_tagihan;
    }

    public void setStatus_tagihan(String status_tagihan) {
        this.status_tagihan = status_tagihan;
    }

    public String getTgl_bayar() {
        return tgl_bayar;
    }

    public void setTgl_bayar(String tgl_bayar) {
        this.tgl_bayar = tgl_bayar;
    }
    
    
}
