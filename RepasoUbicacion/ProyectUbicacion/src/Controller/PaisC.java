/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Pais;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class PaisC {
         public void GuardarRegistro(String codigo_postal, String descripcion, int continente_id){
        Pais pais = new Pais();
        pais.setCodigo_postal(codigo_postal);
        pais.setDescripcion(descripcion);
        pais.setId_continente(continente_id);
        pais.Agregar();
     }
     public void EliminarRegistro(String descripcion){
        Pais pais = new Pais();
        pais.setDescripcion(descripcion);
        pais.EliminarFisico();
     }
     public void ModificarRegistro(int id, String codigo_postal, String descripcion, int continente_id){
        Pais pais = new Pais();
        pais.setId(id);
        pais.setCodigo_postal(codigo_postal);
        pais.setDescripcion(descripcion);
        pais.setId_continente(continente_id);
        pais.Modificar();
     }
    public ArrayList<Pais> ConsultarRegistro() {
        Pais pais = new Pais();
        ArrayList<Pais> paises= (ArrayList<Pais>) pais.Consultar();
        return paises;
    }
}
