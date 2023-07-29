/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Primero;

import Primero.VerificarNumero;
import java.util.Scanner;

/**
 *
 * @author bonil
 */
public class Primero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in);
        int respuesta ;
        String salir = "";

        System.out.println("ingrese al ejercisio que desea operar");
        System.out.println("1 = Leer un real e imprimir si el número es mayor a 5.");
        System.out.println("2 = Leer un real e imprimir si su cuadrado es mayor a 5000");
        System.out.println("3 = Leer un real e imprimir su valor absoluto");
        System.out.println("4 = Leer un real e imprimir si el número es positivo o negativo");
        System.out.println("5 = Leer un real e imprimir si el número es mayor a 200 o no");
        System.out.println("6 = Leer un real e imprimir si el número está en el rango de 50 y 100");
        System.out.println("7 = Leer un real e imprimir si el número es par o impar");
        System.out.println("8 = Leer un entero e imprimir si el números par o impar y si es positivo o no");
        System.out.println("9 = Leer un entero e imprimir si el número está dentro del rango 200-300 y si es asi imprimir si es par o impar");
        System.out.println("10 = Leer dos números e imprimir cuál de los dos números es mayor y cual es menor ");
        System.out.println("11 = s para salir ");
        
        respuesta = tec.nextInt();
       
            tec.nextLine();
        do {
            switch (respuesta) {
                case 1:
                    VerificarNumero verificar = new VerificarNumero();
                    double numero = verificar.leerNumero();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();

                    break;

                case 2:
                    VerificarNumero verificar2 = new VerificarNumero();

                    double numero1 = verificar2.leer_Numero();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();

                    break;
                case 3:
                    VerificarNumero verificar3 = new VerificarNumero();

                    double numero2 = verificar3.leer_Numero1();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
                case 4:
                    VerificarNumero verificar4 = new VerificarNumero();
                    double numero3 = verificar4.leer_Numero2();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
                case 5:
                    VerificarNumero verificar5 = new VerificarNumero();
                    double numero4 = verificar5.leer_Numero3();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
                case 6:
                    VerificarNumero rango = new VerificarNumero();
                    VerificarNumero verificar6 = new VerificarNumero();
                    double numero5 = verificar6.leer_Numero4();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
                case 7:
                    VerificarNumero verificar7 = new VerificarNumero();
                    double numero6 = verificar7.leer_Numero5();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
                case 8:
                    VerificarNumero verificar8 = new VerificarNumero();
                    double numero7 = verificar8.leer_Numero6();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
                case  9:
                    VerificarNumero rango1 = new VerificarNumero();
                    VerificarNumero verificar9 = new VerificarNumero();
                    double numero8 = verificar9.leer_Numero7();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
                case  10:

                    VerificarNumero verificar10 = new VerificarNumero();
                    double numero9 = verificar10.leer_Numero8();
                    double numero10 = verificar10.leer_Numero8();
                    System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
                case 11:
                      System.out.println("¿Desea salir? (Ingrese 'salir' para salir, o presione Enter para continuar)");
                    salir = tec.nextLine();
                    break;
  

                default:
                    System.out.println("Opción no válida.");
                    System.out.println("vuelva a escoger una opcion");
                    System.out.println("-----------------------------------------");
            }
        } while (!salir.equalsIgnoreCase("salir"));
        
         System.out.println("¡Hasta luego!");
        tec.close();
    }
}
