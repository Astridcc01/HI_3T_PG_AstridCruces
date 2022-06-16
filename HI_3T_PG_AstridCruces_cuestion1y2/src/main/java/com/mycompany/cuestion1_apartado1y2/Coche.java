/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuestion1_apartado1y2;

/**
 *
 * @author Campus FP
 */

//Esta clase va a heredar de Vehiculo.java mediante el extends.

//¿Java soporta herencia múltiple?: Java no permite la herencia múltiple, pero a cambio dispone de la 
//construcción denominada “Interface” que permite una forma de simulación o implementación limitada 
//de la herencia múltiple.

public class Coche extends Vehiculo{
    String marca;
    String modelo;

    public Coche(String marca, String modelo, int codigo, String matricula,int capacidad) {
        super(codigo, matricula, capacidad);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coche{marca=").append(marca);
        sb.append(", modelo=").append(modelo);
        sb.append('}');
        return sb.toString();
    }
    
    //sobreescritura:

    @Override
    public void aparcar() {
        //super.aparcar(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Coche aparcando");
    }

}
