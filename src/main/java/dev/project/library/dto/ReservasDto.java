package dev.project.library.dto;

public class ReservasDto {

    private int id_libro;
    private int id_usuario;
    private String fechareserva;
    private String fecharetorno;
    private int status;
    

    public int getId_libro() {
        return id_libro;
    }
    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getFechareserva() {
        return fechareserva;
    }
    public void setFechareserva(String fechareserva) {
        this.fechareserva = fechareserva;
    }
    public String getFecharetorno() {
        return fecharetorno;
    }
    public void setFecharetorno(String fecharetorno) {
        this.fecharetorno = fecharetorno;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }


    
}
