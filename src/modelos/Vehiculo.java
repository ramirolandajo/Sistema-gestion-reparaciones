package modelos;

import java.time.Year;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private Year anio;

    public Vehiculo(String matricula, String marca, String modelo, Year anio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    public boolean soyEseVehiculo(String matriculaChequear){
        return matriculaChequear.equals(matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                '}';
    }
}
