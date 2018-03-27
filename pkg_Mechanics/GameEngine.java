package pkg_Mechanics;
import pkg_Command.Parser;
import pkg_Character.Player;
import pkg_Command.CommandWord;
import pkg_Command.Command;
import pkg_Room.*;
import pkg_Item.Item;
import pkg_Item.Beamer;
import pkg_Character.Characteres;
import pkg_Character.CharacteresList;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
 *  This class is part of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.
 * 
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (Jan 2003)
 */
public class GameEngine
{
    private static Parser aParser;
    private static UserInterface gui;
    private static Player Joueur;
    private static int aLimite;
    private Timer timer;
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine() 
    {
        aParser = new Parser();
        createPlayer();
        createRooms();
        this.aLimite = 15*60;

        ActionListener vListener = new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                {
                    aLimite--;
                    gui.setTimer("" + aLimite);
                    if (aLimite <= 0)
                    {
                        gui.println("Vous avez perdu.");
                        endGame();
                        timer.stop();
                    }
                }
            };
        this.timer = new Timer(1000, vListener);
        timer.start();
    }//GameEngine()

    public void setGUI(final UserInterface userInterface)
    {
        gui = userInterface;
        printWelcome();
        gui.setTimer(""+ aLimite);
    }//setGUI()

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        gui.print("\n");
        gui.println("Bienvenue dans le jeu!");
        gui.println("Ecrit"+ CommandWord.AIDE + "si tu as besoin d'aide.");
        gui.print("\n");
        gui.println(Joueur.getCurrentRoom().getLongDescription());
        gui.showImage(Joueur.getCurrentRoom().getImageName());
    }//printWelcome()

    private void createRooms()
    {
        //define the rooms
        Room Rue, Bar1, Bar2, Bar3, Bar4, Bar5, Bar6, Bar7, Bar8, EtageBar8, Bar9, Bar10;
        //create and define the items
        Item Parapluie = new Item("parapluie","Un parapluie noir", 3, false);
        Item Biere = new Item("Biere","Une Biere blonde.", 3, false);
        Item MagicBeer = new Item("MagicBeer","Cette bière vous permettera de trouver vos réponses.", 2, true);
        Beamer Beamer = new Beamer("Beamer", "Cet objet vous permettra de revenir à une pièce.", 3, true);
        Item Clef = new Item("Clef", "Cet clef te permet de sortir du bar", 2, true);
        Item Numero = new Item("Numero", "O6.46.10.32.37", 1, false);
        
        Characteres Maeva = new Characteres("Maeva", "Une brune aux yeux vert", "", null, null);
        Characteres Marie = new Characteres("Marie", "Une blonde mince", "", null, null);
        Characteres Mathilde = new Characteres("Mathilde", "Une petite femme qui a l'air fort sympathique", "", null, null);
        Characteres Coralie = new Characteres("Coralie", "Une petite aux cheveux châtain", "", null, null);
        Characteres Solene = new Characteres("Solene", "Une fille timide", "", null, null);
        Characteres Lucile = new Characteres("Lucile", "Une grande femme réservée", "", null, null);
        Characteres Capucine = new Characteres("Capucine", "Une femme extravagante", "", null, Numero);
        Characteres Clara = new Characteres("Clara", "Une femme charmante", "", null, null);
        Characteres Lucifer = new Characteres("Lucifer", "Un diablotin des bars", "", null, null); 
        Characteres Helene = new Characteres("Helene", "Une belle métisse", "", null, null);
        // create the rooms
        Rue = new Room("dans la rue, vous avez accès à tous les bars.", "Images/Street.jpg", null, null);
        Bar1 = new TransporterRoom("dans le bar l'Antidote","Images/Bar1.jpeg", null, null);
        Bar2 = new Room("dans le bar le Requin Chagrin","Images/Bar2.JPG", null, null);
        Bar3 = new Room("dans le bar le Caisson","Images/Bar3.jpg/", null, null);
        Bar4 = new Room("dans le bar la Fabrique","Images/Bar4.jpg", null, null);
        Bar5 = new Room("dans le bar le Secret Bar","Images/Bar5.jpg", null, null);
        Bar6 = new Room("dans le bar l'Institut","Images/Bar6.jpg", null, null);
        Bar7 = new Room("dans le bar le Papillon","Images/Bar7.jpg", null, null);
        Bar8 = new Room("dans le bar le Beffroi","Images/Bar8.jpg", null, null);
        EtageBar8 = new Room("A cet étage tu trouvera la clef te permettant de sortir", "Images/EtageBar8.jpg", null, null);
        Bar9 = new Room("dans le bar l'Urgence Bar","Images/Bar9.png", null, null);
        Bar10 = new Room("dans le bar le Makoumba","Images/Bar10.jpg", null, null);
        // initialise room exits
        Rue.setExit("Bar1", Bar1);
        Rue.setExit("Bar2", Bar2);        
        Rue.setExit("Bar3", Bar3);
        Rue.setExit("Bar4", Bar4);
        Rue.setExit("Bar5", Bar5);
        Rue.setExit("Bar6", Bar6);
        Rue.setExit("Bar7", Bar7);
        Rue.setExit("Bar8", Bar8);
        Rue.setExit("Bar9", Bar9);
        Rue.setExit("Bar10", Bar10);

        Bar1.setExit("Rue", Rue);
        Bar2.setExit("Rue", Rue);
        Bar3.setExit("Rue", Rue);
        Bar4.setExit("Rue", Rue);
        Bar5.setExit("Rue", Rue);
        Bar6.setExit("Rue", Rue);
        Bar7.setExit("Rue", Rue);
        Bar8.setExit("Rue", Rue);
        Bar8.setExit("Haut", EtageBar8);
        EtageBar8.setExit("Bas", Bar8);
        Bar9.setExit("Rue", Rue);
        Bar10.setExit("Rue", Rue);

        Rue.getItemList().addItem(Parapluie.getName(), Parapluie);
        Bar1.getItemList().addItem(Biere.getName(),Biere);
        Bar3.getItemList().addItem(MagicBeer.getName(), MagicBeer);
        Bar4.getItemList().addItem(Beamer.getName(), Beamer);
        EtageBar8.getItemList().addItem(Clef.getName(), Clef);

        Bar1.getChaList().addCharacteres(Maeva.getNom(), Maeva);
        Bar2.getChaList().addCharacteres(Marie.getNom(), Marie);
        Bar3.getChaList().addCharacteres(Mathilde.getNom(), Mathilde);
        Bar4.getChaList().addCharacteres(Coralie.getNom(), Coralie);
        Bar5.getChaList().addCharacteres(Solene.getNom(), Solene);
        Bar6.getChaList().addCharacteres(Lucifer.getNom(), Lucifer);
        Bar7.getChaList().addCharacteres(Capucine.getNom(), Capucine);
        Bar8.getChaList().addCharacteres(Clara.getNom(), Clara);
        Bar9.getChaList().addCharacteres(Lucile.getNom(), Lucile);
        Bar10.getChaList().addCharacteres(Helene.getNom(), Helene);
        
//         Capucine.getCurrentRoom().getChaItemList().addItem(Numero.getName(), Numero);
        
        Joueur.setCurrentRoom(Rue); 
        //         ((TransporterRoom)Bar5).setARooms(this.aRooms);
    }//createRooms()

    /**
     * Create all the rooms and link their exits together.
     */
    public void createPlayer()
    {
        Joueur = new Player("Hank",null , 15.0);
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public static void interpretCommand(final String commandLine) 
    {
        getGui().println(commandLine);
        Command command = aParser.getCommand(commandLine);
        if(command == null) 
        {
            gui.println("\n Je ne comprends pas ce que vous voulez dire. \n");
            return;
        }
        else 
        {
            command.execute(Joueur);
        }//interpretCommand()
    }

    public static Parser getParser()
    {
        return aParser;
    }

    public static UserInterface getGui()
    {
        return gui;
    }

    public static int getLimite()
    {
        return aLimite;
    }

    public static void setLimite(final int pLimite)
    {
        aLimite = pLimite;
    }
    // implementations of user commands
    public void printLocationInfo()
    {
        gui.println(Joueur.getCurrentRoom().getLongDescription());
    }//printLocationInfo()

    public Player getPlayer()
    {
        return Joueur;
    }//getPlayer()
    
    public void gagner()
    {
        if ( Joueur.getInventaire().hasItem("Numero"))
        {
            gui.println("Bravo, vous avez gagner !!");
        }
    }
    
    public void perdre()
    {
        if(this.aLimite <= 0)
        {
            gui.println("Vous avez perdu !!");
            endGame();
        }
        
    }

    public static void endGame()
    {
        gui.println("Merci d'avoir joué. Bonne journée.");
        gui.enable(false);
    }//endGame()
}// class GameEngine
