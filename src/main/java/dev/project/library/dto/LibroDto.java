package dev.project.library.dto;



public class LibroDto {

    private String nombreLibro;
    private String descripcion;
    private String fechaIngreso;


    public String getNombreLibro() {
        return nombreLibro;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getFechaIngreso() {
        return fechaIngreso;
    }
    

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    


    
}
