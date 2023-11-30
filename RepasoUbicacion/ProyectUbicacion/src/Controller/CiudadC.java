/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Ciudad;
import java.util.ArrayList;


/**
 * @author juan
 */
public class CiudadC {
     public void GuardarRegistro(String codigo_postal, String descripcion, int estado_id){
        Ciudad ciudad = new Ciudad();
        ciudad.setCodigo_postal(codigo_postal);
        ciudad.setDescripcion(descripcion);
        ciudad.setId_estado(estado_id);
        ciudad.Agregar();
     }
     public void EliminarRegistro(String descripcion){
        Ciudad ciudad = new Ciudad();
        ciudad.setDescripcion(descripcion);
        ciudad.EliminarFisico();
     }
     public void ModificarRegistro(int id, String codigo_postal, String descripcion, int estado_id){
        Ciudad ciudad = new Ciudad();
        ciudad.setId(id);
        ciudad.setCodigo_postal(codigo_postal);
        ciudad.setDescripcion(descripcion);
        ciudad.setId_estado(estado_id);
        ciudad.Modificar();
     }
     public ArrayList<Ciudad> ConsultarRegistro() {
        Ciudad ciudad = new Ciudad();
        ArrayList<Ciudad> ciudades= (ArrayList<Ciudad>) ciudad.Consultar();
        return ciudades;
    }
}
