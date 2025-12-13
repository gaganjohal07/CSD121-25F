package lab4.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Black-box unit tests for the Board class
 */
public class BoardTest {

    @Test
    void newBoard_isInProgressAndNotFull() {
        Board board = new Board();
        assertEquals(Board.Status.InProgress, board.getStatus());
        assertFalse(board.isFull());
    }

    @Test
    void placeX_marksPositionOccupied() {
        Board board = new Board();
        Position pos = new Position(Row.Top, Col.Left);
        board.placeX(pos);
        assertTrue(board.isOccupiedAt(pos));
    }

    @Test
    void placeO_marksPositionOccupied() {
        Board board = new Board();
        Position pos = new Position(Row.Middle, Col.Middle);
        board.placeO(pos);
        assertTrue(board.isOccupiedAt(pos));
    }

    @Test
    void xWinsByRow() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));
        assertEquals(Board.Status.XWins, board.getStatus());
    }

    @Test
    void oWinsByColumn() {
        Board board = new Board();
        board.placeO(new Position(Row.Top, Col.Middle));
        board.placeO(new Position(Row.Middle, Col.Middle));
        board.placeO(new Position(Row.Bottom, Col.Middle));
        assertEquals(Board.Status.OWins, board.getStatus());
    }

    @Test
    void xWinsByDiagonal_topLeftToBottomRight() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Bottom, Col.Right));
        assertEquals(Board.Status.XWins, board.getStatus());
    }

    @Test
    void oWinsByDiagonal_topRightToBottomLeft() {
        Board board = new Board();
        board.placeO(new Position(Row.Top, Col.Right));
        board.placeO(new Position(Row.Middle, Col.Middle));
        board.placeO(new Position(Row.Bottom, Col.Left));
        assertEquals(Board.Status.OWins, board.getStatus());
    }

    @Test
    void gameEndsInDrawWhenBoardIsFullAndNoWinner() {
        Board board = new Board();

        board.placeX(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));

        board.placeX(new Position(Row.Middle, Col.Left));
        board.placeO(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Middle, Col.Right));

        board.placeO(new Position(Row.Bottom, Col.Left));
        board.placeX(new Position(Row.Bottom, Col.Middle));
        board.placeO(new Position(Row.Bottom, Col.Right));

        assertEquals(Board.Status.Draw, board.getStatus());
        assertTrue(board.isFull());
    }
}
