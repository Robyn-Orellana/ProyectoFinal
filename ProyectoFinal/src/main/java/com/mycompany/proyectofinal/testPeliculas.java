/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.proyectofinal;

import datos.Conexion;
import datos.PeliculaDAOJDBC;
import dominio.PeliculasDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author robyn
 */
public class testPeliculas {

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
            
            PeliculaDAOJDBC pelicula = new PeliculaDAOJDBC();
            List<PeliculasDTO> us = pelicula.Select();
            System.out.println("Usuarios" + us.toString());
            
            PeliculaDAOJDBC peli = new PeliculaDAOJDBC(conexion);
            PeliculasDTO peliculadto = new PeliculasDTO();
//            peliculadto.setNombre_p("Avengers");
//            peliculadto.setF_produccion(2012);
//            peliculadto.setCalificacion_p(10);
//            peli.Insert(peliculadto);
            
            PeliculasDTO peliculadtonew = new PeliculasDTO();
//            peliculadtonew.setNombre_p("Avengers");
//            peliculadtonew.setF_produccion(2012);
//            peliculadtonew.setCalificacion_p(7);
//            peliculadtonew.setID_pelicula(3);
//            peli.update(peliculadtonew);
//            peli.Delete(peliculadtonew);
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
