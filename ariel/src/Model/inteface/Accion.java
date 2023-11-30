/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.inteface;

import Model.Entity.Producto;
import java.awt.List;

/**
 *
 * @author bonil
 */


public interface Accion {

    void Agregar();

    void Modificar();

    void Eliminar();
    
   
    
    void EliminarLogico();

    Object Consultar();

    Object ConsultarWhereAnd();

    
}

