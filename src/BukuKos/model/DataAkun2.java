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
public class DataAkun2 {
    
    int id_login, id_level;
    String username, password_2;

    public DataAkun2(int id_login, String username, String password_2, int id_level) {
        this.id_login = id_login;
        this.username = username;
        this.password_2 = password_2;
        this.id_level = id_level;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_2() {
        return password_2;
    }

    public void setPassword_2(String password_2) {
        this.password_2 = password_2;
    }
    
    public int getId_level() {
        return id_level;
    }

    public void setId_level(int id_level) {
        this.id_level = id_level;
    }
}
