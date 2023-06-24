import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu {
    private List<Plato> listaPlatos=new ArrayList<>();
    private Ordenamiento orden1=new Ordenamiento();;



    public boolean ingresarPlato(Plato p){
        if (BuscarPorNombre(p.getNombre())==null){
            listaPlatos.add(p);
            return true;
        }else {
            return false;
        }
    }

    /**
     * Busqueda secuencial, busca los platos en base al nombre
     * @param nombre
     * @return
     */
    public Plato BuscarPorNombre(String nombre) {
        for (Plato p: listaPlatos) {
            if (p.getNombre().equals(nombre)){
                return p;
            }

        }
        return null;
    }
    public void QuemarDatos(){
        listaPlatos.add(new Plato("Pizza",10, 2.4,4));
        listaPlatos.add(new Plato("Pan",3, 11.2,2));
        listaPlatos.add(new Plato("Hamburguesa",8.5, 24.4,10));
        listaPlatos.add(new Plato("Sopa",2.5, 3.6,1));
        listaPlatos.add(new Plato("Fideos",3.5, 54.8,30));
    }
    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }
    public boolean ModificarDatos(String nombre, double precio, double calorias, int tiempo) {
        Plato p1=BuscarPorNombre(nombre);
        if (p1!=null){
            p1.setPrecio(precio);
            p1.setCalorias(calorias);
            p1.setTiempo(tiempo);
            return true;
        }
        return false;
    }
    public Plato eliminarPlato(String nombre){
        Plato p1;
        for (int i=0;i<listaPlatos.size();i++){
            p1=listaPlatos.get(i);
            if (p1.getNombre().equals(nombre)){
                listaPlatos.remove(i);
                return p1;
            }
        }
        return null;
    }

    /**
     * Ordena por precio
     */

    public void ordenarPorPrecio(){

        orden1.OrdenamientoBurbujaPorPrecio(listaPlatos);
    }

    /**
     * Ordena por Nombre
     */
    public void ordenarPorNombre(){
        orden1.OrdenamientoBurbujaPorNombre(listaPlatos);
    }

    /**
     * Ordena por Calorías
     */
    public void ordenarPorCalorias(){
        orden1.OrdenInsercionPorCalorias(listaPlatos);
    }

    /**
     * Ordena por Tiempo
     */
    public void ordenarPorTiempo(){
        orden1.OrdenInsercionPorTiempo(listaPlatos);
    }

    @Override
    public String toString() {
        return "Menu:" +
                "ListaPlatos:" + listaPlatos;
    }
    public List<Plato> buscarPlato(String valor, String opcion) {
        switch (opcion) {
            case "Nombre":
                //ordenarPorNombre();
                return orden1.busquedaBinariaNombre(valor,listaPlatos);
            case "Precio":
                //ordenarPorPrecio();
                double precio = Double.parseDouble(valor);
                return orden1.busquedaBinariaPrecio(precio,listaPlatos);
            case "Calorias":
                //ordenarPorCalorias();
                int calorias = Integer.parseInt(valor);
                return orden1.busquedaBinariaCalorias(calorias,listaPlatos);
            case "Minutos":
                //orden.ordenamientoInsercionMinutos(lista);
                int minutos = Integer.parseInt(valor);
                return orden1.busquedaBinariaMinutos(minutos, listaPlatos);
        }
        return null;
    }
}
