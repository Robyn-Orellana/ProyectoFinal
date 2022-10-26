/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.SeriesDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author robyn
 */
public interface SerieDAO {
    public List<SeriesDTO> Select() throws SQLException;
    public int Insert(SeriesDTO serie) throws SQLException;
    public int update(SeriesDTO serie) throws SQLException;
    public int Delete(SeriesDTO serie) throws SQLException;
}
