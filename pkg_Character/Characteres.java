package pkg_Character;
import pkg_Room.Room;
import pkg_Item.*;

/**
 * Décrivez votre classe abstraite Charactere ici.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Characteres
{
    // variable d'instance - remplacez cet exemple par le vôtre
    private  String aNom;
    private  String aDescription;
    private  String aDialogues;
    private  static Item aItem;
    private  static Room aCurrentRoom;
//     private ItemList aItems;
    public Characteres(final String pNom, final String pDesc, final String pDialogue, final Room pCurrentRoom, final Item pItem)
    {
        this.aNom = pNom;
        this.aDescription = pDesc;
        this.aDialogues = pDialogue;
        this.aItem = pItem;
        this.aCurrentRoom = pCurrentRoom;
//         this.aItems = new ItemList();
    }
    
    public String getNom()
    {
        return aNom;
    }
    
    public String getChaDescription()
    {
        return this.aDescription;
    }
    
    public String getChaLongDecription()
    {
        String vDesc = (aNom + (" ") + aDescription);
        return vDesc;
    }
    
    public  String getDialogue()
    {
        return aDialogues;
    }
    
    public static Item getChaItem()
    {
        return aItem;
    }
    
//     public void removeChaInventaire(final String pI)
//     {
//         aItem.remove(pI);
//     }
    
    public static Room getCurrentRoom()
    {
        return aCurrentRoom;
    }
    
    public void setChaItem(final Item pI)
    {
        this.aItem = pI;
    }
    
//     public Item get(final String pN)
//     {
//         return this.aItems.get(pN); 
//     }
}
