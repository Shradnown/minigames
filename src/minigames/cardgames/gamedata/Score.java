package minigames.cardgames.gamedata;

/**
 *
 * @author User
 */

//Defines (abstract) score objects for the scoreboard
public abstract class Score {
    private final int id;
    private static int idNumber = 0;

    public Score() {
        id = idNumber;
        idNumber++;
    }
    
    public int getID() {
        return id;
    }

    public int getIdNumber() {
        return idNumber;
    }
    
    public abstract String printScores();
    
    @Override
    public abstract String toString();
    
}
