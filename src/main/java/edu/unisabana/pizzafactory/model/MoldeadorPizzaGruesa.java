/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juand
 */
public class MoldeadorPizzaGruesa implements Moldeador{
    @Override
    public void moldearPizza(Tamano tamano) throws ExcepcionParametrosInvalidos {
        switch (tamano) {
            case PEQUENA:
                Logger.getLogger(MoldeadorPizzaGruesa.class.getName())
                        .log(Level.INFO, "[O] Moldeando pizza pequena de masa convencional.");
                
                //CODIGO DE LLAMADO AL MICROCONTROLADOR
                break;
            case MEDIANA:
                Logger.getLogger(MoldeadorPizzaGruesa.class.getName())
                        .log(Level.INFO, "[O] Moldeando pizza mediana de masa convencional.");
                //CODIGO DE LLAMADO AL MICROCONTROLADOR
                break;
            default:
                throw new ExcepcionParametrosInvalidos("Tamaño inválido: " + tamano);
                //CODIGO DE LLAMADO AL MICROCONTROLADOR
        }
    }
    
}
