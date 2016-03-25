package game;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by SteshenkoMA on 23.03.16.
*/
//Данный класс содержит информацию об игроке
public class Player implements Serializable{

    private String name;
    private int lvl_1;     // Количество потраченных ходов в Уровне 1
    private int lvl_2;     // Количество потраченных ходов в Уровне 2
    private int lvl_3;     // Количество потраченных ходов в Уровне 3
    private int lvls_Sum;  // Количество потраченных ходов за всю игру

    Player(){
    };

    public Player(String name, int lvl_1, int lvl_2, int lvl_3){
        this.name = name;
        this.lvl_1 = lvl_1;
        this.lvl_2 = lvl_2;
        this.lvl_3 = lvl_3;
    };

    //Метод задающий имя игрока, ожидает ввода с консоли
    public void setName() {
        Scanner consoleReader = new Scanner(System.in);
        while (consoleReader.hasNext()) {

           name = consoleReader.next();
           break;
        }
    }

    //Метод устанавливающих для каждого уровня количество потраченных ходов
    public void setRating(int level, int attempts) {
        switch (level) {
            case 1:
            lvl_1 = attempts;
            case 2:
            lvl_2 = attempts;
            case 3:
            lvl_3 = attempts;
        }
    }

    public String getName() {
        return name;
    }

    public int getLvl_1() {
        return lvl_1;
    }

    public int getLvl_2() {
        return lvl_2;
    }

    public int getLvl_3() {
        return lvl_3;
    }

    public int getLvls_Sum() {
        lvls_Sum = lvl_1+lvl_2+lvl_3;
        return lvls_Sum;
    }

    @Override
    public String toString() {
        String info = name + " " + lvl_1 + " " + lvl_2 + " " + lvl_3 + " " + getLvls_Sum();
        return info;
    }

}
