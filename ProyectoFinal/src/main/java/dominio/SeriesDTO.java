/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author robyn
 */
public class SeriesDTO {
    private int ID_series;
    private String Nombre_s;
    private int Temporadas;
    private int Calificacion_s;

    @Override
    public String toString() {
        return "SeriesDTO{" + "ID_series=" + ID_series + ", Nombre_s=" + Nombre_s + ", Temporadas=" + Temporadas + ", Calificacion_s=" + Calificacion_s + '}';
    }

    public SeriesDTO(int ID_series, String Nombre_s, int Temporadas, int Calificacion_s) {
        this.ID_series = ID_series;
        this.Nombre_s = Nombre_s;
        this.Temporadas = Temporadas;
        this.Calificacion_s = Calificacion_s;
    }
    public SeriesDTO() {
        
    }

    public int getID_series() {
        return ID_series;
    }

    public void setID_series(int ID_series) {
        this.ID_series = ID_series;
    }

    public String getNombre_s() {
        return Nombre_s;
    }

    public void setNombre_s(String Nombre_s) {
        this.Nombre_s = Nombre_s;
    }

    public int getTemporadas() {
        return Temporadas;
    }

    public void setTemporadas(int Temporadas) {
        this.Temporadas = Temporadas;
    }

    public int getCalificacion_s() {
        return Calificacion_s;
    }

    public void setCalificacion_s(int Calificacion_s) {
        this.Calificacion_s = Calificacion_s;
    }
    

//    public SeriesDTO(int ID_series, String Nombre_s, int Temporadas, int Califiacion_s) {
//        this.ID_series = ID_series;
//        this.Nombre_s = Nombre_s;
//        this.Temporadas = Temporadas;
//        this.Calificacion_s = Calificacion_s;
//    }
//
//    public SeriesDTO() {
//        
//    }
//
//    /**
//     * @return the ID_series
//     */
//    public int getID_series() {
//        return ID_series;
//    }
//
//    /**
//     * @param ID_series the ID_series to set
//     */
//    public void setID_series(int ID_series) {
//        this.ID_series = ID_series;
//    }
//
//    /**
//     * @return the Nombre_s
//     */
//    public String getNombre_s() {
//        return Nombre_s;
//    }
//
//    /**
//     * @param Nombre_s the Nombre_s to set
//     */
//    public void setNombre_s(String Nombre_s) {
//        this.Nombre_s = Nombre_s;
//    }
//
//    /**
//     * @return the Temporadas
//     */
//    public int getTemporadas() {
//        return Temporadas;
//    }
//
//    /**
//     * @param Temporadas the Temporadas to set
//     */
//    public void setTemporadas(int Temporadas) {
//        this.Temporadas = Temporadas;
//    }
//
//    /**
//     * @return the Califiacion_s
//     */
//    public int getCalificacion_s() {
//        return Calificacion_s;
//    }
//
//    /**
//     * @param Califiacion_s the Califiacion_s to set
//     */
//    public void setCalificacion_s(int Califiacion_s) {
//        this.Calificacion_s = Calificacion_s;
//    }
//
//    @Override
//    public String toString() {
//        return "SeriesDTO{" + "ID_series=" + ID_series + ", Nombre_s=" + Nombre_s + ", Temporadas=" + Temporadas + ", Califiacion_s=" + Calificacion_s + '}';
//    }

    
}
