package HW24;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;
import java.util.Scanner;

import static HW24.Game.registration;

public class MainGame {
    public static ResourceBundle resourceBundle;
    public static final Logger loggerDebug = LoggerFactory.getLogger("logger.debug");
    public static final Logger loggerWarn = LoggerFactory.getLogger("logger.warn");
    public static final Logger loggerInfo = LoggerFactory.getLogger("logger.info");
    public static final Logger loggerError = LoggerFactory.getLogger("logger.error");

    public static int gameRound;
    public static void main(String[] args) {
        resourceBundle = ResourceBundle.getBundle("lang_en");
        loggerInfo.info(resourceBundle.getString("help"));
        Scanner scLang = new Scanner(System.in);
        String lang = scLang.next();
        switch (lang.toUpperCase()){
            case "EN":
                resourceBundle = ResourceBundle.getBundle("lang_en");
                break;
            case "ES":
                resourceBundle = ResourceBundle.getBundle("lang_es");
                break;
            case "RU":
                resourceBundle = ResourceBundle.getBundle("lang_ru");
                break;
            default:
                resourceBundle = ResourceBundle.getBundle("lang_en");
                break;
        }
        boolean start;
        registration();
        loggerInfo.info(resourceBundle.getString("game"));
        Scanner sc = new Scanner(System.in);
        start = sc.nextBoolean();
        gameRound = Game.gameRounds();
        if (start == true) {
            loggerDebug.info("\n======ROCK PAPER SCISSORS====== \n == " + Game.playerName + " AGAINST Computer ==");
            try {
                for (int i = gameRound; i > 0; i--) {
                    String string = "|     Round "+ i +"     |";
                    loggerInfo.info(string);
                    int g = (int) ((Math.random() * 3));
                    Game game = new Game(g);
                    if (i==1){game.exit();}
                    String temp = "Rounds left - "+ (i-1);
                    loggerInfo.info(temp);
                }


            } catch (Exception e) {
                loggerError.error(e.toString());
            } finally {
                Game.gLog();
                loggerDebug.debug(Game.playerName + " left game.");

            }

        }
    }
    }



