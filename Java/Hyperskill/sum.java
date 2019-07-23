#Java Archive  -> The sum of elements
#Find the sum of all elements of a sequence, ending with the number 0.

#The number 0 itself is not included into the sequence and serves as a sign of cessation.


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int number;

        do {
            number = scanner.nextInt();
            sum += number;
        } while (number != 0);

        System.out.println(sum);
    }
}
