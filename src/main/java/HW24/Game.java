package HW24;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static HW24.MainGame.*;

public class Game {
    public static String playerName;
    public static int winsPlayer = 0;
    public static int winsOpp = 0;
    private String pl;
    private static String gameLog;

    public Game (int opponent) throws Exception {
        switchRSP(move(), opponent);
    }

    public static void registration(){
        loggerInfo.info((resourceBundle.getString("name" )));
        Scanner sc = new Scanner(System.in);
        playerName = sc.nextLine();
    }

    public static int gameRounds() {
        int gRounds;
        loggerDebug.info(resourceBundle.getString("rounds"));
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNextInt()) {
                gRounds = sc.nextInt();
                break;
            }
        }return gRounds;
    }



    public void switchRSP(int player, int opponent) {
        String movePlayer = null;
        String moveOpponent = null;
            switch (player) {
                case 0:
                    if (player == 0) movePlayer = "rock";
                    break;
                case 1:
                    if (player == 1) movePlayer = "paper";
                    break;
                case 2:
                    if (player == 2) movePlayer = "scissors";
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        switch (opponent) {
            case 0:
                if (opponent == 0) moveOpponent = "rock";
                break;
            case 1:
                if (opponent == 1) moveOpponent = "paper";
                break;
            case 2:
                if (opponent == 2) moveOpponent = "scissors";
                break;
            default:
                System.out.println("Error");
                break;
        }
        gameWinner(player, opponent);
        gameLog += "\n== Round ==\n"+ playerName+ "  turn ----->  "+ movePlayer +"\nComputer  turn ----->  "
                +moveOpponent+ "\n== Round End ==\n"+ pl + " winning this round.";
        loggerInfo.info(gameLog);

    }

    public int move() throws Exception{
        int move;
        while (true){
            loggerDebug.info(resourceBundle.getString("choose"));
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()){
                move = sc.nextInt();
                if (move>= 0 && move < 3){
                    break;
                }else if (move == 3) {
                    gLog();
                    loggerDebug.info(playerName + " left game.");
                    System.exit(0);
                }else {
                    loggerWarn.warn("Invalid input");
                    loggerDebug.info(resourceBundle.getString("choose"));
                }
            }else {
                loggerWarn.warn("Invalid input");
                loggerDebug.info(resourceBundle.getString("choose"));
                sc.next();
            }
        }
        return move;
    }

    public void gameWinner(int player, int opponent) {
        int[][] winnerTable = {{0, 2, 1}, {1, 0, 2}, {2, 1, 0}};
        int wiRes = winnerTable[player][opponent];
        if (wiRes == 0) {
            pl = resourceBundle.getString("tie");
            winsPlayer++;
            winsOpp++;
        } else if (wiRes == 2) {
            pl = resourceBundle.getString("win") + playerName;
            winsPlayer++;
        } else {
            pl = resourceBundle.getString("win") + " Computer ";
            winsOpp++;
        }
    }

    public static void gLog(){
        gameLog += "\n ======ROCK PAPER SCISSORS====== \n =======Round======= \n Score of " + playerName
                + " "+ winsPlayer +"\n Score Computer: " +winsOpp;


    }

    public static void wLog(String winner) {
        if (winsPlayer != 0 || winsOpp != 0) {
            gameLog += "\n======ROCK PAPER SCISSORS======\n" + playerName + " AGAINST Computer" + "\n and THE WINNER IS........\n "
                    + winner + "\n CONGRATULATIONS!!!" + "======GAME END======\n" + playerName + "\nTOTAL WINS: " + winsPlayer
                    + "\nComputer \nTOTAL WINS: " + winsOpp;
        }
        try {
            File tableFile = new File("GameTable.txt");
            if (!tableFile.exists()) {
                tableFile.createNewFile();
                FileWriter tableWriter = new FileWriter(tableFile.getAbsoluteFile());
                BufferedWriter tableBWriter = new BufferedWriter(tableWriter);
                tableBWriter.write(gameLog);
                tableBWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public void exit(){
        wLog(pl);
    }

}
