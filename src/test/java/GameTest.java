import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Johny", 10);
    Player player2 = new Player(2, "Billy", 15);

    Game game = new Game();

    @BeforeEach

    public void setup() {

        game.register(player1);
        game.register(player2);
    }


    @Test

    public void notRegisteredExceptionTest() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Johny", "Danny");
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Danny", "Billy");
        });
    }

    @Test

    public void gameWinnerTest() {

        Player player3 = new Player(3, "Danny", 15);
        game.register(player3);

        Assertions.assertEquals(1, game.round("Billy", "Johny"));
        Assertions.assertEquals(2, game.round("Johny", "Billy"));
        Assertions.assertEquals(0, game.round("Danny", "Billy"));

    }


}
