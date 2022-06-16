/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuestion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Campus FP
 */

//El código está creado para poder añadir más preguntas a archivo.txt

public class Cuestion2 {
        public static void main(String[] args) {
            
        //Declaración de variables:
        int posicion=0;
        int contador=0;
        int acierto=1 ;
        float fallo=0.25f;
        float puntos = 0f;
        String respuestaUsuario;
        String pregunta;
        String respuesta;
        
        //Estos arrays almacenan la información (contiene las preguntas y respuestas):
        ArrayList<String> archivo = new ArrayList<>(); 
        ArrayList<Integer> azar = new ArrayList<>();
        
        try {
            
            //Scanner para usar la información de archivo.txt:
            Scanner sc = new Scanner(Cuestion2.class.getResourceAsStream("archivo.txt"));
            //Scanner para leer la respuesta introducida por el usuario:
            Scanner rpc = new Scanner(System.in);
            
            //Guardamos los datos de archivo.txt en arrays:
            while (sc.hasNext()){
                //Guardamos las preguntas en un array:
                archivo.add(sc.nextLine());
                //Guardamos las respuestas en otro array:
                if(posicion%2 == 0)
                    azar.add(posicion);  
                
                posicion++;
            }

            //Usamos shuffle para hacer aleatorio el orden de las preguntas:
            Collections.shuffle(azar);
            
            //Usamos un iterator para facilitar la ejecución:
            Iterator <Integer> preguntasAzar = azar.iterator();
 
            //.hasNext para que continúe hasta que no queden preguntas.
            while(preguntasAzar.hasNext()){
                
                //A esta variable le asignamos el valor de las preguntas al azar:
                posicion=preguntasAzar.next();
                
                //En archivo.txt cada pregunta está seguida de su respuesta, por lo que respuesta=posicion_pregunta+1
                //Esto lo tenemos que plasmar en el código de alguna forma:
                pregunta = archivo.get(posicion);
                respuesta = archivo.get(posicion + 1);
                
                //Hace la pregunta:
                System.out.println(pregunta);
                //Lee la respuesta del usuario:
                respuestaUsuario = rpc.nextLine();
                
                
                
                if(respuestaUsuario.equalsIgnoreCase(respuesta)){
                    //Si acierta:
                    System.out.println("Acertaste +"+acierto+".");
                    //Sumamos los puntos:
                    puntos += acierto;
                    //Sumamos al contador:
                    contador++;
                }else{
                    //Si falla:
                    System.out.println("Fallaste -"+fallo+".");
                    //Enseñamos cuál es la respuesta correcta:
                    System.out.println("La respuesta correcta es "+respuesta+".");
                    //Restamos los puntos correspondientes:
                    puntos -= fallo;
                    //Sumamos al contador:
                    contador++;
                }
            }
            
            //Mostramos el resultado final:
            System.out.println("___________________________________________");
            System.out.println("Has sacado un: "+puntos);
            
            //Decimos si ha aprobado o no:
            if(puntos >= contador/2)
                System.out.println("Has aprobado");
            else
                System.out.println("Has suspendido");
            
        } catch (NullPointerException e1) {
            //Error por si no se encuentra el archivo:
            System.out.println("No se encuentra el archivo");
        }catch (Exception e2){
            //Error general:
            System.out.println(e2);
        }
        
    }
}