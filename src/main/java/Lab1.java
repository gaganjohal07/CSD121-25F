void main() {
    var scanner = new Scanner(System.in);
    List<Integer> numbers = new ArrayList<>();

    try {
        IO.println("How many numbers do you want to enter? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
           IO.println("Please enter a number: ");
            int num = Integer.parseInt(scanner.nextLine());

            if (num < 0) {
                IO.println("Negative number entered, skipping.");
                continue;
            }

            numbers.add(num);
        }

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

/* Calculates the square of a number. */

int square(int number) {
    return number * number;
}
