import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        double p;
        double r;
        double square;

        Scanner scanner = new Scanner(System.in);
        String form = scanner.next();

        switch (form) {
            case "triangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();
                p = (a + b + c) / 2;
                square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println(square);
                break;
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                square = a * b;
                System.out.println(square);
                break;
            case "circle":
                r = scanner.nextDouble();
                square = 3.14 * r * r;
                System.out.println(square);
                break;
            default:
                System.out.println("Unknown form");
                break;
        }
    }
}
