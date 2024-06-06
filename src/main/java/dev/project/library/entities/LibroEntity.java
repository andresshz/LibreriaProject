package dev.project.library.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "Libros", schema = "")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombrelibro")
    private String nombreLibro;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaingreso")
    private Timestamp fechaIngreso;

    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getId() {
        return id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

}
