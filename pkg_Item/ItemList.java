package pkg_Item;

import java.util.HashMap;
import java.util.Set; 
/**
 * Décrivez votre classe ItemList ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ItemList
{
    private HashMap<String, Item> aItemList;
    
    /**
     * Constructeur d'objets de classe ItemList
     */
    public ItemList()
    {
        this.aItemList = new HashMap<String, Item>();
    }
    
    public void addItem(final String pNom, final Item pItem)
    {
        this.aItemList.put(pNom, pItem);
    }//addItem()
    
    public void put(final Item pItem)
    {
        aItemList.put(pItem.getName(),pItem);
    }
    
    public void remove(final String pItem)
    {
        this.aItemList.remove(pItem);
    }
    
    public boolean isEmpty()
    {
        return this.aItemList.isEmpty();
    }
    
    public Item get(final String pN)
    {
        return this.aItemList.get(pN); 
    }
    
    public HashMap<String,Item> getaItemList()
    {
        return this.aItemList;
    }//getaItems()
    
    public String getItemsString()
    {
        String RS = " \n";
        Set<String> keySet = aItemList.keySet();
        for (String vItem : keySet) RS = RS + aItemList.get(vItem).getName() +" : " + aItemList.get(vItem).getItemDescription() + "\n";
        return RS;
    }//getItem()
    
    public boolean hasItem(final String pI)
    {
        return this.aItemList.containsKey(pI);
    }
}
