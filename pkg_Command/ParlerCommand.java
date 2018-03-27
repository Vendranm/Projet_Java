package pkg_Command;
import pkg_Character.Player;
import pkg_Character.Characteres;
import pkg_Character.CharacteresList;
import pkg_Mechanics.GameEngine;
import pkg_Item.Item;
/**
 * Décrivez votre classe ParlerCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ParlerCommand extends Command
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    /**
     * Constructeur d'objets de classe ParlerCommand
     */
    public ParlerCommand()
    {
    }
    
    @Override
    public void execute(final Player Joueur)
    {
        if (! hasSecondWord()) 
        {
            GameEngine.getGui().println("A qui voulez-vous parlez ?"); 
            return;
        }
        
        String vCommand = getSecondWord();
        Characteres vCha = Joueur.getCurrentRoom().getChaList().get(vCommand);
        
        if (vCha == null) GameEngine.getGui().println("La personne n'est pas dans la pièce.");
        else
        {
            String vCommand2 = getSecondWord();
//             Item vChaItem = Joueur.getCurrentRoom().getChaItemList().get(vCommand2);
            GameEngine.getGui().println(vCha.getDialogue());
            GameEngine.getGui().println("Choix de discussion : \n");
            GameEngine.getGui().println("a-Vous etes tres jolie puis-je vous offrire un verre ?");
            GameEngine.getGui().println("b-Tu as de très beau yeaux...");
            GameEngine.getGui().println("c- Eh minette t'embarque dans mon carosse ?");
            GameEngine.getGui().println("d- Eh poulette, t'aurais 07 ?");
            GameEngine.getGui().println("Que voulez-vous dire ?"); 
        }
    }
}
