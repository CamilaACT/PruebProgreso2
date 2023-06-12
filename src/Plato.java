public class Plato {
    private String nombre;
    private double precio;
    private double valorCalorico;
    private int tiempopreparacio;

    public Plato(String nombre, double precio, double valorCalorico, int tiempopreparacio) {
        this.nombre = nombre;
        this.precio = precio;
        this.valorCalorico = valorCalorico;
        this.tiempopreparacio = tiempopreparacio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getValorCalorico() {
        return valorCalorico;
    }

    public int getTiempopreparacio() {
        return tiempopreparacio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setValorCalorico(double valorCalorico) {
        this.valorCalorico = valorCalorico;
    }

    public void setTiempopreparacio(int tiempopreparacio) {
        this.tiempopreparacio = tiempopreparacio;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", valorCalorico=" + valorCalorico +
                ", tiempopreparacio=" + tiempopreparacio +
                '}';
    }



}
