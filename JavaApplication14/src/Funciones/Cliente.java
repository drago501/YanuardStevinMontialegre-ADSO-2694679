package Funciones;

import java.util.Random;

import Utils.FunctionNumeric;

public class Cliente {

    private int clienteId;
    private String nombre;
    private TipoCuenta tipoCuenta;
    private int cedula;
    private String banco;

    private double saldoInicial;

    public Cliente(int clienteId, String nombre, TipoCuenta tipoCuenta, String banco, double saldoInicial) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.tipoCuenta = tipoCuenta;
        this.banco = banco;
        this.saldoInicial = saldoInicial;
        this.cedula = clienteId; // Inicializar cedula
    }

    public int getClienteId() {
        return cedula;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

}
