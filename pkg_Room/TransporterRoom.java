package pkg_Room;
import pkg_Item.Item;
import pkg_Character.Characteres;
import java.util.HashMap;
/**
 * Décrivez votre classe TransporterRoom ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TransporterRoom extends Room
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private static  RoomRandomizer aRoomRand;
    
    /**
     * Constructeur d'objets de classe TransporterRoom
     */
    public TransporterRoom(final String pDesc,final String pImage,final Item pItem, final Characteres pCha)
    {
        // initialisation des variables d'instance
        super(pDesc, pImage, pItem, pCha);
    }
    
    public void setARooms(final HashMap<String, Room> pARooms)
    {
        this.aRoomRand = new RoomRandomizer(pARooms);
    }
    
    @Override
    public Room getExit(final String pDir)
    {
        return this.aRoomRand.findRandomRoom();
    }
}
