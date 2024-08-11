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
public class HorneadorPizzaGruesa implements Horneador{
    @Override
    public void hornear() {
        Logger.getLogger(AmasadorPizzaGruesa.class.getName())
            .log(Level.INFO, "[~~] Horneando la pizza gruesa con masa convencional.");

        //CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
    
}
