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
    String id_tagihan, id_member, status_tagihan, tgl_bayar;

    public DataTagihan2(String id_tagihan, String id_member, int tagihan, String status_tagihan, String tgl_bayar){
         this.id_tagihan = id_tagihan;
         this.id_member = id_member;
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

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
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
