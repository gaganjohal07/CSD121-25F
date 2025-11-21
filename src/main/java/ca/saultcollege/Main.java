package ca.saultcollege;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("""

        Welcome to Tic-Tac-Toe!


Player selection options:
 - Type a NAME to create a Human player
   (e.g., Alice, Bob, John)

 - Use @linus  for a simple computer player
 - Use @omola  for an advanced look-ahead player

Example:
 Who will play X? Alice
 Who will play O? @omola
""");
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}