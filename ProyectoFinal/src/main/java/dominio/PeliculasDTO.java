/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author robyn
 */
public class PeliculasDTO {
    private int ID_pelicula;
    private String Nombre_p;
    private int F_produccion;
    private int calificacion_p;

    public PeliculasDTO(int ID_pelicula, String Nombre_p, int F_produccion, int calificacion_p) {
        this.ID_pelicula = ID_pelicula;
        this.Nombre_p = Nombre_p;
        this.F_produccion = F_produccion;
        this.calificacion_p = calificacion_p;
    }

    public PeliculasDTO() {
        
    }
    

    /**
     * @return the ID_pelicula
     */
    public int getID_pelicula() {
        return ID_pelicula;
    }

    /**
     * @param ID_pelicula the ID_pelicula to set
     */
    public void setID_pelicula(int ID_pelicula) {
        this.ID_pelicula = ID_pelicula;
    }

    /**
     * @return the Nombre_p
     */
    public String getNombre_p() {
        return Nombre_p;
    }

    /**
     * @param Nombre_p the Nombre_p to set
     */
    public void setNombre_p(String Nombre_p) {
        this.Nombre_p = Nombre_p;
    }

    /**
     * @return the F_produccion
     */
    public int getF_produccion() {
        return F_produccion;
    }

    /**
     * @param F_produccion the F_produccion to set
     */
    public void setF_produccion(int F_produccion) {
        this.F_produccion = F_produccion;
    }

    /**
     * @return the calificacion_p
     */
    public int getCalificacion_p() {
        return calificacion_p;
    }

    /**
     * @param calificacion_p the calificacion_p to set
     */
    public void setCalificacion_p(int calificacion_p) {
        this.calificacion_p = calificacion_p;
    }

    @Override
    public String toString() {
        return "PeliculasDTO{" + "ID_pelicula=" + ID_pelicula + ", Nombre_p=" + Nombre_p + ", F_produccion=" + F_produccion + ", calificacion_p=" + calificacion_p + '}';
    }
    
}
