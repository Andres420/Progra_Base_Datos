/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Enrique
 */
public class Persona {

    int cedula,edad;
    String nombre;
    boolean sexo;

    public Persona(int cedula, String nombre, int edad, boolean sexo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    
    public int getCedula(){
        return cedula;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public boolean getSexo(){
        return sexo;
    }
    public void setSexo(boolean sexo){
        this.sexo = sexo;
    }
    
}
