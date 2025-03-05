package org.uv.dapp02practica02;


public class EmpleadoPojo {
    private long clave;
    private String nombre;
    private String direccion;  
    private String telefono;
    
    public EmpleadoPojo() {
    }

    public EmpleadoPojo(long clave, String nombre, String direccion, String telefono) {
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {  
        return direccion;
    }

    public void setDireccion(String direccion) {  
        this.direccion = direccion;
    }
}
