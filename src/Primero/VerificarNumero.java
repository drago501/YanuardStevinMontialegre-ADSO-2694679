/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Primero;

import java.util.Scanner;
import Primero.Abstract;


/**
 *
 * @author bonil
 */
class VerificarNumero extends Abstract {

    @Override
    public double leerNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero = scanner.nextDouble();

        if (esMayorQueCinco(numero)) {
            System.out.println("El número es mayor a 5.");
        } else {
            System.out.println("El número no es mayor a 5.");
        }

        return numero;
    }
    @Override
    public boolean esMayorQueCinco(double numero) {
        return numero > 5;
    }
//------------------------------------------------------------------------------
    @Override
    public double leer_Numero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero1 = scanner.nextDouble();
        double resultado = Math.pow(numero1, 2); 
        if (esMayora5000(numero1)) {
            System.out.println("si cumple "+resultado);
        }
        return numero1;
    }
    @Override
    public boolean esMayora5000(double numero2) {
        return numero2 > 5000;
    }
    
   //---------------------------------------------------------------------------
    
        @Override
    public double leer_Numero1() {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero2 = scanner.nextDouble();
        
        
        double absoluto = balorAdsoluto(numero2);
        System.out.println("El valor absoluto del número ingresado es: " + absoluto);

        return absoluto;
    }
    @Override
    public double balorAdsoluto(double numero2) {
       
        double absoluto = Math.abs(numero2);
        return absoluto;
       
    }
    //--------------------------------------------------------------------------
      
        @Override
    public double leer_Numero2() {
       Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero3 = scanner.nextDouble();
        
        if ( positivoNegativo(numero3)) {
            System.out.println("es positivo ");
        }else{
            System.out.println("es negativo");
        }
        
       
        return numero3;
    }
    @Override
    public boolean positivoNegativo(double numero3) {
        return numero3> 0;
    }
    //--------------------------------------------------------------------------
      @Override
    public double leer_Numero3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero4 = scanner.nextDouble();

        if (esMayorA200(numero4)) {
            System.out.println("El número "+ numero4 + "  es mayor a 200.");
        } else {
            System.out.println("El número "+numero4+" no es mayor a 200.");
        }

        return numero4;
    }
    @Override
    public boolean esMayorA200(double numero4) {
        return numero4 > 200;
    }
    //--------------------------------------------------------------------------
          @Override
    public double leer_Numero4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero5 = scanner.nextDouble();
        int menor = 50;
        int mayor =100;
        boolean isInRange = rango(numero5, menor, mayor);

        
        System.out.println("El número ingresado es: " + numero5);
        if (isInRange) {
            System.out.println("El número está dentro del rango.");
        } else {
            System.out.println("El número está fuera del rango.");
        }
        return 0;
        
    }
    @Override
    public boolean rango(double numero5, int menor,int mayor) {
        return numero5 >= menor && numero5 <= mayor;
    }

    //--------------------------------------------------------------------------
      @Override
    public double leer_Numero5() {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero6 = scanner.nextDouble();
        
        if ( paraImpar(numero6)) {
            System.out.println("es par ");
        }else{
            System.out.println("es impar");
        }
        return 0;
    }
    @Override
    public boolean paraImpar(double numero6) {
            if (numero6 % 2 == 0) {
        return true;
    } else {
        return false;
    }

    }
//------------------------------------------------------------------------------
    @Override
    public double leer_Numero6() {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero7 = scanner.nextDouble();
        
            if (paraImpar(numero7)) {
            System.out.println("Es par.");
        } else {
            System.out.println("Es impar.");
        }
        
        if (positivoNegativo(numero7)) {
            System.out.println("Es positivo.");
        } else {
            System.out.println("Es negativo.");
        }
        
        return 0;
    
    }
//------------------------------------------------------------------------------
    
         public double leer_Numero7() {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
         
        double numero8 = scanner.nextDouble();
        int menor = 200;
        int mayor =300;
         
        boolean isInRange = rango(numero8, menor, mayor);
        
        
          System.out.println("El número ingresado es: " + numero8);
        if (isInRange) {
            System.out.println("El número está dentro del rango.");
        } else {
            System.out.println("El número está fuera del rango.");
        }
        
         
        if ( paraImpar(numero8)) {
            System.out.println("es par ");
        }else{
            System.out.println("es impar");
        }
        return 0;
        
        
    
    }
    //--------------------------------------------------------------------------     
    @Override
    public double leer_Numero8() {
          Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número real: ");
        double numero9 = scanner.nextDouble();
        System.out.print("Ingrese otro número real: ");
        double numero10 = scanner.nextDouble();

        if ( menorAmayor(numero9, numero10)) {
            System.out.println("El número "+ numero9 + "  es mayor a "+numero10);
        } else {
            System.out.println("El número "+numero9+"  es menor a "+numero10);
        }
        return 0;
    }

    @Override
    public boolean menorAmayor(double numero9,double numero10) {
      if(numero9> numero10){
          return true;
      
      }else
          return  false;
    }
       
    }
    
    
    

  

    

