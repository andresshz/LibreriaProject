package dev.project.library.response;

public class ResponseClass {

    private String mensaje; // mensaje a retornar
    private Object object; // Json a retornar

    
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }

    

}
