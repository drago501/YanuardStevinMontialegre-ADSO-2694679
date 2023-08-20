package Funciones;

import java.util.Date;

public class Retiro {

    private double monto;
    private Date fecha;

    public Retiro(double monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }
}
