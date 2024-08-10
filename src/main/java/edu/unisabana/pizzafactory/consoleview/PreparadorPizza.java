
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
import edu.unisabana.pizzafactory.model.PizzaGruesa;
import edu.unisabana.pizzafactory.model.PizzaIntegral;
import edu.unisabana.pizzafactory.model.Tamano;
import static edu.unisabana.pizzafactory.model.Tamano.MEDIANA;
import static edu.unisabana.pizzafactory.model.Tamano.PEQUENA;
import edu.unisabana.pizzafactory.model.Tipo;
import java.util.Arrays;
import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        
        try {
            final int NUM_INGREDIENTES = 3;
            Ingrediente[] ingredientes = new Ingrediente[NUM_INGREDIENTES];
            
            for (int i = 0; i < NUM_INGREDIENTES; i++) {
                System.out.println("Ingrese el nombre del ingrediente #" + (i + 1) + ":");
                String nombre = scanner.nextLine().trim();

                System.out.println("Ingrese la cantidad del ingrediente #" + (i + 1) + ":");
                int cantidad;
                while (true) {
                    try {
                        cantidad = Integer.parseInt(scanner.nextLine().trim());
                        if (cantidad > 0) {
                            break;
                        } else {
                            System.out.println("La cantidad debe ser positiva. Inténtelo nuevamente:");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Cantidad inválida. Ingrese un número entero:");
                    }
                }
                ingredientes[i] = new Ingrediente(nombre, cantidad);

            }
            
                
            // tipo de pizza
            System.out.println("Seleccione el tipo de pizza (DELGADA, GRUESA, INTEGRAL):");
            String tipoInput = scanner.nextLine().toUpperCase();
            Tipo tipo = Tipo.valueOf(tipoInput);

            //  tamaño de pizza
            System.out.println("Seleccione el tamaño de pizza (PEQUENA, MEDIANA):");
            String tamanoInput = scanner.nextLine().toUpperCase();
            Tamano tamano = Tamano.valueOf(tamanoInput);      
            
           
            PizzaFactory fabrica;
            switch (tipo) {
                case DELGADA:
                    fabrica = new PizzaDelgada();
                    break;
                case GRUESA:
                    fabrica = new PizzaGruesa();
                    break;
                case INTEGRAL:
                    fabrica = new PizzaIntegral();
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de pizza no válido");
            }
            
          
           // Preparar la pizza
            PreparadorPizza preparador = new PreparadorPizza(fabrica);
            preparador.prepararPizza(ingredientes, tamano);
            
        }catch (IllegalArgumentException e) {
            System.out.println("Error: Entrada no válida. " + e.getMessage());
        } catch (ExcepcionParametrosInvalidos e) {
            System.out.println("Error en la preparación de la pizza: " + e.getMessage());
        } finally {
            scanner.close();
        }
            
        
    }
    



}
