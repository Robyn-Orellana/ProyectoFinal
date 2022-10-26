/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.proyectofinal;

import datos.Conexion;
import datos.SeriesDAOJDBC;
import dominio.SeriesDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author robyn
 */
public class testSeries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("coneccion exitosa");
            }else{
                System.out.println("Conexion fallida");
            }
            
            SeriesDAOJDBC series = new SeriesDAOJDBC();
            List<SeriesDTO> us = series.Select();
            System.out.println("Usuarios" + us.toString());
            
            SeriesDAOJDBC serie = new SeriesDAOJDBC(conexion);
            SeriesDTO seriesdto = new SeriesDTO();
//            seriesdto.setNombre_s("Stranger Things");
//            seriesdto.setTemporadas(5);
//            seriesdto.setCalificacion_s(9);
//            serie.Insert(seriesdto);
            
            SeriesDTO seriedtonew = new SeriesDTO();
//            seriedtonew.setNombre_s("Stranger Things");
//            seriedtonew.setTemporadas(4);
//            seriedtonew.setCalificacion_s(8);
            seriedtonew.setID_series(3);
//            serie.update(seriedtonew);
            serie.Delete(seriedtonew);
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
}
