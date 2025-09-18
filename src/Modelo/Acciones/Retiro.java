package Modelo.Acciones;

import Modelo.Cuentas.Cuenta;

public class Retiro  implements Transaccion{
    private double monto;

    
    public Retiro(double monto) {
        this.monto = monto;
    }

    @Override
    public void ejecutar(Cuenta cuenta) {
        cuenta.retirar(monto);
    }

    @Override
    public double getMonto() {
        return monto;
    }
    
}
