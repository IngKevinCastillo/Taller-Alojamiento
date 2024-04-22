/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallersistemaalojamiento;

import java.util.*;

/**
 *
 * @author ESTUDIANTES
 */
public class RegistroAlojamientoImpMaps implements ICrudRegistroAlojamiento{
    private Map<Integer, Alojamiento> mapsAlojamiento;

    public RegistroAlojamientoImpMaps() {
        this.mapsAlojamiento = new HashMap();
    }
    
    @Override
    public boolean agregarAlojamiento(Alojamiento a) {
        this.mapsAlojamiento.put(a.getCodigo(), a);
        return true;
    }

    @Override
    public Alojamiento buscar(int codigo) {
        return this.mapsAlojamiento.get(codigo);
    }

    @Override
    public boolean eliminar(Alojamiento a) {
        this.mapsAlojamiento.remove(a.getCodigo(), a);
        return true;
    }

    @Override
    public void obtenerAlojamientos() {
        System.out.println("\nLista de alojamientos:");
        for (Alojamiento alojamiento : mapsAlojamiento.values()) {
            System.out.println(alojamiento);
        }
    }
}
