<<<<<<< HEAD

=======
>>>>>>> da4a7dfa5ea6115ffad84bafaf75e0f0c477345b
void main() {
    var scanner = new Scanner(System.in);
    List<Integer> numbers = new ArrayList<>();

    try {
<<<<<<< HEAD
        IO.print("How many numbers do you want to enter? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
          IO.print("Enter a number: ");
=======
        IO.println("How many numbers do you want to enter? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            IO.println("Please enter a number: ");
>>>>>>> da4a7dfa5ea6115ffad84bafaf75e0f0c477345b
            int num = Integer.parseInt(scanner.nextLine());

            if (num < 0) {
                IO.println("Negative number entered, skipping.");
                continue;
            }

            numbers.add(num);
        }

<<<<<<< HEAD

=======
>>>>>>> da4a7dfa5ea6115ffad84bafaf75e0f0c477345b
        try (var writer = new FileWriter("output.txt")) {
            for (int n : numbers) {
                int result = square(n);
                IO.println("Square of " + n + " is " + result);
                writer.write("Square of " + n + " is " + result + "\n");
            }
        }

        IO.println("Done! Check output.txt");

    } catch (Exception e) {
        IO.println("An error occurred: " + e.getMessage());
    }

    scanner.close();
}

<<<<<<< HEAD
int square(int number) {
    return number * number;
}
=======
/* Calculates the square of a number. */

int square(int number) {
    return number * number;
}

>>>>>>> da4a7dfa5ea6115ffad84bafaf75e0f0c477345b
