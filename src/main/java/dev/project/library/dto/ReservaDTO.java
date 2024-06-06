package dev.project.library.dto;


public class ReservaDTO {

    private int idReserva;
    private int status;
    private String fecharetorno;

    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getFecharetorno() {
        return fecharetorno;
    }
    public void setFecharetorno(String fecharetorno) {
        this.fecharetorno = fecharetorno;
    }


}
