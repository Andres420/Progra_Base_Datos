/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import Base_Datos.Codigo_Base_Datos;
import Objetos.Persona;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enrique
 */
public class Codigo_Buscador {

    Codigo_Base_Datos bcd = new Codigo_Base_Datos();

    public void Buscador_Cedula(JTable tabla, String cedula) {
        ArrayList<Persona> lista;
        if (!cedula.equals("")) {
            lista = bcd.Buscar_Personas(cedula);
        } else {
            lista = bcd.Buscar_Personas();
        }
        Agregar_Persona_Tabla(tabla, lista);
    }

    public void Buscador_Rango_Edad(JTable tabla, String edad_min, String edad_max) {
        ArrayList<Persona> lista;
        if (!edad_min.equals("") && !edad_max.equals("")) {
            lista = bcd.Buscar_edad(Integer.parseInt(edad_min), Integer.parseInt(edad_max));
        } else {
            lista = bcd.Buscar_Personas();
        }
        Agregar_Persona_Tabla(tabla, lista);
    }

    public void Buscador_Edad_Genero(JTable tabla, String edad, String genero) {
        ArrayList<Persona> lista;
        if (!edad.equals("")) {
            if (genero.equals("Masculino")) {
                lista = bcd.Buscar_genero_edad(false, Integer.parseInt(edad));
            } else {
                lista = bcd.Buscar_genero_edad(true, Integer.parseInt(edad));
            }

        } else {
            lista = bcd.Buscar_Personas();
        }
        Agregar_Persona_Tabla(tabla, lista);
    }

    public void Agregar_Persona_Tabla(JTable tabla, ArrayList<Persona> lista_personas) {
        Limpiar_Tabla(tabla);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (Persona persona : lista_personas) {
            if (persona.getSexo() == false) {
                model.addRow(new Object[]{persona.getCedula(), persona.getNombre(), persona.getEdad(), "Masculino"});
            } else {
                model.addRow(new Object[]{persona.getCedula(), persona.getNombre(), persona.getEdad(), "Femenino"});
            }
        }
    }

    private void Limpiar_Tabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
