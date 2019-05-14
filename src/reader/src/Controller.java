import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.*;
import java.util.Scanner;

public class Controller {
   // public static final String FILE_PATH = "readers.txt";
    public static final String CHARSET = "UTF-8";
    File FILE_TO_WRITE_TO = new File("/home/pyrax/Documents/reader/kepler.txt") ;
    File file = new File("/home/pyrax/Documents/reader/src/reader.txt");

    List<Person> personList = new ArrayList<>();

    public void start(){
        readFile();
        printFile();
        writeIntoFile();
    }

    private void printFile() {
        for (Person person: personList){
            System.out.println(person);
        }
    }
    private void readFile() {

        try(Scanner scanner = new Scanner(file ,CHARSET)) {


            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (!line.isEmpty()){
                    String[] data = line.split("-");
                    String firstName = data[0].trim();
                    String lastName = data[1].trim();

                    Person person;
                    person = new Person(firstName, lastName);
                    personList.add(person);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void writeIntoFile() {


        try(FileWriter writer = new FileWriter(FILE_TO_WRITE_TO)) {
            for (Person person: personList){
                writer.write(person.toString()+"\n");

                writer.flush();

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

}
