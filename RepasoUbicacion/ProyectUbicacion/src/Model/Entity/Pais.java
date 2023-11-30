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
public class Pais implements Accion {

    private int id;
    private String codigo_postal;
    private String descripcion;
    private int id_continente;
    private String descripcion_continente;
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

    public int getId_continente() {
        return id_continente;
    }

    public void setId_continente(int id_continente) {
        this.id_continente = id_continente;
    }

    public String getDescripcion_continente() {
        return descripcion_continente;
    }

    public void setDescripcion_continente(String descripcion_continente) {
        this.descripcion_continente = descripcion_continente;
    }

    @Override
    public void Agregar() {
        String sql;

        sql = "INSERT INTO pais ("
                + "codigo_postal, "
                + "descripcion, "
                + "contiente_id, "
                + ") VALUES ("
                + "' " + this.getCodigo_postal() + "', "
                + "' " + this.getDescripcion() + "', "
                + "' " + this.getId_continente() + "', "
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql;

        sql = "UPDATE pais SET "
                + "codigo_postal = '" + this.getCodigo_postal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "contiente_id = '" + this.getId_continente() + "', "
                + "WHERE id = " + this.getId() + ";";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void EliminarFisico() {
        String sql;
        sql = "DELETE FROM pais\n"
                + "WHERE \n"
                + "descripcion= '" + this.getDescripcion()+ "';";

        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        ArrayList<Pais> listaDeObjetos = new ArrayList<>();
        String sql = "SELECT pais.id, pais.codigo_postal, pais.descripcion, pais.contiente_id, continente.descripcion AS continenteDescripcion \n"
                + "FROM pais \n"
                + "INNER JOIN continente ON pais.contiente_id = continente.id \n"
                + "LIMIT 0, 25;";
        ResultSet resultSet = conn.consultarSQL(sql);

        try {
            while (resultSet.next()) {
                Pais pais = new Pais();
                pais.setId(resultSet.getInt("id"));
                pais.setCodigo_postal(resultSet.getString("codigo_postal"));
                pais.setDescripcion(resultSet.getString("descripcion"));
                pais.setId_continente(resultSet.getInt("contiente_id"));
                pais.setDescripcion_continente(resultSet.getString("continenteDescripcion"));

                listaDeObjetos.add(pais);
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
