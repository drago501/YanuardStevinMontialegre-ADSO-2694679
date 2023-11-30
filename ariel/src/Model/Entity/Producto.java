/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;
import Conexion.Conexion;
import Model.inteface.Accion;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 *
 * @author bonil
 */

public class Producto implements Accion{

    private Long id;
    private String codigo;

   
    private String nombre;
    private Double precio;
    private Long cantidad;
    private Date created_at; 
    public Conexion conn = new Conexion(); 

    public Producto() {
    }   
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
     public Date getCreated_at() {
        return created_at;
    }
      public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public void Agregar() {
        String sql; 
        
        sql = "INSERT INTO producto ("
            +   "codigo, "
            +   "nombre, "
            +   "precio, "
            +   "cantidad, "
            +   "created_at"
            + ") VALUES ("
            +   "' "+this.getCodigo()+"', "
            +   "' "+this.getNombre()+"', "
            +   this.getPrecio()+", "
            +   this.getCantidad()+", "
            +   " NOW()"
            + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();

    }

    @Override
 public void Modificar() {
    String sql = "UPDATE producto SET " +
        "codigo = '" + this.getCodigo() + "', " +
        "nombre = '" + this.getNombre() + "', " +
        "precio = " + this.getPrecio() + ", " +
        "cantidad = " + this.getCantidad() + ", " +
        "created_at = NOW() " +
        "WHERE id = " + this.getId(); // Sin comillas alrededor del ID
    
        System.out.println(""+getId());
        System.out.println(""+getNombre());
        System.out.println(""+getCantidad());
   
    conn.ejecutarSQL(sql);
    conn.cerrarConexion();




    }

    @Override
    public void Eliminar() {
        String sql = "DELETE FROM producto WHERE codigo = '" + this.getCodigo() + "';";

System.out.println("Model.Entity.Producto.Eliminar() " + getCodigo());
conn.ejecutarSQL(sql);
conn.cerrarConexion();
    

    }





    
@Override
    public Object ConsultarWhereAnd() {
    ArrayList<Producto> consulta = new ArrayList<>();
   // String sql = "SELECT id, codigo, nombre, precio, cantidad, created_at FROM producto WHERE 1=1"; // WHERE 1=1 es verdadero siempre
String sql = "SELECT id, codigo, nombre, precio, cantidad, created_at FROM producto WHERE ";

if (this.getNombre() != null) {
    sql += "nombre = '" + this.getNombre() + "' OR ";
}

if (this.getCodigo() != null) {
    sql += "codigo = '" + this.getCodigo() + "' OR ";
}

if (this.getPrecio() != null) {
    sql += "precio = " + this.getPrecio() + " OR ";
}

if (this.getCantidad() != null) {
    sql += "cantidad = " + this.getCantidad() + " OR ";
}

// Elimina el último " OR " si está presente
if (sql.endsWith(" OR ")) {
    sql = sql.substring(0, sql.length() - 4);
}


    ResultSet resultSet = conn.RjecutarSQL(sql);

    try {
        while (resultSet.next()) {
            Producto producto = new Producto();
            producto.setId(resultSet.getLong("id"));
            producto.setCodigo(resultSet.getString("codigo"));
            producto.setNombre(resultSet.getString("nombre"));
            producto.setPrecio(resultSet.getDouble("precio"));
            producto.setCantidad(resultSet.getLong("cantidad"));
            producto.setCreated_at(resultSet.getDate("created_at"));
            consulta.add(producto);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return consulta;
}


    @Override
public Object Consultar() {
    
    ArrayList<Producto> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        ResultSet resultSet = conn.RjecutarSQL(sql);

        try {
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setId(resultSet.getLong("id"));
                producto.setCodigo(resultSet.getString("codigo"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCantidad(resultSet.getLong("cantidad"));
                producto.setCreated_at(resultSet.getDate("created_at"));
                
                listaDeObjetos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeObjetos;
         
        


    }

    
    

   @Override
    public void EliminarLogico() {
        String sql; 
        
       // sql = " UPDATE producto SET deleted_at = NOW(),state  WHERE codigo = '" + this.getCodigo() + "';";
        sql = "UPDATE producto SET deleted_at = NOW(), state = 0 WHERE codigo = '" + this.getCodigo() + "';";
        System.out.print(""+getCodigo());
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }




        
        
    }

  


    

