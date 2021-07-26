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
public class DataPenghuni2 {
    
    int no_ktp;
    String id_member, nama_member, alamat, id_kamar, tgl_masuk;
    
    public DataPenghuni2 (String id_member, int no_ktp, String nama_member, String alamat, String id_kamar, String tgl_masuk){
        this.id_member = id_member;
        this.no_ktp = no_ktp;
        this.nama_member = nama_member;
        this.alamat = alamat;
        this.id_kamar = id_kamar;
        this.tgl_masuk = tgl_masuk;
    }

    public int getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(int no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
    }

    public String getNama_member() {
        return nama_member;
    }

    public void setNama_member(String nama_member) {
        this.nama_member = nama_member;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(String id_kamar) {
        this.id_kamar = id_kamar;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }
      
}
