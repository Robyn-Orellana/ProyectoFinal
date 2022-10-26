/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.SeriesDTO;
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
public class SeriesDAOJDBC implements SerieDAO{
    
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT ID, nombre_s, temporadas, calificacion_s FROM series";
    private static final String SQL_INSERT = "INSERT INTO series(nombre_s, temporadas, calificacion_s) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE series SET nombre_s=?, temporadas=?, calificacion_s=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM series WHERE ID=?";

    public SeriesDAOJDBC() {

    }

    public SeriesDAOJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<SeriesDTO> Select() throws SQLException {
      Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SeriesDTO serie = null;
        List<SeriesDTO> series = new ArrayList<SeriesDTO>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_serie = rs.getInt("ID");
                String nombre = rs.getString("nombre_s");
                int temporadas = rs.getInt("temporadas");
                int calificacion_s = rs.getInt("calificacion_s");
                
                serie = new SeriesDTO();
                serie.setID_series(id_serie);
                serie.setNombre_s(nombre);
                serie.setTemporadas(temporadas);
                serie.setCalificacion_s(calificacion_s);
                series.add(serie);
                
            }
        } catch(SQLException ex) {
            System.out.println("Hay un error en Select "+ex);
        }
        return series;   
    }

    @Override
    public int Insert(SeriesDTO serie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, serie.getNombre_s());
            stmt.setInt(2, serie.getTemporadas());
            stmt.setInt(3, serie.getCalificacion_s());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            
        }catch(SQLException ex){
            System.out.println("Hay un error en Insert "+ex);
        }
        return rows;  
    }

    @Override
    public int update(SeriesDTO serie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, serie.getNombre_s());
            stmt.setInt(2, serie.getTemporadas());
            stmt.setInt(3, serie.getCalificacion_s());
            stmt.setInt(4, serie.getID_series());
            
            System.out.println("ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
            
        } catch(SQLException ex){
            System.out.println("Hay un erro en Update "+ex);
        }
        return rows;  
    }

    @Override
    public int Delete(SeriesDTO serie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, serie.getID_series());
            
            System.out.println("Ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch(SQLException ex){
            System.out.println("Hay un erro en Delete "+ex);
        }
        return rows;
    }
    
}
