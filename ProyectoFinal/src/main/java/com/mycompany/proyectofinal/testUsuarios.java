/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectofinal;

import datos.Conexion;
import datos.UsuarioDAOJDBC;
import dominio.UsuarioDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author robyn
 */
public class testUsuarios {

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
            
            UsuarioDAOJDBC usuarioJdbc = new UsuarioDAOJDBC();
            List<UsuarioDTO> us = usuarioJdbc.Select();
            
            System.out.println("Usuarios" + us.toString());
            

//            UsuarioDAOJDBC usuarioJdbc = new UsuarioDAOJDBC(conexion);

            UsuarioDTO cambioUsuario = new UsuarioDTO();
            cambioUsuario.setID_usuario(3);
            cambioUsuario.setUser("mariadb");
            cambioUsuario.setPassword("123v");
            usuarioJdbc.update(cambioUsuario);
//
//            UsuarioDTO nuevoUsuario = new UsuarioDTO();
//            nuevoUsuario.setUser("mariadb");
//            nuevoUsuario.setPassword("MANOLO");
//            nuevoUsuario.setPassword("123");
//            usuarioJdbc.Insert(nuevoUsuario);

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
