/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.PeliculasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robyn
 */
public class PeliculaDAOJDBC implements PeliculaDAO{
    
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT ID, nombre_p, f_produccion, calificacion FROM peliculas";
    private static final String SQL_INSERT = "INSERT INTO peliculas(nombre_p, f_produccion, calificacion) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE peliculas SET nombre_p=?, f_produccion=?, calificacion=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM peliculas WHERE ID=?";

    public PeliculaDAOJDBC() {

    }

    public PeliculaDAOJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<PeliculasDTO> Select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PeliculasDTO pelicula = null;
        List<PeliculasDTO> peliculas = new ArrayList<PeliculasDTO>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("ID");
                String nombre = rs.getString("nombre_p");
                int fproduccion = rs.getInt("f_produccion");
                int calificacion = rs.getInt("calificacion");
                
                pelicula = new PeliculasDTO();
                pelicula.setID_pelicula(id_usuario);
                pelicula.setNombre_p(nombre);
                pelicula.setF_produccion(fproduccion);
                pelicula.setCalificacion_p(calificacion);
                
                peliculas.add(pelicula);
                
            }
        } catch(SQLException ex) {
            System.out.println("Hay un error en Select "+ex);
        }
        return peliculas; 
    }

    @Override
    public int Insert(PeliculasDTO pelicula) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getNombre_p());
            stmt.setInt(2, pelicula.getF_produccion());
            stmt.setInt(3, pelicula.getCalificacion_p());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            
        }catch(SQLException ex){
            System.out.println("Hay un error en Insert "+ex);
        }
        return rows;
    }

    @Override
    public int update(PeliculasDTO pelicula) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getNombre_p());
            stmt.setInt(2, pelicula.getF_produccion());
            stmt.setInt(3, pelicula.getCalificacion_p());
            stmt.setInt(4, pelicula.getID_pelicula());
            
            System.out.println("ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
            
        } catch(SQLException ex){
            System.out.println("Hay un erro en Update "+ex);
        }
        return rows;  
    }

    @Override
    public int Delete(PeliculasDTO pelicula) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pelicula.getID_pelicula());
            
            System.out.println("Ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch(SQLException ex){
            System.out.println("Hay un erro en Delete "+ex);
        }
        return rows;
    }
    
}
