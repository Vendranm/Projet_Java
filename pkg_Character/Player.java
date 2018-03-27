package pkg_Character;

import pkg_Room.Room;
import pkg_Item.ItemList;
import pkg_Item.Item;
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author Maxime Vendrand-Maillet
 * @version (a version number or a date)
 */
public class Player
{
    private String aName;
    private double aPoidMax;
    private Room aCurrentRoom;
    private Room aBackRoom;
    private Room aPreviousRoom;
    private Stack<Room> aBackRooms;
    private ItemList aItems;
    /**
     * Constructor for objects of class Player
     */
    public Player(final String pName, final Room pcurrentRoom,final double pPoidMax)
    {
        this.aName= pName;
        this.aPoidMax = pPoidMax;
        this.aCurrentRoom = pcurrentRoom;
        this.aBackRooms = new Stack<Room>();
        this.aItems = new ItemList();
    }
    
    public void backPlayer()
    {
        this.aBackRoom = aBackRooms.pop();
        this.aCurrentRoom = aBackRoom;
    }
    
    /**
     * Retourne les salles (stack)
     */
    public Stack<Room> getBackRoom()
    {
        return this.aBackRooms;
    }
    
    public Room getPreviousRoom()
    {
        return this.aPreviousRoom;
    }
    
    /**
     * Fixer la salle du joueur
     */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }
    
    /**
     * Retourne la salle du joueur
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
    /**
     * Retourne l'inventaire
     */
    public ItemList getInventaire()
    {
        return this.aItems;
    }
    
    /**
     * Rajoute l'item à l'inventaire
     */
    public void putInventaire(final Item pI)
    {
        this.aItems.put(pI);
    }
   
    /**
     * Enlève l'item de l'inventaire
     */
    public void removeInventaire(final String pI)
    {
        this.aItems.remove(pI);
    }
    
    /**
     * Retourne le nom du joueur 
     */
    public String getName()
    {
        return aName;
    }
    
    /**
     * Retourne le poid max que peut porter le joueur 
     */
    public double getPoidMax()
    {
        return aPoidMax;
    }
    
    public void changeRoom(final Room pRoom)
	{
		this.aPreviousRoom = aCurrentRoom;
		this.aCurrentRoom = pRoom;
	}
	
	public Item get(final String pN)
    {
        return this.aItems.get(pN); 
    }
}//Player