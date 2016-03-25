package game;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by SteshenkoMA on 23.03.16.
 */

    //Данный класс создает файл PlayersList.txt (в нем хранится рейтинг игроков) в папке с программой,
    //отвечает за чтение и запись данного файла
    public class PlayersList {

      private ArrayList<Player> players; // рейтинг игроков

      public PlayersList(){
            deserialize();
      }

      public ArrayList<Player> getPlayers() {
            return players;
        }

      //Метод, который добавляет игрока , сортирует рейтинг игроков по количеству потраченных ходов, сохраняет players в txt
      public void addPlayers(Player player) {
             players.add(player);

             Collections.sort(players, new Comparator<Player>() {
                 public int compare(Player p1, Player p2) {
                    return p1.getLvls_Sum() - p2.getLvls_Sum(); // Ascending
                }
             });

             serialize();
        }

      public void deletePlayer (int i){
            players.remove(i);
            serialize();
        }

      public void deserialize() {

            try {

                File file = new File("PlayersList.txt");
            /*
               Если файл не создан, то создаем его

               If the file is not created, then create it
            */

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileInputStream fis = new FileInputStream(file.getAbsoluteFile());
                ObjectInputStream ois = new ObjectInputStream(fis);

                try {

                    players = (ArrayList<Player>) ois.readObject();

                } catch (ClassNotFoundException ex) {
                    players = new ArrayList<Player>();
                }
                ois.close();

            } catch (IOException e) {
                players = new ArrayList<Player>();
            }
        }

      private void serialize() {

            try {

                File file = new File("PlayersList.txt");

                if (!file.exists()) {

                    file.createNewFile();
                }

                FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(players);
                oos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

      //Метод, который выводит на консоль players в виде таблицы
      public void showPlayersTable(){
            TableBuilder tb = new TableBuilder();
            tb.addRow("Место","Имя игрока", "Уровень 1", "Уровень 2", "Уровень 3", "Всего ходов");

            for(Player e : players) {

                String name = e.getName();
                int lvl_1 = e.getLvl_1();
                int lvl_2 = e.getLvl_2();
                int lvl_3 = e.getLvl_3();
                int lvls_Sum = e.getLvls_Sum();

                tb.addRow( ""+(players.indexOf(e)+1),name,""+ lvl_1,""+ lvl_2,""+lvl_3,""+ lvls_Sum);
            }
            System.out.println(tb.toString());
        }
    }

