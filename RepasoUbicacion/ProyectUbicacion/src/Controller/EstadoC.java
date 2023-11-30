/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Estado;
import java.util.ArrayList;


/**
 *
 * @author juan
 */
public class EstadoC {
     public void GuardarRegistro(String codigo_postal, String descripcion, int pais_id){
        Estado estado = new Estado();
        estado.setCodigo_postal(codigo_postal);
        estado.setDescripcion(descripcion);
        estado.setId_pais(pais_id);
        estado.Agregar();
     }
     public void EliminarRegistro(String descripcion){
        Estado estado = new Estado();
        estado.setDescripcion(descripcion);
        estado.EliminarFisico();
     }
     public void ModificarRegistro(int id, String codigo_postal, String descripcion, int pais_id){
        Estado estado = new Estado();
        estado.setId(id);
        estado.setCodigo_postal(codigo_postal);
        estado.setDescripcion(descripcion);
        estado.setId_pais(pais_id);
        estado.Modificar();
     }
    public ArrayList<Estado> ConsultarRegistro() {
        Estado estado = new Estado();
        ArrayList<Estado> estados= (ArrayList<Estado>) estado.Consultar();
        return estados; 
    }
}
