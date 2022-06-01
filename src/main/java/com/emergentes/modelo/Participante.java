package com.emergentes.modelo;

public class Participante {
    private int id;
    private String apellidos;
    private String nombres;    
    private String id_seminario;
    private String confirmado;

    public Participante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getId_seminario() {
        return id_seminario;
    }

    public void setId_seminario(String id_seminario) {
        this.id_seminario = id_seminario;
    }

    public String getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public String toString() {
        return "Participante{" + "id=" + id + ", apellidos=" + apellidos + ", nombres=" + nombres + ", id_seminario=" + id_seminario + ", confirmado=" + confirmado + '}';
    }
}
