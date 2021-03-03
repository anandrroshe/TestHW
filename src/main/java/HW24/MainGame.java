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
            loggerDebug.info("\n======ROCK PAPER SCISSORS====== \n == " + Game.playerName + " AGAINST Computer==");
            try {
                for (int i = gameRound; i > 0; i--) {
                    int g = (int) ((Math.random() * 3));
                    Game game = new Game(g);
                    if (i==1){game.exit();}
                }


            } catch (Exception e) {
                loggerError.error(e.toString());
            } finally {
                Game.gLog();
                loggerDebug.debug(Game.playerName + " left game.");

            }

        }
    }



//                loggerConnection.info("\n -Help-\nLanguage settings: \n1.English - EN \n2.Spanish - ES \n3.Russian - RU");
//                Scanner sc = new Scanner(System.in);
//                String lang = sc.next();
//
//                Locale.setDefault(new Locale("en"));
//                locale = Locale.getDefault();
//                start = true;



//        if (start == true){
//
//            resourceBundle = ResourceBundle.getBundle("lang", locale);
//
//            resourceBundle.getString("name");
//            Game.registration();

//            gameRound = Game.gameRounds();
//            System.out.println("start");
//            loggerConnection.debug("======ROCK PAPER SCISSORS====== \n == " + Game.playerName + " AGAINST Computer==");
//            System.out.println("start");
//            try {
//                while (gameRound != 0){
//                    Game game = new Game((int)((Math.random()*3)));
//                    loggerInfo.info(String.valueOf(game));
//                    gameRound--;
//                    }
//                }catch (Exception e){
//                loggerError.error(e.toString());
//            }finally {
//                Game.gLog();
//                loggerDebug.debug(Game.playerName+" left game.");
//
//            }
//
//        }


    }



