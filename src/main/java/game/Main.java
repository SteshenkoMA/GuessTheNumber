package game;

/**
 * Created by SteshenkoMA on 23.03.16.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Игра: Угадай число");

        PlayersList playersList = new PlayersList();
        Player player = new Player();
        Game newGame = new Game();

        while (newGame.getGameOn() == true) {
            newGame.play(player);
        }

        System.out.println("Игра пройдена. Потрачено ходов: " + player.getLvls_Sum());

        System.out.println("Введите имя игрока:");

        player.setName();                 //Вводим имя игрока
        playersList.addPlayers(player);   //Добавляем игрока в список с рейтингом всех игроков

        System.out.println("Рейтинг игроков:");

        playersList.showPlayersTable();   //Выводим таблицу рейтинга игроков на консоль

    }

}
