/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Entity.ConversionGrados.ConversionGrados;
import Entity.pesos.convercionPesos;


/**
 *
 * @author ariel
 */



public class Mostrar {
    public static void main(String[] args) {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();

        // Input student data
        String nivel = fs.InputScanner("Ingrese el nivel del estudiante (preparatoria o profesional): ");
        double promedio = fn.InputDoubleNumericScanner("Ingrese el promedio del estudiante: ");
        int materiasReprobadas = fn.InputIntegerNumericScanner("Ingrese el número de materias reprobadas: ");

        // Create a student object
        estudiante es = new estudiante(nivel, promedio, materiasReprobadas);

        // Calculate and display the tuition fee for the student
        double colegiatura = estudiante.calcularColegiatura(es);
        estudiante.displayStudentInfo(es, colegiatura);
    }
}

