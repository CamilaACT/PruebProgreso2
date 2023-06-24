import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordenamiento {
//4 metodos, busqueda secuencial binaria, burbuja insercion estatico

    /**
     * Ordenamiento Burbuja para Ordenar por Precio
     * @param listaP
     */
    public static void OrdenamientoBurbujaPorPrecio(List<Plato> listaP) {
        int nElementos = listaP.size();
        for (int i = 0; i < nElementos - 1; i++) {
            for (int j = 0; j < nElementos - i - 1; j++) {
                if (listaP.get(j).getPrecio()> listaP.get(j+1).getPrecio()) { //Si númeroActual > númeroSiguiente
                    // Cambia la posición de los elementos de la lista
                    Plato aux = listaP.get(j);
                    listaP.set(j,listaP.get(j+1));
                    listaP.set(j+1,aux);
                }
            }
        }
    }

    /**
     * Ordenamiento Burbuja para ordenar por Nombre
     * @param listaP
     */
    public static void OrdenamientoBurbujaPorNombre(List<Plato> listaP) {
        int n = listaP.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listaP.get(j).getNombre().compareTo(listaP.get(j+1).getNombre())>=0) {
                    // Cambia la posición de los elementos de la lista
                    Plato temp = listaP.get(j);
                    listaP.set(j,listaP.get(j+1));
                    listaP.set(j+1,temp);
                }
            }
        }
    }

    /**
     * Ordenamiento Inserción para ordenar por Calorías
     * @param listP
     */
    public static void OrdenInsercionPorCalorias(List<Plato> listP) {

        int n = listP.size();
        for (int i = 1; i < n; i++) {
            Plato l =listP.get(i);
            double aux = listP.get(i).getCalorias();
            int j = i - 1;

            // Mover los elementos de la lista ordenada mayores al auxiliar
            while (j >= 0 && listP.get(j).getCalorias() > aux) {
                listP.set(j + 1, listP.get(j));
                j--;
            }

            // Insertar el auxiliar en su posición correcta dentro de la lista ordenada
            listP.set(j + 1, l);
        }
    }
    public static void OrdenInsercionPorTiempo(List<Plato> listP) {

        int n = listP.size();
        for (int i = 1; i < n; i++) {
            Plato l =listP.get(i);
            int key = listP.get(i).getTiempo();
            int j = i - 1;

            // Mover los elementos de la lista ordenada que son mayores que la clave
            while (j >= 0 && listP.get(j).getTiempo() > key) {
                listP.set(j + 1, listP.get(j));
                j--;
            }

            // Insertar la clave en su posición correcta dentro de la lista ordenada
            listP.set(j + 1, l);
        }
    }
    public List<Plato> busquedaBinariaNombre(String nombre, List<Plato> menu) {
        List<Plato> resultados = new ArrayList<>();

        int inicio = 0;
        int fin = menu.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Plato plato = menu.get(medio);

            int comparacion = nombre.compareTo(plato.getNombre());

            if (comparacion == 0) {
                resultados.add(plato);
            }
            if (comparacion < 0) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        return resultados;
    }

    public List<Plato> busquedaBinariaPrecio(double precio, List<Plato> menu) {
        List<Plato> resultados = new ArrayList<>();

        int inicio = 0;
        int fin = menu.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Plato plato = menu.get(medio);

            int comparacion = Double.compare(precio, plato.getPrecio());

            if (comparacion == 0) {
                // Si coinciden los minutos, se añade el objeto a la lista de resultados
                resultados.add(plato);
                // se verifica si hay platos que coinciden hacia la izquierda
                int i = medio - 1;
                while (i >= 0 && menu.get(i).getPrecio() == precio) {
                    resultados.add(menu.get(i));
                    i--;
                }
                // se verifica si hay platos que coinciden hacia la derecha
                i = medio + 1;
                while (i < menu.size() && menu.get(i).getPrecio() == precio) {
                    resultados.add(menu.get(i));
                    i++;
                }
                break;
            }
            if (comparacion < 0) {
                // Si los minutos buscados son menores, se busca en la mitad inferior
                fin = medio - 1;
            } else {
                // Si los minutos buscados son menores, se busca en la mitad superior
                inicio = medio + 1;
            }
        }

        return resultados;
    }

    public List<Plato> busquedaBinariaCalorias(int calorias, List<Plato> menu) {
        List<Plato> resultados = new ArrayList<>();

        int inicio = 0;
        int fin = menu.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Plato plato = menu.get(medio);

            int comparacion = Double.compare(calorias, plato.getCalorias());

            if (comparacion == 0) {
                // Si coinciden los minutos, se añade el objeto a la lista de resultados
                resultados.add(plato);
                // se verifica si hay platos que coinciden hacia la izquierda
                int i = medio - 1;
                while (i >= 0 && menu.get(i).getCalorias() == calorias) {
                    resultados.add(menu.get(i));
                    i--;
                }
                // se verifica si hay platos que coinciden hacia la derecha
                i = medio + 1;
                while (i < menu.size() && menu.get(i).getCalorias() == calorias) {
                    resultados.add(menu.get(i));
                    i++;
                }
                break;
            }
            if (comparacion < 0) {
                // Si los minutos buscados son menores, se busca en la mitad inferior
                fin = medio - 1;
            } else {
                // Si los minutos buscados son menores, se busca en la mitad superior
                inicio = medio + 1;
            }
        }

        return resultados;
    }
    public List<Plato> busquedaBinariaMinutos(int minutos, List<Plato> menu) {
        List<Plato> resultados = new ArrayList<>();

        int inicio = 0;
        int fin = menu.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Plato plato = menu.get(medio);

            int comparacion = Integer.compare(minutos, plato.getTiempo());

            if (comparacion == 0) {
                // Si coinciden los minutos, se añade el objeto a la lista de resultados
                resultados.add(plato);
                // se verifica si hay platos que coinciden hacia la izquierda
                int i = medio - 1;
                while (i >= 0 && menu.get(i).getTiempo() == minutos) {
                    resultados.add(menu.get(i));
                    i--;
                }
                // se verifica si hay platos que coinciden hacia la derecha
                i = medio + 1;
                while (i < menu.size() && menu.get(i).getTiempo() == minutos) {
                    resultados.add(menu.get(i));
                    i++;
                }
                break;
            }
            if (comparacion < 0) {
                // Si los minutos buscados son menores, se busca en la mitad inferior
                fin = medio - 1;
            } else {
                // Si los minutos buscados son menores, se busca en la mitad superior
                inicio = medio + 1;
            }
        }

        return resultados;
    }

}
