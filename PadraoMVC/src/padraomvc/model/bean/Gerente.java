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
public class Gerente implements Serializable{
    
    private int id;
    private String nome;
    private String tipo;
    private String status;
    private String ip;

    public Gerente(int id) {
        this.id = id;
    }

    public Gerente(String nome) {
        this.nome = nome;
    }

    public Gerente(String nome, String tipo, String status, String ip) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
        this.ip = ip;
    }

    public Gerente(int id, String nome, String tipo, String status, String ip) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
        this.ip = ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
            return  nome ;
    } 
}
