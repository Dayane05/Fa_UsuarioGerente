/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.bean;

import java.io.Serializable;

/**
 *
 * @author LAB 211
 */
public class UsuarioGerente implements Serializable{
    
    private int id;
    private int idU;
    private int idG;
    private String obs;
    private String nUsuario;
    private String nGerente;
    private Object usu;
    private Object ger;

    public UsuarioGerente(int id) {
        this.id = id;
    }

    public UsuarioGerente(String obs) {
        this.obs = obs;
    }
    
    public UsuarioGerente( int idU, int idG, String obs) {
        this.idU = idU;
        this.idG = idG;
        this.obs = obs;
    }

    public UsuarioGerente(int id, int idU, int idG, String obs) {
        this.id = id;
        this.idU = idU;
        this.idG = idG;
        this.obs = obs;
    }

    public UsuarioGerente(int id, int idU, int idG, String obs, String nUsuario, String nGerente, Object usu, Object ger) {
        this.id = id;
        this.idU = idU;
        this.idG = idG;
        this.obs = obs;
        this.nUsuario = nUsuario;
        this.nGerente = nGerente;
        this.usu = usu;
        this.ger = ger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdG() {
        return idG;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Object getUsu() {
        return usu;
    }

    public void setUsu(Object usu) {
        this.usu = usu;
    }

    public Object getGer() {
        return ger;
    }

    public void setGer(Object ger) {
        this.ger = ger;
    }

    public String getnUsuario() {
        return nUsuario;
    }

    public void setnUsuario(String nUsuario) {
        this.nUsuario = nUsuario;
    }

    public String getnGerente() {
        return nGerente;
    }

    public void setnGerente(String nGerente) {
        this.nGerente = nGerente;
    } 

    @Override
    public String toString() {
        return "UsuarioGerente{" + "id=" + id + ", idU=" + idU + ", idG=" + idG + ", obs=" + obs + '}';
    }
}
