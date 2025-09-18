package Modelo.Acciones;

import Modelo.Cuentas.Cuenta;

public class Deposito implements Transaccion {
    private double monto;

    
    public Deposito(double monto) {
        this.monto = monto;
    }


    @Override
    public void ejecutar(Cuenta cuenta) {
      cuenta.depositar(monto);
    }

    @Override
    public double getMonto() {
        return monto;
    }
    
}
