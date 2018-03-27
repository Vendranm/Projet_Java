package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Item.Item;
/**
 * Décrivez votre classe PrendreCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PrendreCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private CommandWords commandWords;

    /**
     * Constructeur d'objets de classe PrendreCommand
     */
    public PrendreCommand()
    {
        // initialisation des variables d'instance
    }

    @Override
    public void execute(Player Joueur)
    {
         if (! hasSecondWord()) 
        {
            GameEngine.getGui().println("\n Quel objet voulez-vous prendre ?\n"); 
        }

        String vCommand2 = getSecondWord();
        Item vItemRoom = Joueur.getCurrentRoom().getItemList().get(vCommand2);

        if (vItemRoom == null) 
        {
            GameEngine.getGui().println("\n Cet objet ne figure pas dans la pièce\n");
        }
        else 
        { 
            Joueur.putInventaire(vItemRoom);
            Joueur.getCurrentRoom().getItemList().remove(vCommand2);
            GameEngine.getGui().println("\n Vous avez ramassé " + vItemRoom.getName() + ".\n" );
        }
    }
}
