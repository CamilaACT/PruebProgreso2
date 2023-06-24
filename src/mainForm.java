import Validaciones.Validacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;
    private Menu menu;
    private Validacion validar;

    public mainForm() {
        menu=new Menu();
        validar=new Validacion();

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //INGRESAR PLATO
                boolean [] validarTxt = new boolean[6];
                validarTxt[0]=textIngresoNombre.getText().isBlank();
                validarTxt[1]=validar.validacionStringDouble(textIngresoPrecio.getText());
                validarTxt[2]=validar.validacionStringDouble(textIngresoCalorias.getText());
                validarTxt[3]=validar.validacionStringInt(textIngresoPreparacion.getText());
                if(validarTxt[0]==false){
                    if(validarTxt[1]&&validarTxt[2]&&validarTxt[3]){
                        if(menu.ingresarPlato(new Plato(textIngresoNombre.getText(),Double.parseDouble(textIngresoPrecio.getText()),Double.parseDouble(textIngresoCalorias.getText()),Integer.parseInt(textIngresoPreparacion.getText())))){
                            textAIngresoPlatos.setText("Plato Ingresado Correctamente");
                        }else{
                            textAIngresoPlatos.setText("Ya existe un plato con ese nombre");
                        }

                    }else{
                        textAIngresoPlatos.setText("Ingrese correctamente los valores númericos");
                    }

                }else{
                    textAIngresoPlatos.setText("Es ibligatorio ingresar nombre");
                }


            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //QuemarDatos
                menu.QuemarDatos();
                textAIngresoPlatos.setText("Datos agregados a la Lista");
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato plato=menu.BuscarPorNombre(textoModifNombre.getText());
                if(plato==null){
                    textoModifNombre.setText("No hay un plato con ese nombre");
                }else{
                    textoModifPrecio.setText(String.valueOf(plato.getPrecio()));
                    textoModifCalorias.setText(String.valueOf(plato.getCalorias()));
                    textoModifPreparacion.setText(String.valueOf(plato.getTiempo()));
                    textoModifPrecio.setEnabled(true);
                    textoModifPrecio.setEditable(true);
                    textoModifCalorias.setEnabled(true);
                    textoModifCalorias.setEditable(true);
                    textoModifPreparacion.setEnabled(true);
                    textoModifPreparacion.setEditable(true);
                    modificarModifButton.setEnabled(true);
                    buscarModifButton.setEnabled(false);
                }
            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MODIFICAR PLATO

                boolean [] validarTxt = new boolean[6];
                validarTxt[0]=textoModifNombre.getText().isBlank();
                validarTxt[1]=validar.validacionStringDouble(textoModifPrecio.getText());
                validarTxt[2]=validar.validacionStringDouble(textoModifCalorias.getText());
                validarTxt[3]=validar.validacionStringInt(textoModifPreparacion.getText());
                if(validarTxt[0]==false){
                    if(validarTxt[1]&&validarTxt[2]&&validarTxt[3]){
                        Plato plato=menu.BuscarPorNombre(textoModifNombre.getText());
                        plato.setPrecio(Double.parseDouble(textoModifPrecio.getText()));
                        plato.setCalorias(Double.parseDouble(textoModifCalorias.getText()));
                        plato.setTiempo(Integer.parseInt(textoModifPreparacion.getText()));
                        textAModif.setText(plato.toString());
                        buscarModifButton.setEnabled(true);

                        textoModifPrecio.setText("");
                        textoModifCalorias.setText("");
                        textoModifPreparacion.setText("");
                        textoModifNombre.setText("");

                    }else{
                        textAIngresoPlatos.setText("Ingrese correctamente los valores númericos");
                    }

                }else{
                    textAIngresoPlatos.setText("Es ibligatorio ingresar nombre");
                }




            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato plato=menu.BuscarPorNombre(textNombreEliminar.getText());
                if(plato==null){
                    textAEliminar.setText("No hay un plato con ese nombre");
                }else{
                    textAEliminar.setText(plato.toString());
                    eliminarButton.setEnabled(true);
                    ButtonBuscarEliminar.setEnabled(false);
                }

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plato plato=menu.BuscarPorNombre(textNombreEliminar.getText());
                if(plato==null){
                    textAEliminar.setText("No hay un plato con ese nombre");
                }else{
                    menu.eliminarPlato(textNombreEliminar.getText());
                    textAEliminar.setText("Plato eliminado");
                    ButtonBuscarEliminar.setEnabled(true);
                }

            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBoxOrder.getSelectedIndex()){
                    case 0: //Cuando seleccione Nombre
                        menu.ordenarPorNombre();
                        textAMostrar.setText(menu.toString());
                        break;
                    case 1: //Cuando seleccione Precio
                        menu.ordenarPorPrecio();
                        textAMostrar.setText(menu.toString());
                        break;

                    case 2: //Cuando seleccione Calorías
                        menu.ordenarPorCalorias();
                        textAMostrar.setText(menu.toString());
                        break;
                    case 3: //Cuando seleccione Tiempo de Preparación
                        menu.ordenarPorTiempo();
                        textAMostrar.setText(menu.toString());
                        break;


                }


            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = comboBoxOrder.getSelectedItem().toString();
                //int opcion=comboBoxOrder.getSelectedIndex();
                switch (opcionSeleccionada) {
                    case "Nombre":
                            textAMostrar.setText(menu.buscarPlato(textBuscarPlatoOrden.getText(), opcionSeleccionada).toString());
                            if(textAMostrar.getText().equals("[]")){
                                textAMostrar.append("No se encontraron resultados de busqueda");
                            }
                            break;
                    case "Precio":
                        if(validar.validacionStringDouble(textBuscarPlatoOrden.getText())){
                            textAMostrar.setText(menu.buscarPlato(textBuscarPlatoOrden.getText(), opcionSeleccionada).toString());
                            if(textAMostrar.getText().equals("[]")){
                                textAMostrar.append("No se encontraron resultados de busqueda");
                            }
                        }
                        else{
                            textAMostrar.setText("Ingrese un precio válido");
                        }
                        break;
                    case "Calorias":
                        if(validar.validacionStringDouble(textBuscarPlatoOrden.getText())){
                            textAMostrar.setText(menu.buscarPlato(textBuscarPlatoOrden.getText(), opcionSeleccionada).toString());
                            if(textAMostrar.getText().equals("[]")){
                                textAMostrar.append("No se encontraron resultados de busqueda");
                            }
                        }
                        else{
                            textAMostrar.setText("Ingrese calorias válido");
                        }
                        break;
                    case "Tiempo":
                        if(validar.validacionStringInt(textBuscarPlatoOrden.getText())){
                            textAMostrar.setText(menu.buscarPlato(textBuscarPlatoOrden.getText(), opcionSeleccionada).toString());
                            if(textAMostrar.getText().equals("[]")){
                                textAMostrar.append("No se encontraron resultados de busqueda");
                            }
                        }
                        else{
                            textAMostrar.setText("Ingrese una cantidad entera de minutos");
                        }
                        break;
                }




            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
