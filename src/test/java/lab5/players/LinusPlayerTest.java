package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.game.Row;
import lab5.game.Col;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinusPlayerTest {

    @Test
    public void testLinusChoosesFirstEmptyCellOnEmptyBoard() {
        LinusPlayer linus = new LinusPlayer();
        Board board = new Board();

        Position choice = linus.pickNextMove(board);

        assertEquals(new Position(Row.Top, Col.Left), choice);
    }

    @Test
    public void testLinusSkipsFilledCell() {
        // X occupies top-left
        Board board = new Board("X..\n...\n...\n");
        LinusPlayer linus = new LinusPlayer();

        Position choice = linus.pickNextMove(board);

        // Next empty cell is Top-Middle
        assertEquals(new Position(Row.Top, Col.Middle), choice);
    }
}
