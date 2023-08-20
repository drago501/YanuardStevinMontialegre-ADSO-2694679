package Funciones;

import java.util.ArrayList;
import java.util.List;

public class CajeroAutomatico {
    public List<CuentaBancaria> cuentas;

    public CajeroAutomatico() {
        cuentas = new ArrayList<>();
    }

    public boolean realizarRetiro(int clienteId, double monto) {
        CuentaBancaria cuenta = buscarCuentaPorClienteId(clienteId);
        if (cuenta != null) {
            return cuenta.realizarRetiro(monto);
        }
        return false;
    }

    public void registrarCliente(int clienteId, String nombre, TipoCuenta tipoCuenta, String banco,
            double saldoInicial) {
        Cliente cliente = new Cliente(clienteId, nombre, tipoCuenta, banco, saldoInicial);
        CuentaBancaria cuenta = new CuentaBancaria(cliente);
        cuentas.add(cuenta);
    }

    public CuentaBancaria buscarCuentaPorClienteId(int clienteId) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getClienteId() == clienteId) {
                return cuenta;
            }
        }
        return null; // Si no se encuentra una cuenta con el clienteId dado
    }

    public double getSaldo(int clienteId) {
        CuentaBancaria cuenta = buscarCuentaPorClienteId(clienteId);
        if (cuenta != null) {
            return cuenta.getSaldo();
        }
        return -1; // Retorna un valor negativo si el cliente no existe
    }
}
