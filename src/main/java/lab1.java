void main() {
    var scanner = new Scanner(System.in);
    var numbers = new ArrayList<Integer>();
    j
    try {
       IO.print("How many numbers do you want to enter? ");
        var count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            IO.print("Enter a number: ");
            var input = scanner.nextLine();
            var num = Integer.parseInt(input);

            if (num < 0) {
               IO.println("Negative number entered, skipping.");
                continue;
            }

            numbers.add(num);
        }

        try (var writer = new FileWriter("output.txt")) {
            for (var n : numbers) {
                var result = square(n);
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

int square(int number) {
    return number * number;
}

