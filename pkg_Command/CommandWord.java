package pkg_Command;


/**
 * Enumeration CommandWord - écrire ici la description de l'énumération
 *
 * @author (votre nom)
 * @version (numéro de version ou date)
 */
public enum CommandWord
{
    ALLER("aller", new AllerCommand()),
    QUITTER("quitter", new QuitterCommand()), 
    AIDE("aide", new AideCommand()), 
    UNKNOWN("?", null), 
    REGARDER("regarder", new RegarderCommand()), 
    BOIRE("boire", new BoireCommand()), 
    RETOUR("retour", new RetourCommand()), 
    TEST("test", new TestCommand()), 
    PRENDRE("prendre", new PrendreCommand()), 
    POSER("poser", new PoserCommand()), 
    CHARGER("charger", new ChargerCommand()),
    TELEPORTER("teleporter", new TeleporterCommand()),
    PARLER("parler", new ParlerCommand()),
    CHOIX("choix", new ChoixCommand());

    private String aCommandString;
    private Command aCommand;
    
    CommandWord(final String pCommandString, final Command pCommand)
    {
        this.aCommandString = pCommandString;
        this.aCommand = pCommand;
    }
    
    public String toString()
    {
        return aCommandString;
    }
    
    public Command getCommand()
    {
        return aCommand;
    }
}
