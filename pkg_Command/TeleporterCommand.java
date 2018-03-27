package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Item.Item;
import pkg_Item.Beamer;
import pkg_Room.Room;
/**
 * Décrivez votre classe TeleporterCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TeleporterCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private CommandWords commandWords;

    /**
     * Constructeur d'objets de classe TeleporterCommand
     */
    public TeleporterCommand()
    {
        // initialisation des variables d'instance
    }

    @Override
    public void execute(Player Joueur)
    {
        String vCommand = getSecondWord();
        Item vBeamerI = Joueur.getInventaire().get(vCommand);
        Beamer vBeamer = new Beamer("Beamer", "Cet objet vous permettra de revenir à une pièce.", 3, true);
        
        if (vBeamerI == null)
        {
            GameEngine.getGui().println("Avec quoi voulez-vous vous teleportez ?");
        }
        if (vCommand.equals("Beamer")) GameEngine.getGui().println("Vous ne pouvez pas vous téléportez sans le beamer.");
        
        try 
        {
            vBeamer = (Beamer) vBeamerI;
        }
        catch (java.lang.ClassCastException pE)
        {
            GameEngine.getGui().println("Je ne peux pas charger ça.");
        }
        
        if (vBeamer.isCharged() == true)
        {
            Room vRoom = vBeamer.getSavedRoom();
            if (! vRoom.equals(Joueur.getCurrentRoom()))
            {
                GameEngine.getGui().println("...");
                Joueur.setCurrentRoom(vBeamer.getSavedRoom());
                vBeamer.setCharged(false);
                GameEngine.getGui().println(Joueur.getCurrentRoom().getLongDescription());
                GameEngine.getGui().showImage(Joueur.getCurrentRoom().getImageName());
            }
            else
            {
                GameEngine.getGui().println("Vous êtes déjà dans la pièce sauvegarder.");
            }
        }
        else
        {
            GameEngine.getGui().println("Le Beamer n'est pas chargé.");
        }
    }
}
