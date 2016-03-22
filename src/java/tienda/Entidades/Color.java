package tienda.Entidades;

/**
 *
 * @author Eduardo Lemus Zavala
 */
public class Color {
    int idColor;
    String color;

    public Color(int idColor, String color) {
        this.idColor = idColor;
        this.color = color;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
