import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        String[] str = scan.nextLine().split("\\s");
        String str1 = str[0].toString();
        char str2 = str[1].toString().charAt(0);
        int count = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == str2){
                count++;
            }
        }
        System.out.println(count);
    }
}
