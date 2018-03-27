package pkg_Command;
import pkg_Character.Characteres;
import pkg_Character.CharacteresList;
import pkg_Character.Player;
import pkg_Mechanics.GameEngine;
import pkg_Item.Item;
/**
 * Décrivez votre classe ChoixCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ChoixCommand extends Command
{
    public ChoixCommand()
    {
    }

    @Override
    public void execute(final Player Joueur)
    {
        if(!hasSecondWord())
        {
            GameEngine.getGui().println("Quel est votre choix ?");
            return;
        }
        String vChoix = " ";
        String vC = getSecondWord();
        Characteres vCha = Joueur.getCurrentRoom().getChaList().get(vC);
        String vC2 = getSecondWord();
        Item vChaItem = Characteres.getCurrentRoom().getChaItem();
        if (vC.equals("a")) 
        {
            if (vChaItem == null )
            {
                GameEngine.getGui().println("Tu es mignon mais je n'ai pas de numéro.");
                return;
            }
            else
            {
                vCha.setChaItem(null);
                Joueur.putInventaire(vCha.getChaItem());
                GameEngine.getGui().println("Vous avez gagner le numéro de " + vCha.getNom());
            }
        }

        if(vC.equals("b")) 
        {
            GameEngine.getGui().println("Bien essayer mais ce n'est pas suffisant...");
        }

        if(vC.equals("c")) 
        {
            GameEngine.getGui().println("Vous vous êtes pris une claque !!");
        }

        if(vC.equals("d") )
        {
            GameEngine.getGui().println("Vous vous êtes pris un basche !!");
        }
    }
}

