package pkg_Item;


/**
 * Write a description of class Items here.
 * 
 * @author Maxime Vendrand-Maillet 
 * @version (a version number or a date)
 */
public class Item
{
    private String aDescription;
    private int aWeight;
    private boolean aEdible;
    private String aName;
    /**
     * Constructor for objects of class Items
     */
    public Item(final String pName, final String pDesc, final int pWeight, final boolean pEdible)
    {
        // initialise instance variables
        this.aName = pName;
        this.aDescription = pDesc;
        this.aWeight = pWeight;
        this.aEdible = pEdible;
    }//Item(final String pDesc, final int pWeight)
    
    public String getName()
    {
        return this.aName;
    }
    
    /**
     * Return the decription
     */
    public String getItemDescription()
    {
        return aDescription;
    }//getItemDescription()
    
    public String getItemLongDescription()
    {
        String aDescriptionItem = (aDescription + (" ") + aWeight);
        return aDescriptionItem;
    }//getItemLongDescription()
    
    public void setItemDescription (String pDescription)
    {
        this.aDescription = pDescription;
    }//setItemDescription (String pDescription)
    
    public int getWeight()
    {
        return aWeight;
    }//getWeight()
    
    public void setItemWeight(int pWeight)
    {
        this.aWeight = pWeight;
    }//setItemWeight(int pWeight)
    
    public boolean isEdible()
    {
        return this.aEdible;
    }
    
    public void setEdible(final boolean pEdible)
    {
        this.aEdible = pEdible;
    }
}//class Item
