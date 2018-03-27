package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Item.Item;
import pkg_Item.Beamer;
/**
 * Décrivez votre classe ChargerCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ChargerCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private CommandWords commandWords;

    /**
     * Constructeur d'objets de classe ChargerCommand
     */
    public ChargerCommand()
    {
        // initialisation des variables d'instance
    }

    @Override
    public void execute(Player Joueur)
    {
       String vC = getSecondWord();
       Item vBeamerI = Joueur.getInventaire().get(vC);
       Beamer vBeamer = new Beamer("Beamer", "Cet objet vous permettra de revenir à une pièce.", 3, true);
       if (! hasSecondWord()) 
       {
           GameEngine.getGui().println("Charger quoi ?");
           return;
       }
       
       if(! Joueur.getInventaire().hasItem("Beamer"))
       {
           GameEngine.getGui().println("Vous ne possedez pas de Beamer."); 
       }
       
       try 
       {
           vBeamer = (Beamer) vBeamerI;
       }
       catch (java.lang.ClassCastException pE) 
       {
           GameEngine.getGui().println(" Je ne peux pas charger ça...\n");
       }
       
       vBeamer.setSavedRoom(Joueur.getCurrentRoom());
       GameEngine.getGui().println("Le Beamer est chargé.");
       vBeamer.setCharged(true);
    }
}
