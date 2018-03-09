package minigames.cardgames.gamedata;

import java.util.ArrayList;

public class Scoreboard {
    private int tokens;
    private final ArrayList<Score> scores = new ArrayList<>();
    
    public Scoreboard() {
        tokens = 100;
    }

    public int getTokens() {
        return tokens;
    }
    
    public int getTokenValue() {
        return tokens*50;
    }
    
    public void addTokens(int tokens) {
        this.tokens += tokens;
    }
    
    public void betTokens(int bet){
        tokens -= bet;
    }

    //Method to add a played game of blackjack to the scoreboard, currently a separate method in case future games have data of the same format
    public void addNewBlackjackScore(int bet, int dealerValue, int playerValue, int result) {
        scores.add(new BlackjackScore(bet, dealerValue, playerValue, result));
        if (result > 0) {
            tokens += bet*result;
        }
        
    }
    
    //Creates a list only containing score objects from Blackjack
    public ArrayList<BlackjackScore> getBlackjackList() {
        ArrayList<BlackjackScore> blackjackList = new ArrayList<>();
        for (Score s : scores) {
            if (s instanceof BlackjackScore) {
                blackjackList.add((BlackjackScore)s);
            }
        }
        return blackjackList;
    }
    
    private int getBlackjacks() {
        int blackjacks = 0;
        ArrayList<BlackjackScore> blackjackList = getBlackjackList();
        for (BlackjackScore s : blackjackList) {
            if (s.getResult() == 3) {
                blackjacks++;
            }
        }
        return blackjacks;
    }
    
    private int getBlackjackWins() {
        int wins = 0;
        ArrayList<BlackjackScore> blackjackList = getBlackjackList();
        for (BlackjackScore s : blackjackList) {
            if (s.getResult() >= 2) {
                wins++;
            }
        }
        return wins;
    }
    
    private int getBlackjackDraws() {
        int draws = 0;
        ArrayList<BlackjackScore> blackjackList = getBlackjackList();
        for (BlackjackScore s : blackjackList) {
            if (s.getResult() == 1) {
                draws++;
            }
        }
        return draws;
    }
    
    private int getBlackjackLosses() {
        int losses = 0;
        ArrayList<BlackjackScore> blackjackList = getBlackjackList();
        for (BlackjackScore s : blackjackList) {
            if (s.getResult() <= 0) {
                losses++;
            }
        }
        return losses;
    }
    
    //Method to get a printable string from the blackjack scoreboard
    public String getBlackJackScores() {
        ArrayList<BlackjackScore> blackjackList = getBlackjackList();
        StringBuilder sb = new StringBuilder("\n");
        
        for (int i = 0; i < blackjackList.size(); i++) {
            sb.append("Game ");
            sb.append(i + 1);
            sb.append(": ");
            sb.append(blackjackList.get(i).printScores());
        }
        
        sb.append("\nYou have played ");
        sb.append(blackjackList.size());
        sb.append(" times.\nYou have won ");
        sb.append(getBlackjackWins());
        sb.append(" times, and ");
        sb.append(getBlackjacks());
        sb.append(" of those wins were blackjacks\n");
        sb.append(getBlackjackDraws());
        sb.append(" of the games ended in a draw, and ");
        sb.append(getBlackjackLosses());
        sb.append(" of the games ended in a loss\n");
        
        return sb.toString();
    }
    
    public void addNewHiLoScore(int bet, int streak, boolean result) {
        scores.add(new HiLoScore(bet, streak, result));
        if (result) {
            tokens += bet*Math.pow(2, streak);
        }
    }
    
    public ArrayList<HiLoScore> getHiLoList() {
        ArrayList<HiLoScore> hiLoList = new ArrayList<>();
        for (Score s : scores) {
            if (s instanceof HiLoScore) {
                hiLoList.add((HiLoScore)s);
            }
        }
        return hiLoList;
    }
    
    private int getHiLoWins() {
        int wins = 0;
        ArrayList<HiLoScore> hiLoList = getHiLoList();
        for (HiLoScore s : hiLoList) {
            if (s.getResult()) {
                wins++;
            }
        }
        return wins;
    }
    
    private int getHiLoLosses() {
        int losses = 0;
        ArrayList<HiLoScore> hiLoList = getHiLoList();
        for (HiLoScore s : hiLoList) {
            if (!s.getResult()) {
                losses++;
            }
        }
        return losses;
    }
    
    private int getHiLoBest(){
        ArrayList<HiLoScore> hiLoList = getHiLoList();
        int best = 0;
        for (HiLoScore s : hiLoList) {
            if (s.getResult() && s.getStreak() > best) {
                best = s.getStreak();
            }
        }
        return best;
    }
    
    public String getHiLoScores() {
        ArrayList<HiLoScore> hiLoList = getHiLoList();
        
        StringBuilder sb = new StringBuilder("\n");
        
        for (int i = 0; i < hiLoList.size(); i++) {
            sb.append("Game ");
            sb.append(i + 1);
            sb.append(": ");
            sb.append(hiLoList.get(i).printScores());
        }
        sb.append("\nYou have played ");
        sb.append(hiLoList.size());
        sb.append(" times.\nYou have won ");
        sb.append(getHiLoWins());
        sb.append(" times, and lost ");
        sb.append(getHiLoLosses());
        sb.append(" times\nBest win streak: ");
        sb.append(getHiLoBest());
        sb.append("\n");
        
        return sb.toString();
    }
    
    public String showAllScores(){
        StringBuilder sb = new StringBuilder("\n");
        for (Score s : scores) {
            sb.append("Game ");
            sb.append(s.getID() + 1);
            sb.append(": ");
            sb.append(s);
            sb.append(": ");
            sb.append(s.printScores());
        }
        
        sb.append("\nYou have played ");
        sb.append(getBlackjackList().size());
        sb.append(" rounds of Blackjack, ");
        sb.append(getHiLoList().size());
        sb.append(" rounds of HiLo, a total of ");
        sb.append(scores.size());
        sb.append(" games played\n");
        
        return sb.toString();
    }
}
