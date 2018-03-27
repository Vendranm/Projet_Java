package pkg_Command;
import pkg_Mechanics.GameEngine;
import pkg_Character.Player;
import pkg_Room.Room;

/**
 * Implementation of the 'go' user command.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */
public class AllerCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public AllerCommand()
    {
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    @Override
    public void execute(final Player Joueur)
    {

        if(!hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            GameEngine.getGui().println("Aller où?");
            return;
        }
        else
        {
            String direction = getSecondWord();

            // Try to leave current room.
            Room vPreviousRoom= Joueur.getCurrentRoom();
            Joueur.getBackRoom().push(vPreviousRoom);
            Room nextRoom = Joueur.getCurrentRoom().getExit(direction);
            //System.out.println(acurrentRoom);
            
            if (nextRoom == null)
                GameEngine.getGui().println("Il n'y a pas d'issue!");

            if (Joueur.getCurrentRoom().getShortDescription().equals("dans le bar le Beffroi") && !Joueur.getInventaire().hasItem("Clef") && direction.equals("Rue"))
            {
                GameEngine.getGui().println("La porte est bloqué vous ne pouvez sortir sans la clef.");
                return;
            }
            else 
            {
                Joueur.setCurrentRoom ( nextRoom);
                GameEngine.getGui().println(Joueur.getCurrentRoom().getLongDescription());
                if(Joueur.getCurrentRoom().getImageName() != null)
                    GameEngine.getGui().showImage(Joueur.getCurrentRoom().getImageName());
            }
        }
    }
}
