/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interface.Accion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author srhad
 */
public class Continente implements Accion{
    private int id;
    private String codigo_postal;
    private String descripcion;
    public Conexion conn = new Conexion();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO continente ("
                + "codigo_postal, "
                + "descripcion, "
                + ") VALUES ("
                + "' " + this.getCodigo_postal()+ "', "
                + "' " + this.getDescripcion()+ "', "
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql;

        sql = "UPDATE continente SET "
                + "codigo_postal = '" + this.getCodigo_postal()+ "', "
                + "descripcion = '" + this.getDescripcion()+ "', "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        String sql;
        sql = "DELETE FROM continente\n"
                + "WHERE \n"
                + "descripcion= '" + this.getDescripcion()+ "';";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        ArrayList<Continente> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT * FROM continente";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Continente continente = new Continente();
                continente.setId(resultSet.getInt("id"));
                continente.setCodigo_postal(resultSet.getString("codigo_postal"));
                continente.setDescripcion(resultSet.getString("descripcion"));
                
                listaDeObjetos.add(continente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeObjetos;
    }

    @Override
    public String ConsultarWhereAnd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
