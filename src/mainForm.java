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
                        if(menu.addPlato(new Plato(textIngresoNombre.getText(),Double.parseDouble(textIngresoPrecio.getText()),Double.parseDouble(textIngresoCalorias.getText()),Integer.parseInt(textIngresoPreparacion.getText())))){
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
                Plato plato=menu.busquedaPlato(textoModifNombre.getText());
                if(plato==null){
                    textoModifNombre.setText("No hay un plato con ese nombre");
                }else{
                    textoModifPrecio.setText(String.valueOf(plato.getPrecio()));
                    textoModifCalorias.setText(String.valueOf(plato.getValorCalorico()));
                    textoModifPreparacion.setText(String.valueOf(plato.getTiempopreparacio()));
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
                        Plato plato=menu.busquedaPlato(textoModifNombre.getText());
                        plato.setPrecio(Double.parseDouble(textoModifPrecio.getText()));
                        plato.setValorCalorico(Double.parseDouble(textoModifCalorias.getText()));
                        plato.setTiempopreparacio(Integer.parseInt(textoModifPreparacion.getText()));
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
                Plato plato=menu.busquedaPlato(textNombreEliminar.getText());
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
                Plato plato=menu.busquedaPlato(textNombreEliminar.getText());
                if(plato==null){
                    textAEliminar.setText("No hay un plato con ese nombre");
                }else{
                    menu.removePlatoPorNombre(textNombreEliminar.getText());
                    textAEliminar.setText("Plato eliminado");
                    ButtonBuscarEliminar.setEnabled(true);
                }

            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
