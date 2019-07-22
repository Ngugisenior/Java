#Write a program that reads a string and then output another string with doubled characters.
#Sample Input 1:
#The
#Sample Output 1:
#TThhee

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.substring(i, i + 1) + str.substring(i, i + 1));
        }
    }
}
