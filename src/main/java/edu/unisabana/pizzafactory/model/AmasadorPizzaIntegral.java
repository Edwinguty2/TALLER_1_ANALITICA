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
public class AmasadorPizzaIntegral implements Amasador{
    @Override
    public void amasar() {
        Logger.getLogger(AmasadorPizzaIntegral.class.getName())
                .log(Level.INFO, "[@@] Amasando la pizza integral con masa convencional.");
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
    }
    
}
