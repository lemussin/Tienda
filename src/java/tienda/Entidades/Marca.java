package tienda.Entidades;

/**
 *
 * @author Eduardo Lemus Zavala
 */
public class Marca {
    int idMarca;
    String nombreMarca;
    String paisOrigen;

    public Marca(int idMarca, String nombreMarca, String paisOrigen) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.paisOrigen = paisOrigen;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    
    
}
