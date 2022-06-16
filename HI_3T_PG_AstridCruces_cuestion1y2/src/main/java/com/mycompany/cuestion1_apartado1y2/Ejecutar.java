/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuestion1_apartado1y2;

/**
 *
 * @author Campus FP
 */

import com.mycompany.cuestion1_apartado1y2.Coche;
import com.mycompany.cuestion1_apartado1y2.Vehiculo;


//Aquí probraremos los métodos de Coche y Vehículo
public class Ejecutar {
    public static void main(String[] args) {
        //instancio un coche y un vehiculo
        Vehiculo vehiculo1=new Vehiculo(1,"111222-A",4);
        Coche coche1=new Coche("Seat","Ibiza",1,"111222-A",4);
        System.out.println("Ejemplo de sobrecarga:");
        vehiculo1.conducir();
        vehiculo1.conducir(30);
        System.out.println("Ejemplo de sobreescritura:");
        vehiculo1.aparcar();
        coche1.aparcar();
    }
}
