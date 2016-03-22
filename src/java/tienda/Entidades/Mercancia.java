package tienda.Entidades;

/**
 *
 * @author Eduardo Lemus Zavala
 */
public class Mercancia {
    int idMercanciaRegistrada;
    int idMercancia;
    int idGenero;
    String nombreMercancia;
    int cantidad;
    int idMarca;
    int idColorBase;
    double precio;
    String descripcion;
    String fechaRegistro;
    double usuarioRegistro;

    public Mercancia(int idMercanciaRegistrada, int idMercancia, int idGenero, String nombreMercancia, int cantidad, int idMarca, int idColorBase, double precio, String descripcion, String fechaRegistro, double usuarioRegistro) {
        this.idMercanciaRegistrada = idMercanciaRegistrada;
        this.idMercancia = idMercancia;
        this.idGenero = idGenero;
        this.nombreMercancia = nombreMercancia;
        this.cantidad = cantidad;
        this.idMarca = idMarca;
        this.idColorBase = idColorBase;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public int getIdMercanciaRegistrada() {
        return idMercanciaRegistrada;
    }

    public void setIdMercanciaRegistrada(int idMercanciaRegistrada) {
        this.idMercanciaRegistrada = idMercanciaRegistrada;
    }

    public int getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(int idMercancia) {
        this.idMercancia = idMercancia;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreMercancia() {
        return nombreMercancia;
    }

    public void setNombreMercancia(String nombreMercancia) {
        this.nombreMercancia = nombreMercancia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdColorBase() {
        return idColorBase;
    }

    public void setIdColorBase(int idColorBase) {
        this.idColorBase = idColorBase;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(double usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }
    
    

}
