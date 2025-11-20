package lab5.players;

import java.util.List;

import lab5.game.Board;
import lab5.game.Position;

/**
 * Linus: a simple computer player.
 * Always picks the first available position on the board,
 * scanning from top-left to bottom-right.
 */
public class LinusPlayer extends Player {

    public LinusPlayer() {
        super("Linus");
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        // Get all empty positions on the board
        List<Position> emptyPositions = currentBoard.getEmptyCells();

        // Linus always chooses the first empty spot
        return emptyPositions.get(0);
    }
}
