/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author robyn
 */
public interface UsuarioDAO {
    public List<UsuarioDTO> Select() throws SQLException;
    public int Insert(UsuarioDTO usuario) throws SQLException;
    public int update(UsuarioDTO usuario) throws SQLException;
    public int Delete(UsuarioDTO usuario) throws SQLException;
    
}
