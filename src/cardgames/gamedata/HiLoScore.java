package cardgames.gamedata;

/**
 *
 * @author User
 */
//defines score objects from HiLo for the scoreboard
public class HiLoScore extends Score{
    private final int bet;
    private final int streak;
    private final boolean result;

    public HiLoScore(int bet, int streak, boolean result) {
        this.bet = bet;
        this.streak = streak;
        this.result = result;
    }

    public int getBet() {
        return bet;
    }

    public int getStreak() {
        return streak;
    }

    public boolean getResult() {
        return result;
    }
    
    @Override
    public String printScores() {
        StringBuilder sb = new StringBuilder("Bet: ");
        sb.append(bet);
        sb.append("\n");

        if (result) {
            sb.append("You won ");
            sb.append((int)(bet * Math.pow(2, streak)));
            sb.append(" tokens from a streak of ");
        }
        else if (!result) {
            sb.append("You lost after a streak of ");
        }
        sb.append(streak);
        if (streak == 1) {
            sb.append(" correct guess\n");
        }
        else {
            sb.append(" correct guesses\n");
        }
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return "HiLo";
    }
    
}
