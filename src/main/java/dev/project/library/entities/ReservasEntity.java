package dev.project.library.entities;


import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservas")
public class ReservasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private LibroEntity libro;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuariosEntity usuario;

    @Column(name = "fechareserva")
    private Timestamp fechareserva;

    @Column(name = "fecharetorno")
    private Timestamp fecharetorno;

    @Column(name = "status")
    private int status;

    
    public LibroEntity getLibro() {
        return libro;
    }
    public void setLibro(LibroEntity libro) {
        this.libro = libro;
    }
    public UsuariosEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFechareserva() {
        return fechareserva;
    }
    public void setFechareserva(Timestamp fechareserva) {
        this.fechareserva = fechareserva;
    }
    public Timestamp getFecharetorno() {
        return fecharetorno;
    }
    public void setFecharetorno(Timestamp fecharetorno) {
        this.fecharetorno = fecharetorno;
    }
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    
}
