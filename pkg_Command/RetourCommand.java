package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;

/**
 * Décrivez votre classe RetourCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RetourCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private CommandWords commandWords;

    /**
     * Constructeur d'objets de classe RetourCommand
     */
    public RetourCommand()
    {
        // initialisation des variables d'instance
    }

    @Override
    public void execute(final Player Joueur)
    {
        if (Joueur.getBackRoom().empty())
        {
            GameEngine.getGui().println("Vous etes deja a la piece de depart!");
            return;
        }

        else 
        {
          if (Joueur.getCurrentRoom().getShortDescription().equals("dans le bar le Beffroi")) 
          {
              GameEngine.getGui().println("Vous êtes coincé. Il faut que vous trouviez la clef pour sortir.");
              return;
          }
          Joueur.backPlayer();
          GameEngine.getGui().println(Joueur.getCurrentRoom().getLongDescription());
          GameEngine.getGui().showImage(Joueur.getCurrentRoom().getImageName());
        }
    }
}
