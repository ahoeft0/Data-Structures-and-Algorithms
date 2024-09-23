/**
 *
 * @author Ashton Hoeft
 * @version January 31, 2022
 * 
 * This class defines Player and its methods
 */
public class Player {
    private String name;
    private String position;
    private int jersey;
    
    /**
     * Constructor for Player
     * @param n name of player
     * @param p position of player
     * @param j jersey number of player
     */
    public Player(String n, String p, int j) {
        name = n;
        position = p;
        jersey = j;
    }
    
    /**
     * 
     * @return name of player
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @param n sets name to n
     */
    public void setName(String n) {
        name = n;
    }
    
    /**
     * 
     * @return position of player
     */
    public String getPosition() {
        return position;
    }
    
    /**
     * 
     * @param p set position to p
     */
    public void setPosition(String p) {
        position = p;
    }
    
    /**
     * 
     * @return jersey number of player
     */
    public int getJerseyNumber() {
        return jersey;
    }
    
    /**
     * 
     * @param j set jersey number to j
     */
    public void setJerseyNumber(int j) {
        jersey = j;
    }
    
    /**
     * 
     * @return contents of Player instance
     */
    public String toString(){
        return getClass().getName() + "@" + name + ":" + position + ":" + jersey;
    }
    
    /**
     * 
     * @param o  object to be compared
     * @return  true if objects equal
     */
    public boolean equals( Object o )
    {
        if ( !( o instanceof Player ) )
            return false;
        Player p = ( Player ) o;
        
        return name.equals(p.getName()) && position.equals(p.getPosition()) && jersey == p.getJerseyNumber();
    }
}
