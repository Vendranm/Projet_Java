package pkg_Command;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import java.util.Scanner;
import java.io.File;
/**
 * Décrivez votre classe TestCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private CommandWords commandWords;

    /**
     * Constructeur d'objets de classe TestCommand
     */
    public TestCommand()
    {
        // initialisation des variables d'instance
    }

    @Override
    public void execute(Player Joueur)
    {
        if (!hasSecondWord())
        {
            GameEngine.getGui().println("\n Veuillez ajouter le nom du fichier test à la suite de la commande \n");
        }
        String vFichier = getSecondWord();
        try
        {
            Scanner vScan = new Scanner (new File("./" + vFichier + ".txt"));
            while (vScan.hasNextLine())
            {
                String vLigne = vScan .nextLine();
                GameEngine.interpretCommand(vLigne);
            }
        }
        catch (java.io.FileNotFoundException pException)
        {
            GameEngine.getGui().println("\n Fichier introuvable.\n");
        }
    }//test()
}

