package pkg_Room;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
/**
 * Décrivez votre classe RoomRandomizer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RoomRandomizer
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private static HashMap<String, Room> aRooms;
    private static ArrayList<Room> aRoomsA;

    /**
     * Constructeur d'objets de classe RoomRandomizer
     */
    public RoomRandomizer(final HashMap<String, Room> pRooms)
    {
        // initialisation des variables d'instance
        this.aRooms = pRooms;
        this.aRoomsA = new ArrayList<Room>();
        fillArrayList();
    }

    private void fillArrayList()
    {
        for (String vS : this.aRooms.keySet())
        {
            this.aRoomsA.add(this.aRooms.get(vS));
        }
    }

    public Room findRandomRoom()
    {
        {
            Random vRandomizer = new Random();
            int vI = vRandomizer.nextInt(this.aRoomsA.size());
            return this.aRoomsA.get(vI);
        }
    }
}
