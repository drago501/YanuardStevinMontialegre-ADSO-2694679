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
public class Estado implements Accion {

    private int id;
    private String codigo_postal;
    private String descripcion;
    private int id_pais;
    private String Descripcion_pais;
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

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getDescripcion_pais() {
        return Descripcion_pais;
    }

    public void setDescripcion_pais(String Descripcion_pais) {
        this.Descripcion_pais = Descripcion_pais;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO estado ("
                + "codigo_postal, "
                + "descripcion, "
                + "pais_id, "
                + ") VALUES ("
                + "' " + this.getCodigo_postal() + "', "
                + "' " + this.getDescripcion() + "', "
                + "' " + this.getId_pais() + "', "
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql;

        sql = "UPDATE estado SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "pais_id = '" + this.getId_pais() + "', "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        String sql;
        sql = "DELETE FROM estado\n"
                + "WHERE \n"
                + "descripcion= '" + this.getDescripcion() + "';";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        ArrayList<Estado> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT estado.id, estado.codigo_postal, estado.descripcion, estado.pais_id, pais.descripcion AS pDescripcion \n"
                + "FROM estado \n"
                + "INNER JOIN pais ON estado.pais_id = pais.id \n"
                + "LIMIT 0, 25;";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Estado estado = new Estado();
                estado.setId(resultSet.getInt("id"));
                estado.setCodigo_postal(resultSet.getString("codigo_postal"));
                estado.setDescripcion(resultSet.getString("descripcion"));
                estado.setId_pais(resultSet.getInt("pais_id"));
                estado.setDescripcion_pais(resultSet.getString("pDescripcion"));

                listaDeObjetos.add(estado);
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
