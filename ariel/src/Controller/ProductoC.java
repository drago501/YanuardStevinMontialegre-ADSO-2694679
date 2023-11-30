/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Producto;
import java.util.ArrayList;
import javax.swing.JTextField;
/**
 *
 * @author bonil
 */

    



public class ProductoC {
    
   
    public void GuardarRegistro(String codigo, String nombre, Double precio, Long cantidad){
        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.Agregar();
    }
    
   
public void ModificarRegistro(String id, String codigo, String nombre, String precio, String cantidad) {
    Producto producto = new Producto();
    
    // Establece el ID del producto
    producto.setId(Long.parseLong(id)); // Convierte la cadena 'id' a Long

    // Establece el código y otros valores de producto
    producto.setCodigo(codigo);
    producto.setNombre(nombre);

    // Convierte precio y cantidad a Double
    double precioProducto = Double.parseDouble(precio);
    double cantidadProducto = Double.parseDouble(cantidad);
    producto.setCantidad((long) cantidadProducto);
    producto.setPrecio(precioProducto);

    // Llama al método de modificación en el controlador del producto
    producto.Modificar();
}






 
   public void EliminarRegistro(String codigoSeleccionado) {
    Producto producto = new Producto();
    producto.setCodigo(codigoSeleccionado); 
    producto.Eliminar();
}

    
    public void EliminarLogiv(String codigoSeleccionado) {
        Producto producto = new Producto();
    producto.setCodigo(codigoSeleccionado); 
    producto.EliminarLogico();
    }
    
 
    
   
    
        
        
    
     
public ArrayList<Producto> ConsultarRegistros(){
        ArrayList<Producto> listaDeObjetos = new ArrayList<>();
        Producto producto = new Producto();
        listaDeObjetos=(ArrayList<Producto>) producto.Consultar();
        return listaDeObjetos;
   }
public ArrayList<Producto> consultar(String codigo, Double precio, Long cantidad, String nombre) {
    ArrayList<Producto> consulta = new ArrayList<>();
    
    // Crea una instancia de Producto con los criterios de búsqueda
    Producto producto = new Producto();
    producto.setCodigo(codigo);
    producto.setNombre(nombre);
    producto.setPrecio(precio);
    producto.setCantidad(cantidad);

    // Realiza la consulta en el modelo
    consulta = (ArrayList<Producto>) producto.ConsultarWhereAnd();

    return consulta;
}



}

   
   

   



