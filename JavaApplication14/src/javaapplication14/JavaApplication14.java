package javaapplication14;

import Funciones.CajeroAutomatico;
import Funciones.CuentaBancaria;
import Funciones.Retiro;
import Funciones.TipoCuenta;

import java.util.List;
import java.util.Scanner;
import Utils.FunctionString;
import Utils.FunctionNumeric;

public class JavaApplication14 {

    public static void main(String[] args) {
        FunctionString fc = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        CajeroAutomatico cajero = new CajeroAutomatico();

        while (true) {
            fc.ShowScanner("Bienvenido al Cajero Automático \n");
            fc.ShowScanner("1. Realizar Retiro \n");
            fc.ShowScanner("2. Registrar Cliente \n");
            fc.ShowScanner("4. Historial \n");
            fc.ShowScanner("5. salir \n");

            String opcionStr = fc.InputScanner("Seleccione una opción:");
            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {

                case 1:
                    int clienteIdRetiro = fn.InputIntegerNumericPositiveScanner("Ingrese el ID del cliente:");
                    double montoRetiro = fn.InputDoubleNumericPositiveScanner("Ingrese el monto a retirar:");
                    String nombreCuenta = fc.InputScanner("que tipo de cuenta es");

                    Double costoRetiroCredito = 10.0;
                    Double costoRetiroDebito = 5.0;

                    if (cajero.realizarRetiro(clienteIdRetiro, montoRetiro)) {
                        if (nombreCuenta.equalsIgnoreCase("CREDITO")) {
                            double montoFinal = montoRetiro - costoRetiroCredito;
                            System.out.println("Retiro exitoso = " + montoFinal + ". Has retirado " + montoRetiro
                                    + " con un costo de retiro de " + costoRetiroCredito +
                                    ". Nuevo saldo: " + cajero.getSaldo(clienteIdRetiro));
                        } else {
                            double montoFinal = montoRetiro - costoRetiroDebito;
                            System.out.println("Retiro exitoso =" + montoFinal + ". Has retirado " + montoRetiro
                                    + " con un costo de retiro de " + costoRetiroDebito +
                                    ". Nuevo saldo: " + cajero.getSaldo(clienteIdRetiro));
                        }

                    } else {
                        System.out.println(
                                "No se pudo realizar el retiro. Saldo insuficiente o ID de cliente no válido.");
                    }
                    break;

                case 2:
                    int clienteId = fn.InputIntegerNumericPositiveScanner("Ingrese el numero de indentificacion");
                    String nombre = fc.InputScanner("Ingrese el nombre del cliente:");
                    nombre = nombre.toUpperCase();
                    TipoCuenta tipoCuenta = TipoCuenta
                            .valueOf(fc.InputScanner("Seleccione el tipo de cuenta (CREDITO/DEBITO):").toUpperCase());
                    String banco = fc.InputScanner("Ingrese el nombre del banco:");
                    banco = banco.toUpperCase();
                    double saldoInicial = fn.InputDoubleNumericPositiveScanner("Ingrese el saldo inicial:");

                    cajero.registrarCliente(clienteId, nombre, tipoCuenta, banco, saldoInicial);
                    System.out.println("Cliente registrado exitosamente.");
                    break;

                case 4:
                    int clienteIdHistorial = fn.InputIntegerNumericPositiveScanner("Ingrese el ID del cliente:");
                    CuentaBancaria cuentaHistorial = cajero.buscarCuentaPorClienteId(clienteIdHistorial);
                    if (cuentaHistorial != null) {
                        List<Retiro> historialRetiros = cuentaHistorial.getHistorialRetiros();
                        System.out.println("Historial de retiros del cliente:");
                        for (Retiro retiro : historialRetiros) {
                            System.out.println("Fecha: " + retiro.getFecha() + ", Monto: " + retiro.getMonto());
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }

                    break;

                case 5:
                    System.out.println("Gracias por utilizar el Cajero Automático. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

}
