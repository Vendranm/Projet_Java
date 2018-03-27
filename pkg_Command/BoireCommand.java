package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Item.Item;
/**
 * Implementation of the 'quit' user command.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */
public class BoireCommand extends Command
{
    private CommandWords commandWords;
    /**
     * Constructor for objects of class QuitCommand
     */
    public BoireCommand()
    {
    }

    /**
     * "Quit" was entered. Check the argument to see whether
     * we really quit the game. Return true, if we should quit, false
     * otherwise.
     */
    @Override
    public void execute(Player Joueur)
    {
        if(!hasSecondWord()) 
        {
            GameEngine.getGui().println("Boire quoi?");
            return;
        }

        String name = getSecondWord();
        Item item = Joueur.getInventaire().get(name);

        if (item == null)
        {
            GameEngine.getGui().println("Vous ne possedez pas " + name);
        }

        if (!item.isEdible())
        {
            GameEngine.getGui().println("Vous ne pouvez pas boire " + name);
        }
        
        else
        {
            if (name.equals("MagicBeer")) 
            {
                GameEngine.setLimite(GameEngine.getLimite() + 5*60);
                GameEngine.getGui().println("Vous avez gagné 5 minutes");
            }
                       
            Joueur.getInventaire().remove(name);
            GameEngine.getGui().println("Vous avez bu " + name);
        }
    }//boire()
}

