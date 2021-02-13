package HW16;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        int gameChoice;
        String playChoice;
        int playerScore;
        int [][] winnerTable = {{0, 2, 1}, {1, 0, 2}, {2, 1, 0}};
        int tie =0;
        int gameWinCount = 0;
        int playerWinCount = 0;
        System.out.println("User name: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        System.out.println("Hello, "+ userName+ "! Do u wanna play a little game?Yes or no");
        Scanner sc1 = new Scanner(System.in);
        String answrStrtGme = sc1.nextLine();
            if (answrStrtGme.equalsIgnoreCase("yes")){
                System.out.println("How many rounds do you need?");
                Scanner scInt = new Scanner(System.in);
                int gmRounds = scInt.nextInt();
                for (int i = 1; i <=gmRounds; i++) {
                    System.out.println("-----------Round: "+ i+ "-----------------");
                    playerScore  = -2;
                    while (playerScore == -2){
                        System.out.println("Your options: rock, paper, scissors or exit ");
                        playChoice = sc.next();
                        switch (playChoice.toLowerCase()){
                            case "rock":
                                playerScore = 0;
                                break;
                            case "paper":
                                playerScore  = 1;
                                break;
                            case "scissors":
                                playerScore = 2;
                                break;
                            case "exit":
                                playerScore = -1;
                                break;
                            default:
                                System.out.println("you lost your turn");
                        }
                    }if (playerScore == -1){
                        break;
                    }
                    gameChoice = (int)((Math.random()*3));
    if (gameChoice == 0){
        System.out.println("rock");
    }else if(gameChoice == 1){
        System.out.println("paper");

    }else if (gameChoice == 2){
        System.out.println("scissors");
    }
    if (winnerTable[playerScore][gameChoice] == 0){
        System.out.println("-Tie-");
        tie ++;
    }else if(winnerTable[playerScore][gameChoice] == 1){
        System.out.println("-Player wins-");
        playerWinCount ++;
    }else if(winnerTable[playerScore][gameChoice] == 2) {
        System.out.println("-You lost-");
        gameWinCount++;
    }
                }
                System.out.println("Score: Player " + userName + "\n  Total: "+ playerWinCount + "\nScore: Game \n  Total: "+ gameWinCount);


            }else if(answrStrtGme.equalsIgnoreCase("no")){
                System.out.println("Why are you here? Go away");

            }else {
                System.out.println("Try to restart.");}

try {
    String content = ("=========================== \nPlayer " +userName +"\nScore: "+ playerWinCount
            + " \n Game \n Score: "+ gameWinCount+ "\n Ties: "+ tie +"\n===========================");
    File tableFile = new File("GameTable.txt");
if(!tableFile.exists()){
    tableFile.createNewFile();
    FileWriter tableWriter = new FileWriter(tableFile.getAbsoluteFile());
    BufferedWriter tableBWriter = new BufferedWriter(tableWriter);
    tableBWriter.write(content);
    tableBWriter.close();
}
}catch (Exception e){
    System.out.println(e);
}

}

}