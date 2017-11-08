/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Base_Datos.Codigo_Base_Datos;
import Objetos.Persona;

/**
 *
 * @author Enrique
 */
public class CRUB_Base_Datos {

    public boolean Agregar_Persona(String cedula, String nombre, String edad, boolean genero) {

        Persona persona = new Persona(Integer.parseInt(cedula),nombre,Integer.parseInt(edad),genero);
        Codigo_Base_Datos cbd = new Codigo_Base_Datos();
        boolean se_agrego = cbd.Agregar_Enviar_Base_Datos(persona);
        return se_agrego;
    }

    public Persona Buscar_Persona_Ced(int cedula) {
        Codigo_Base_Datos cbd = new Codigo_Base_Datos();
        Persona persona = cbd.Buscar_Ced(String.valueOf(cedula));
        return persona;
    }
    public boolean Modificar(Persona persona,String nombre,int edad,boolean genero){
        Codigo_Base_Datos cbd = new Codigo_Base_Datos();
        persona.setNombre(nombre);
        persona.setEdad(edad);
        persona.setSexo(genero);
        boolean modificado = cbd.Modificar(persona);
        return modificado;
    }
}
