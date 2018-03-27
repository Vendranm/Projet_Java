package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Item.Item;

/**
 * Décrivez votre classe PoserCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PoserCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private CommandWords commandWords;

    /**
     * Constructeur d'objets de classe PoserCommand
     */
    public PoserCommand()
    {
    }

    @Override
    public void execute(Player Joueur)
    {
        if(! hasSecondWord())
        {
            GameEngine.getGui().println("Quel item voulez-vous poser ?");
        }

        String vCommand2 = getSecondWord();
        Item vItemInv = Joueur.getInventaire().get(vCommand2);

        if (vItemInv == null) 
        {
            GameEngine.getGui().println("L'objet voulu n'est pas en votre posséssion ");
        }
        else
        {
            Joueur.removeInventaire(vCommand2);
            Joueur.getCurrentRoom().getItemList().addItem(vCommand2, vItemInv);
            GameEngine.getGui().println("Vous avez posé l'objet " + vItemInv.getName());
        }
    }
}
