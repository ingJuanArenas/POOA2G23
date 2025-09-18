package Modelo.Cuentas;
public class Cuenta {
    private Long numeroCuenta;
    private Double saldo;

    public Cuenta(Long numeroCuenta, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

public void depositar(double monto) {
    if (monto <= 0) {
        System.out.println("El monto a depositar debe ser positivo");
    }else{
        saldo += monto;
        System.out.println("El nuevo saldo es: " + saldo);

    }
    
}

   public void retirar(double monto) {
    if (monto > saldo) {
        System.out.println("Saldo insuficiente. Su saldo es: " + saldo);
    } else {
        saldo -= monto;
        System.out.println("El nuevo saldo es: " + saldo);
    }
}

    
    
}
