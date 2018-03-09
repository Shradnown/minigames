package cardgames.gamedata;

/**
 *
 * @author User
 */
//defines score objects from Blackjack for the scoreboard
public class BlackjackScore extends Score {
    private final int bet;
    private final int dealerValue;
    private final int playerValue;
    private final int result;

    public BlackjackScore(int bet, int dealerValue, int playerValue, int result) {
        this.bet = bet;
        this.dealerValue = dealerValue;
        this.playerValue = playerValue;
        this.result = result;
    }

    public int getBet() {
        return bet;
    }

    public int getDealerValue() {
        return dealerValue;
    }

    public int getPlayerValue() {
        return playerValue;
    }

    public int getResult() {
        return result;
    }
    
    @Override
    public String printScores() {
        StringBuilder sb = new StringBuilder("Bet: ");
        sb.append(bet);
        sb.append("\n");
        switch (result) {
            case 3:
                sb.append("You won with a Blackjack against the dealers hand of ");
                sb.append(dealerValue);
                sb.append("\n");
                break;
            case 2:
                sb.append("You won with a hand of ");
                sb.append(playerValue);
                sb.append(" against the dealers hand of ");
                sb.append(dealerValue);
                sb.append("\n");
                break;
            case 1:
                sb.append("You drew with the dealer, both having a hand of ");
                sb.append(playerValue);
                sb.append("\n");
                break;
            case 0:
                sb.append("You lost with a hand of ");
                sb.append(playerValue);
                sb.append(" against the dealers hand of ");
                sb.append(dealerValue);
                sb.append("\n");
                break;
            case -1:
                sb.append("You lost with a hand of ");
                sb.append(playerValue);
                sb.append("\n");
                break;
            default:
                break;
        }
        return sb.toString();
    
    }
    
    @Override
    public String toString() {
        return "Blackjack";
    }
}
