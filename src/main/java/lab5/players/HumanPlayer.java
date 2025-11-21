package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.ui.Console;

/**
 * A human player that selects moves using console input.
 * Modern Java style (var, clean structure, concise comments).
 */
public final class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        while (true) {
            var move = Console.promptForPosition(getName() + " pick your next move: ");

            if (currentBoard.isEmptyAt(move)) {
                return move;
            }

            Console.printAlert("That position is already taken.");
        }
    }
}
