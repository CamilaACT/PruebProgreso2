import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu {

    private List<Plato> listaPlatos;

    public Menu() {
        this.listaPlatos = new ArrayList<Plato>();
    }
    public boolean addPlato(Plato plato){
        if(busquedaPlato(plato.getNombre())==null){
            listaPlatos.add(plato);
            return true;
        }else{
            return false;
        }

    }


    public Plato busquedaPlato(String nombre){
        for (Plato plato1 : listaPlatos) {
            if(plato1.getNombre().equals(nombre)){
                return plato1;
            }
        }
        return null;
    }
    public Plato removePlatoPorNombre(String nombre){
        Plato plato;
        for (int i=0;i<listaPlatos.size();i++) {
            plato=listaPlatos.get(i);
            if(plato.getNombre().equals(nombre)){
                listaPlatos.remove(i);
                return plato;
            }
        }
        return null;
    }

    public void QuemarDatos(){
        listaPlatos.add(new Plato("Pizza",12.5,100,30));
        listaPlatos.add(new Plato("Hamburguesa",12.5,110,40));
        listaPlatos.add(new Plato("Ensalada",12.5,232,10));
    }

}
