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
public class DataKamar2 {
    
     int lantai, tarif;
     String id_kamar, fasilitas; 
     
     public DataKamar2(String id_kamar, int lantai, String fasilitas, int tarif){
         this.id_kamar = id_kamar;
         this.lantai = lantai;
         this.fasilitas = fasilitas;
         this.tarif = tarif;
     }
     
    public String getId_kamar() {
        return id_kamar;
    }

    public void setId_kamar(String id_kamar) {
        this.id_kamar = id_kamar;
    }

    public int getLantai() {
        return lantai;
    }

    public void setLantai(int lantai) {
        this.lantai = lantai;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

}