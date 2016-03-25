package game;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by SteshenkoMA on 23.03.16.
 */

//Данный класс отвечает создание WinNumber для каждого уровня и запускает саму игру
public class Game {

    private int level = 1;
    private int winNumber;
    private boolean gameOn= true;

    public boolean getGameOn(){
        return gameOn;
    }

    //Метод, который для каждого уровня создает WinNumber
    private int generateWinNumber(int level){
        Random rnd = new Random();
        switch (level) {
            case 1:
                System.out.println("Уровень " + level);
                System.out.println("Угадайте число от 0 до 9");
                return rnd.nextInt(10);
            case 2:
                System.out.println("Уровень " + level);
                System.out.println("Угадайте число от 0 до 99");
                return rnd.nextInt(100);
            case 3:
                System.out.println("Уровень " + level);
                System.out.println("Угадайте число от 0 до 999");
                return rnd.nextInt(1000);
            default:
                System.out.println("Ошибка в заданном уровне");
                return 0;
        }
    }

    //Метод запускающий игру
    public void play (Player player){
        int inputNumber;
        int attemps = 1;

        winNumber = generateWinNumber(level);
        //System.out.println(winNumber); //Загаданное число

        Scanner consoleReader = new Scanner(System.in);
        while (consoleReader.hasNext()) {
            try {
                inputNumber = Integer.valueOf(consoleReader.next());
            } catch (Exception e) {
                System.out.println("Вы ввели не число. Введите число:");
                continue;
            }
            if (inputNumber == winNumber) {
                System.out.println("Вы угадали. Уровень: " + level + " пройден. Потрачено ходов: " + attemps);
                player.setRating(level, attemps);

                level++;

                if(level > 3){
                    gameOn = false;
                }

                break;

            } else if (winNumber > inputNumber) {
                System.out.println("Число больше " + inputNumber + ". Введите число:");
                attemps++;
                continue;

            } else if (winNumber < inputNumber) {
                System.out.println("Число меньше " + inputNumber + ". Введите число:");
                attemps++;
                continue;
            }
        }

    };

}
