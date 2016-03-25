import game.Player;
import game.PlayersList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by BigMax on 24.03.16.
 */
public class PlayersListTest {
    Random rnd;
    Player player_1;

    @Before
    public void prepare(){

        player_1 = new Player("noname",0,0,0);

    }

    //После выполнения теста, удаляем игрока player_1 из txt файла

    @After
    public void undo(){

        PlayersList playersList_3 = new PlayersList();
        playersList_3.deletePlayer(0);

        System.out.println("Тест завершен");
        playersList_3.showPlayersTable();
    }

    //1)Добавляем нового игрока в массив с рейтингом игроков
    //2)Сохраняем рейтинг игроков в txt
    //3)Создаем новый обьект playersList_2
    //4)И проверяем, что элементы по номеру 0 в массиве рейтинг игроков являются эквивалентными
    //5)Также проверяем что рейтинги игроков из playersList_1 и playersList_2 равны

    @Test
    public void testAdd_Write_Read() {

        PlayersList playersList_1 = new PlayersList();
        playersList_1.addPlayers(player_1);

        PlayersList playersList_2 = new PlayersList();
        Player player_2 = playersList_2.getPlayers().get(0);

        System.out.println("Тест");

        System.out.println("playersList_1 : " + "player_1 = ["+player_1.toString()+"]");
        playersList_1.showPlayersTable();
        System.out.println("playersList_2 : " + "player_2 = ["+player_2.toString()+"]");
        playersList_2.showPlayersTable();

        assertEquals("player_1 = player_2",player_1.toString(),player_2.toString());
        assertEquals("playersList_1.players = playersList_2.players",playersList_1.getPlayers().toString(),playersList_2.getPlayers().toString());
        assertEquals("playersList_1.players.size = playersList_2.players.size)",playersList_1.getPlayers().size(),playersList_2.getPlayers().size());

    }
}
