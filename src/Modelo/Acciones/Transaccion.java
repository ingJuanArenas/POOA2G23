package Modelo.Acciones;

import Modelo.Cuentas.Cuenta;

public interface Transaccion {
    void ejecutar(Cuenta cuenta);
    double getMonto();
}
