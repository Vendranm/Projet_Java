package pkg_Item;
import pkg_Room.Room;

/**
 * Décrivez votre classe Beammer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Beamer extends Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Room aSavedRoom;
    private boolean aCharged;

    public Beamer(final String pName, final String pDescription, final int pWeight, final boolean pCharged) 
    {
        super(pName, pDescription, pWeight, false);
    }

    public Room getSavedRoom() 
    {
        return aSavedRoom;
    }

    public void setSavedRoom(final Room pSavedRoom) 
    {
        this.aSavedRoom = pSavedRoom;
    }

    public boolean isCharged() 
    {
        return aCharged;
    }
    
    public void setCharged(final boolean pCharged) 
    {
        this.aCharged = pCharged;
    }
}
