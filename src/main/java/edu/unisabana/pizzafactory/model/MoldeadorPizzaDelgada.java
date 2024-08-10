
package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */
public class MoldeadorPizzaDelgada implements Moldeador{
    
    @Override
    public void moldearPizza(Tamano tamano) throws ExcepcionParametrosInvalidos {
        switch (tamano) {
            case PEQUENO:
                Logger.getLogger(MoldeadorPizzaDelgada.class.getName())
                        .log(Level.INFO, "[O] Moldeando pizza pequena de masa convencional.");
                
                //CODIGO DE LLAMADO AL MICROCONTROLADOR
                break;
            case MEDIANO:
                Logger.getLogger(MoldeadorPizzaDelgada.class.getName())
                        .log(Level.INFO, "[O] Moldeando pizza mediana de masa convencional.");
                //CODIGO DE LLAMADO AL MICROCONTROLADOR
                break;
            default:
                throw new ExcepcionParametrosInvalidos("Tamaño inválido: " + tamano);
                //CODIGO DE LLAMADO AL MICROCONTROLADOR
        }
    }

}
