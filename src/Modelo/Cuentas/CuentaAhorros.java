package Modelo.Cuentas;

public class CuentaAhorros extends Cuenta {
    private double interes;

    public CuentaAhorros(Long numeroCuenta, double saldo, double interes) {
        super(numeroCuenta, saldo);
        this.interes = interes;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double saldoConInteres(){
        return getSaldo() + (getSaldo()*interes);
    }

     public void aplicarInteres() {
        double nuevoSaldo = getSaldo() + (getSaldo() * interes);
        setSaldo(nuevoSaldo);
    }
    
}
