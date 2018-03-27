package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;

/**
 * Implementation of the 'quit' user command.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */
public class QuitterCommand extends Command
{
    private CommandWords commandWords;
    /**
     * Constructor for objects of class QuitCommand
     */
    public QuitterCommand()
    {
    }

    /**
     * "Quit" was entered. Check the argument to see whether
     * we really quit the game. Return true, if we should quit, false
     * otherwise.
     */
    @Override
    public void execute(final Player Joueur)
    {
        if(!hasSecondWord())
        {
            GameEngine.getGui().println("Quitter quoi?");
        }
        else
        {
            GameEngine.endGame();
        }
    }

}
