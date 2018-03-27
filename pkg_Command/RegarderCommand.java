package pkg_Command;
import pkg_Character.*;
import pkg_Mechanics.GameEngine;

/**
 * Décrivez votre classe RegarderCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RegarderCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private CommandWords commandWords;

    /**
     * Constructeur d'objets de classe RegarderCommand
     */
    public RegarderCommand()
    {
        // initialisation des variables d'instance
    }

    @Override
    public void execute(Player Joueur)
    {
        GameEngine.getGui().println(Joueur.getCurrentRoom().getLongDescription());
        if (! Joueur.getInventaire().isEmpty())
        {
            GameEngine.getGui().println("Inventaire" + Joueur.getInventaire().getItemsString());
        }
    }
}
