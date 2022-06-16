/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuestion1_apartado3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
/**
 *
 * @author Campus FP
 */
public class cuestion1_3 {
    public static void main(String[] args) {
        
        //Colecciones:
            //Lista (ArrayList):
                try{
                    ArrayList<String> listaAnimales = new ArrayList<>(4);
                    
                    listaAnimales.add("Hámster");
                    listaAnimales.add("Hurón");
                    listaAnimales.add("Conejo");
                    listaAnimales.add("Perro");
                    
                    for(String animales : listaAnimales){
                        System.out.println(animales);
                    }
                    
                }catch(Exception e){
                    System.out.println("Exepción "+e.getMessage());
                }


            //Pila (stack):
                try{
                    Stack juegosMesa = new Stack();
                    juegosMesa.push("Ajedrez");
                    juegosMesa.push("Parchís");
                    juegosMesa.push("Damas");
                    
                    System.out.println(juegosMesa.pop());
                    
                }catch(Exception e){
                    System.out.println("Exepción "+e.getMessage());
                }


            //Cola (queue):
                try{
                    Queue<String> listaAlimentos = new LinkedList<String>();
                    listaAlimentos.add("Arroz");
                    listaAlimentos.add("Chocolate");
                    listaAlimentos.add("Yogur");
                    
                    System.out.println(listaAlimentos.poll());
                    
                }catch(Exception e){
                    System.out.println("Exepción "+e.getMessage());
                }


            //Tabla (map):
                try{
                    Map<Integer, String> listaColores = new HashMap<Integer, String>();
                    listaColores.put(1, "Azul");
                    listaColores.put(2, "Rosa");
                    listaColores.put(3, "Morado");
                    System.out.println(listaColores);
                    
                }catch(Exception e){
                    System.out.println("Exepción "+e.getMessage());
                }
    }
}
