package Funciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CuentaBancaria {

    private int clienteId;
    private TipoCuenta tipoCuenta;
    private double saldo;

    private List<Retiro> historialRetiros = new ArrayList<>();

    public CuentaBancaria(Cliente cliente) {
        clienteId = cliente.getClienteId();
        tipoCuenta = cliente.getTipoCuenta();
        saldo = cliente.getSaldoInicial();
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean realizarRetiro(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            registrarRetiro(monto);
            return true;
        }
        return false;
    }

    private void registrarRetiro(double monto) {
        Retiro retiro = new Retiro(monto, new Date());

        historialRetiros.add(retiro);
    }

    public int getClienteId() {
        return clienteId;
    }

    public List<Retiro> getHistorialRetiros() {
        return historialRetiros;
    }
}
