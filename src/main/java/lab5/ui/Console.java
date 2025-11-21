package lab5.ui;

import com.diogonunes.jcolor.AnsiFormat;

import lab5.game.Board;
import lab5.game.PlayerToken;
import lab5.game.Position;
import lab5.game.Row;
import lab5.game.Col;

import lab5.players.Player;
import lab5.players.HumanPlayer;
import lab5.players.LinusPlayer;
import lab5.players.OmolaPlayer;

import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

/**
 * Console utility class for input/output operations used by the TicTacToe game.
 */
public class Console {

    // Fancy colors for prompts and alerts
    private static final AnsiFormat fPrompt = new AnsiFormat(GREEN_TEXT(), BOLD());
    private static final AnsiFormat fAlert = new AnsiFormat(YELLOW_TEXT());

    public static void println(String message) {
        System.out.println(message);
    }

    /** Generic string prompt */
    public static String prompt(String promptMessage) {
        System.out.print(fPrompt.format(promptMessage));
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /** Print alert messages in yellow */
    public static void printAlert(String message) {
        System.out.println(fAlert.format(message));
    }

    /**
     * Choose a player for the given token.
     * Human players: enter a name (e.g., "Alice")
     * Computer players: use commands "@linus" or "@omola"
     */
    public static Player promptForPlayer(PlayerToken whichPlayer) {

        while (true) {
            String input = prompt("Who will play " + whichPlayer + "? ");

            // Computer players begin with "@"
            if (input.startsWith("@")) {
                input = input.substring(1).toLowerCase();

                switch (input) {

                    case "linus":
                        return new LinusPlayer();

                    case "omola":
                        return new OmolaPlayer();

                    default:
                        printAlert("Unknown computer player: @" + input);
                        printAlert("Available: @linus, @omola");
                        break;
                }
            }
            else {
                // Human player
                return new HumanPlayer(input);
            }
        }
    }

    /** Display board with colored X and O */
    public static void showBoard(Board board) {
        StringBuilder sb = new StringBuilder();

        for (char c : board.toString().toCharArray()) {
            if (c == 'X') {
                sb.append(colorize("X", BRIGHT_CYAN_TEXT()));
            } else if (c == 'O') {
                sb.append(colorize("O", BRIGHT_MAGENTA_TEXT()));
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }

    /**
     * Prompt the user for a valid board position.
     * Accepts input like:
     *  "1 3" or "t m" (top middle)
     */
    public static Position promptForPosition(String prompt) {

        final String helpMessage =
                "Input must be 'row col', e.g. '1 2' or 't m'.";

        while (true) {
            String input = prompt(prompt);

            if (input.length() != 3) {
                printAlert(helpMessage);
                continue;
            }

            String[] parts = input.split(" ");

            if (parts.length != 2) {
                printAlert(helpMessage);
                continue;
            }

            try {
                return new Position(Row.from(parts[0]), Col.from(parts[1]));
            }
            catch (IllegalArgumentException e) {
                printAlert(helpMessage);
            }
        }
    }
}
