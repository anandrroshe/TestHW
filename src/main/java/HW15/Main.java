package HW15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        num = scanner.nextInt();
        Main.strPrint(Main.drawNum(num));
    }

    private static String[] drawNum(int num){
        String [] strNum = {"", "", "", "", "", "", ""};
        String [] strTemp;
        while (num>0){
            strTemp = strNumToDraw(num%10);
            for (int i = 0; i <strNum.length ; i++) {
                strNum[i] = strTemp[i] + " " + strNum[i];
            }
            num/=10;
        }
        return strNum;
    }

    private static String [] strNumToDraw (int num){
        switch (num){
            case 0:
                return new String[]{
                        "---***---",
                        "--**-**--",
                        "-**---**-",
                        "-**---**-",
                        "-**---**-",
                        "--**-**--",
                        "---***---"
                };
            case 1:
                return new String[]{
                        "---***---",
                        "--****---",
                        "***-**---",
                        "----**---",
                        "----**---",
                        "---****--",
                        "-*******-"
                };
            case 2:
                return new String[]{
                        "---***---",
                        "-******--",
                        "**---***-",
                        "----***--",
                        "---***---",
                        "--***----",
                        "-*******-"
                };
            case 3:
                return new String[]{
                        "---***---",
                        "-**--**--",
                        "------**-",
                        "----***--",
                        "------**-",
                        "-**----**",
                        "--******-"
                };
            case 4:
                return new String[]{
                        "-**---**-",
                        "-**---**-",
                        "-**---**-",
                        "-*******-",
                        "------**-",
                        "------**-",
                        "-----****",
                };
            case 5:
                return new String[]{
                        "-*******-",
                        "-**------",
                        "-**------",
                        "-*******-",
                        "------**-",
                        "------**-",
                        "-*******-",
                };
            case 6:
                return new String[]{
                        "-*******-",
                        "-**------",
                        "-**------",
                        "-*******-",
                        "-**---**-",
                        "-**---**-",
                        "-*******-",
                };
            case 7:
                return new String[]{
                        "-*******-",
                        "-**---**-",
                        "-**---**-",
                        "------**-",
                        "------**-",
                        "------**-",
                        "-----****",
                };
            case 8:
                return new String[]{
                        "-*******-",
                        "-**---**-",
                        "-**---**-",
                        "-*******-",
                        "-**---**-",
                        "-**---**-",
                        "-*******-",
                };
            case 9:
                return new String[]{
                        "-*******-",
                        "-**---**-",
                        "-**---**-",
                        "-*******-",
                        "------**-",
                        "------**-",
                        "-*******-",
                };
            default:
                return new String[]{
                        "ERROR",
                        "ERROR",
                        "ERROR",
                        "ERROR",
                        "ERROR",
                        "ERROR",
                        "ERROR",
                };
        }
    }
    private static void strPrint (String[] strings){
        for (String e: strings){
            System.out.println(e);
        }
    }

    }

