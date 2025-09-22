package Modelo;

import java.util.ArrayList;
import java.util.List;

import GestionCooperativa.Cooperativa;
import Modelo.Cuentas.Cuenta;

public class Socio{
    private String nombre;
    private String cedula;
    private List<Cuenta> cuentas;

    public Socio(String nombre, String cedula, List<Cuenta> cuentas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void abrirCuenta(Cuenta cuentaNueva){
            cuentas.add(cuentaNueva);
            Cooperativa.registrarCuenta(cuentaNueva);
            System.out.println("Cuenta nueva agregada exitosamente");
        
    }

    

}