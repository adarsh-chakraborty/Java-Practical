import java.util.Scanner;
import java.nio.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

class Main {
  public static void main(String args[]) throws IOException{
    Scanner sc = new Scanner(System.in);
    HashMap<String,String> inputHistroy = new HashMap<String,String>();

    System.out.println("Hint: type exit to exit anytime.");
    System.out.println("Enter file name:");
    String fileName = sc.nextLine();
    Path newFilePath = Paths.get(fileName + ".txt");
    Files.deleteIfExists(newFilePath);
    Files.createFile(newFilePath);


    System.out.println("Enter Data for the file: (Type exit to exit anytime).");

    while(true){

      String input = sc.nextLine();
      if(input.equals("exit")) break;
      if(inputHistroy.containsKey(input.toLowerCase())){
        System.out.println("Only Non-redundant lines allowed.");
        continue;
      }
      inputHistroy.put(input.toLowerCase(),input);
      Files.writeString(newFilePath, input+"\n", StandardOpenOption.APPEND);
    }
    
  }
}

 