/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.PeliculasDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author robyn
 */
public interface PeliculaDAO {
    public List<PeliculasDTO> Select() throws SQLException;
    public int Insert(PeliculasDTO pelicula) throws SQLException;
    public int update(PeliculasDTO pelicula) throws SQLException;
    public int Delete(PeliculasDTO pelicula) throws SQLException;
}
