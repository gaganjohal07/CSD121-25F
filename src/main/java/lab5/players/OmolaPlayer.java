package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.game.PlayerToken;

import java.util.List;

/**
 * Omola: One-Move Look-Ahead player.
 * Strategy:
 *   1. If Omola can win in one move → play the winning move.
 *   2. Else if opponent can win next move → block it.
 *   3. Else → pick the first empty position.
 */
public class OmolaPlayer extends Player {

    public OmolaPlayer() {
        super("Omola");
    }

    @Override
    public Position pickNextMove(Board currentBoard) {

        List<Position> empty = currentBoard.getEmptyCells();
        PlayerToken myToken = currentBoard.getNextTurnToken();
        PlayerToken opponent = (myToken == PlayerToken.X ? PlayerToken.O : PlayerToken.X);

        // ---------------------------------------------------
        // 1. Check if Omola can win in one move
        // ---------------------------------------------------
        for (Position p : empty) {
            Board copy = new Board(currentBoard);
            copy.place(p, myToken);

            if (copy.getWinner() == myToken) {
                return p;
            }
        }

        // ---------------------------------------------------
        // 2. Block opponent’s winning move
        // ---------------------------------------------------
        for (Position p : empty) {
            Board copy = new Board(currentBoard);
            copy.place(p, opponent);

            if (copy.getWinner() == opponent) {
                return p;
            }
        }

        // ---------------------------------------------------
        // 3. Otherwise pick first empty cell
        // ---------------------------------------------------
        return empty.get(0);
    }
}
