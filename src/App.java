import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GestionCooperativa.Cooperativa;
import Modelo.Socio;
import Modelo.Acciones.Deposito;
import Modelo.Acciones.Retiro;
import Modelo.Acciones.Transaccion;
import Modelo.Cuentas.Cuenta;
import Modelo.Cuentas.CuentaAhorros;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
      try {
          int opcion = 0;
        while (opcion != 9) {
        mostrarMenu();
        opcion= sc.nextInt();
          sc.nextLine();  
                switch (opcion) {
                case 1 :
                        // Registrar socio
                        System.out.print("Ingrese nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese cédula: ");
                        String cedula = sc.nextLine();
                        List<Cuenta> listadoCuentas= new ArrayList<>();
                        Cooperativa.registrar(new Socio(nombre, cedula, listadoCuentas));
                        break;
                case 2 :    // Abrir cuenta de ahorro a un socio
                        System.out.print("Ingrese cédula del socio: ");
                        String cedulaSocio = sc.nextLine();
                        Socio socioABuscar = Cooperativa.buscarSocio(cedulaSocio);

                        if (socioABuscar != null) {
                            System.out.print("Número de cuenta: ");
                            long numeroCuenta = sc.nextLong();
                            
                            if (Cooperativa.buscarCuenta(numeroCuenta) == null) {
                                System.out.print("Saldo inicial: ");
                            double saldo = sc.nextDouble();
                            System.out.print("Interés (ej. 0,05 = 5%): ");
                            double interes = sc.nextDouble();

                            CuentaAhorros cuenta = new CuentaAhorros(numeroCuenta, saldo, interes);
                                socioABuscar.abrirCuenta(cuenta);
                            }else {
                            System.out.println("Ese numero de cuenta ya se encuentra registrado");
                        }
                        
                            
                        } else {
                            System.out.println("Socio no encontrado.");
                        }
                    
                        break;
                case 3 :Cooperativa.getSocios();  break;
                case 4 :
                        // Depositar
                        System.out.print("Ingrese número de cuenta: ");
                        long numero = sc.nextLong();
                        Cuenta cuenta = Cooperativa.buscarCuenta(numero);
                        if (cuenta != null) {
                            System.out.print("Monto a depositar: ");
                        double monto = sc.nextDouble();
                            Transaccion deposito = new Deposito(monto);
                            deposito.ejecutar(cuenta);
                            System.out.println("Depósito realizado.");
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                         break;
                case 5 :
                        // Retirar
                        System.out.print("Ingrese número de cuenta: ");
                        long numeroCuenta= sc.nextLong();
                        Cuenta cuentaABuscar = Cooperativa.buscarCuenta(numeroCuenta);
                        if (cuentaABuscar != null) {
                            System.out.print("Monto a retirar: ");
                        double montoARetirar = sc.nextDouble();
                            Transaccion retiro = new Retiro(montoARetirar);
                            retiro.ejecutar(cuentaABuscar);
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                          break;
                case 6:
                        System.out.print("Ingrese el nuevo interés (ej: 0,05 para 5%): ");
                        double interes = sc.nextDouble();
                        Cooperativa.agregarInteresCuentaAhorro(interes);
                        break;
                case 7 :
                        System.out.println("Ingrese el monto a filtrar: ");
                        double montoAFiltrar = sc.nextDouble();
                        Cooperativa.filtrarCuentasConSaldoMayorAEspecifico(montoAFiltrar);
                        break;
                case 8: Cooperativa.sumaTotalDeSaldos();  break;
                case 9: System.out.println("Saliendo...");  break;
                default: System.out.println("Opción inválida."); break;
            }
       
        }
      } catch (Exception e) {
        System.out.println("Ha ocurrido un error: " + e);
      }

    }
    private static void mostrarMenu() {
        System.out.println("\n========= COOPERATIVA COOPRKC =========");
        System.out.println("1. Registrar socio");
        System.out.println("2. Abrir cuenta de ahorro a un socio");
        System.out.println("3. Listar nombres de todos los socios");
        System.out.println("4. Depositar en una cuenta");
        System.out.println("5. Retirar de una cuenta");
        System.out.println("6. Aplicar interés a cuentas de ahorro");
        System.out.println("7. Filtrar y mostrar cuentas por saldo");
        System.out.println("8. Calcular el total del dinero en la cooperativa");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

