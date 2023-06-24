public class Plato {
    private String nombre;
    private double precio;
    private double calorias;
    private int tiempo;

    public Plato(String nombre, double precio, double calorias, int tiempo) {
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "\nPlato:" +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nCalorias: " + calorias +
                "\nTiempo: " + tiempo;
    }
}
