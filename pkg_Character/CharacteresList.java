package pkg_Character;

import java.util.HashMap;
import java.util.Set;
/**
 * Décrivez votre classe CharacterList ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CharacteresList
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private HashMap<String, Characteres> aCharacteresList;;

    /**
     * Constructeur d'objets de classe CharacterList
     */
    public CharacteresList()
    {
        this.aCharacteresList = new HashMap<String, Characteres>();
    }  
    
    public void addCharacteres(final String pNom, final Characteres pCha)
    {
        this.aCharacteresList.put(pNom, pCha);
    }
    
    public boolean isEmpty()
    {
        return this.aCharacteresList.isEmpty();
    }
    
    public Characteres get(final String pN)
    {
        return this.aCharacteresList.get(pN);
    }
    
    public HashMap<String, Characteres> getCharacteresList()
    {
        return this.aCharacteresList;
    }
    
    public boolean hasCharacteres(final String pC)
    {
        return this.aCharacteresList.containsKey(pC);
    }
    
    public String getCharactereString()
    {
        String RS = "\n";
        Set<String> keySet = aCharacteresList.keySet();
        for (String vCha : keySet) RS = RS + aCharacteresList.get(vCha).getNom() + " : " + aCharacteresList.get(vCha).getChaDescription() + "\n";
        return RS;
    }
}
