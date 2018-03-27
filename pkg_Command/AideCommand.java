package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
/**
 * Implementation of the 'help' user command.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */
public class AideCommand extends Command
{
    private CommandWords commandWords;
    
    /**
     * Constructor for objects of class HelpCommand
     */
    public AideCommand()
    {
    }
    
    /**
     * Print out some help information. Here we print some stupid, 
     * cryptic message and a list of the command words.
     * Returns always false.
     */
    @Override
    public void execute(Player Joueur)
    {
       GameEngine.getGui().println("Tu t'es perdu ? ");
       GameEngine.getGui().println("Les commandes possibles sont: " + GameEngine.getParser().showCommands());
    }
}
