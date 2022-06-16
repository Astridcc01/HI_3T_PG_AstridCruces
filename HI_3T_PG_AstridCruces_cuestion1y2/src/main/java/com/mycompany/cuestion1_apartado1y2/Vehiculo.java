/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuestion1_apartado1y2;

/**
 *
 * @author Campus FP
 */

//Esta es la clase de la cual Coche.java va a heredar

public class Vehiculo {
    //Zona de atributos, campos, variables de clase
    int codigo;
    String matricula;
    int capacidad;
    
    //constructor
    public Vehiculo(int codigo, String matricula, int capacidad) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.capacidad = capacidad;
    }
    
    //getter y setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo_barco(int codigo) {
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
    
    //resto de métodos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo{codigo=").append(codigo);
        sb.append(", matricula=").append(matricula);
        sb.append(", capacidad=").append(capacidad);
        sb.append('}');
        return sb.toString();
    }
    
    //sobrecarga:
    public void conducir(){
        System.out.println("Vehículo conduciendo");
    }
    
    public void conducir(int km){
        System.out.println("Vehículo conduciendo "+km+" km");
    }
    //sobreescritura:
    public void aparcar(){
        System.out.println("Vehículo aparcando");
    }
}