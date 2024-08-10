
package edu.unisabana.pizzafactory.consoleview;

import edu.unisabana.pizzafactory.model.Amasador;
import edu.unisabana.pizzafactory.model.AmasadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.Horneador;
import edu.unisabana.pizzafactory.model.HorneadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.Ingrediente;
import edu.unisabana.pizzafactory.model.Moldeador;
import edu.unisabana.pizzafactory.model.MoldeadorPizzaDelgada;
import edu.unisabana.pizzafactory.model.PizzaDelgada;
import edu.unisabana.pizzafactory.model.PizzaFactory;
import edu.unisabana.pizzafactory.model.Tamano;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */
public class PreparadorPizza {
    
    private PizzaFactory factory;
    
    public PreparadorPizza(PizzaFactory factory) {
        this.factory = factory;
    }
    
     public void prepararPizza(Ingrediente[] ingredientes, Tamano tam) throws ExcepcionParametrosInvalidos {
        Amasador am = factory.crearAmasador();
        Moldeador mol = factory.crearMoldeador();
        Horneador hor = factory.crearHorneador();
        
        am.amasar();
        mol.moldearPizza(tam);
        aplicarIngredientes(ingredientes);
        hor.hornear();
    }
     
    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));
    }


    public static void main(String args[]) {
        try {
            Ingrediente[] ingredientes = new Ingrediente[]{new Ingrediente("queso", 1), new Ingrediente("jamon", 2)};
            PizzaFactory factory = new PizzaDelgada(); 
            PreparadorPizza pp = new PreparadorPizza(factory);
            pp.prepararPizza(ingredientes, Tamano.MEDIANO);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparación de la pizza", ex);
        }
    }
    



}
