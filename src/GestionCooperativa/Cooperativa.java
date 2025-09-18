package GestionCooperativa;

import java.util.ArrayList;
import java.util.List;

import Modelo.Socio;
import Modelo.Cuentas.Cuenta;
import Modelo.Cuentas.CuentaAhorros;

public class Cooperativa {
    private static List<Socio> socios = new ArrayList<>() ;
    private  static  List<Cuenta> cuentas= new ArrayList<>();

    public static void registrar(Socio socio){
        boolean existe = socios.stream().anyMatch(s -> s.getCedula().equals(socio.getCedula()));
        if (existe) {
            System.out.println("Ya existe un socio con ese número de cédula");
        }else{
            socios.add(socio);
            System.out.println("Nuevo socio agregado exitosamente");
        }
    }
        public static void registrarCuenta(Cuenta cuenta){
             cuentas.add(cuenta);        
    }
    public static void getSocios(){
        socios.stream().map(s-> s.getNombre()).forEach(s-> System.out.println(s));
    }

    public static void filtrarCuentasConSaldoMayorAEspecifico(double monto){
     cuentas.stream().filter(c -> c.getSaldo()>monto).forEach(c -> System.out.println(c.getNumeroCuenta()));
}

    public static void sumaTotalDeSaldos() {
    double sumaTotal = cuentas.stream()
                              .map(Cuenta::getSaldo)
                              .reduce(0.0, (a, b) -> a + b);
     System.out.println("La suma total de los saldos en la cooperativa es: " + sumaTotal);
}

public static void agregarInteresCuentaAhorro(double nuevoInteres){
    cuentas.stream()
           .filter(c -> c instanceof CuentaAhorros)
           .map(c -> (CuentaAhorros) c)
           .forEach(c -> {
               c.setInteres(nuevoInteres);  // 📌 Actualiza el interés
               c.aplicarInteres();          // 📌 Aplica el cálculo con ese interés
               System.out.println("Cuenta " + c.getNumeroCuenta() + 
                                  " nuevo saldo: " + c.getSaldo());
           });
    System.out.println("Interés del " + (nuevoInteres*100) + "% aplicado a todas las cuentas de ahorro.");
}


    public static Socio buscarSocio(String cedula) {
        return socios.stream()
                     .filter(s -> s.getCedula().equals(cedula))
                     .findFirst()
                     .orElse(null);
    }

    public static Cuenta buscarCuenta(long numero) {
        return cuentas.stream()
                      .filter(c -> c.getNumeroCuenta() == numero)
                      .findFirst()
                      .orElse(null);
    }

}
