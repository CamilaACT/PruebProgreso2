package Validaciones;

public class Validacion {
    public  boolean validacionStringDouble(String string) {
        try {
            double number = Double.parseDouble(string);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public  boolean validacionStringInt(String string) {
        try {
            int number = Integer.parseInt(string);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean validacionStrings(String dato){
        boolean valido;
        valido = dato.matches("[A-Z][a-z]+")||dato.matches("[a-z]+"); //System.out.println("val2");
        //System.out.println(valido);
        //System.out.println("val2");
        //System.out.println(valido);

        return valido;
    }
    public boolean validarCedula(String cedula) {
        boolean banderaCedula = false;
        try {
            if (cedula.length() == 10) {
                if ((Integer.parseInt(cedula.substring(0, 2)) <= 24|| Integer.parseInt(cedula.substring(0, 2)) == 30)) {
                    int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int digVerificador = Integer.parseInt(cedula.substring(cedula.length() - 1, cedula.length()));
                    int suma = 0, digitoCoeficiente = 0, modulo = 0;
                    for (int i = 0; i < cedula.length() - 1; i++) {
                        digitoCoeficiente = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
                        digitoCoeficiente = (digitoCoeficiente > 9) ? digitoCoeficiente -= 9 : digitoCoeficiente;
                        suma += digitoCoeficiente;
                    }
                    modulo = suma % 10;
                    if ((10 - modulo) == digVerificador) {
                        banderaCedula = true;
                    }
                    if (modulo == 0 & modulo == digVerificador) {
                        banderaCedula = true;
                    }
                } else {
                    banderaCedula = false;
                    //JOptionPane.showMessageDialog(null, "La Cédula no es Ecuatoriana", "Validacion Cédula", 0);
                }
            }
        } catch (NumberFormatException e) {
            banderaCedula = false;
            //JOptionPane.showMessageDialog(null, "Error al intentar validar", "Validacion Cédula", 0);
        }
        return banderaCedula;
    }
}
