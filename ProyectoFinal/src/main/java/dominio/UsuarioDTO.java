/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author robyn
 */
public class UsuarioDTO {
    private int ID_usuario;
    private String User;
    private String Password;

    public UsuarioDTO(int ID_usuario, String User, String Password) {
        this.ID_usuario = ID_usuario;
        this.User = User;
        this.Password = Password;
    }

    public UsuarioDTO() {
        
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "ID_usuario=" + ID_usuario + ", User=" + User + ", Password=" + Password + '}';
    }

    /**
     * @return the ID_usuario
     */
    public int getID_usuario() {
        return ID_usuario;
    }

    /**
     * @param ID_usuario the ID_usuario to set
     */
    public void setID_usuario(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    /**
     * @return the User
     */
    public String getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(String User) {
        this.User = User;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
