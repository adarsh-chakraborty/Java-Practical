import java.io.IOException;
import java.util.Scanner;
import java.nio.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;


class Main {
  public static HashMap<Integer,String> inputHistroy = new HashMap<Integer,String>();

  public static void main(String args[]) throws IOException{
    Path newFilePath = Paths.get("names.txt");
    Scanner sc = new Scanner(System.in);
    int N = 5;

    System.out.println("How many names you want to Enter?: [Integer]");
     try {
         N = sc.nextInt();
      }catch(Exception e){
        System.out.println("Error: Integer was expected: [1-3]");
      }


    
    
    Files.deleteIfExists(newFilePath);
    Files.createFile(newFilePath);


    System.out.println("Enter "+ N + " names:");

    for(int i=0;i<=N;i++){
      String input = sc.nextLine();
      inputHistroy.put(i,input);
      Files.writeString(newFilePath, input+"\n", StandardOpenOption.APPEND);
    }


    showSelection();
    }


    static void showSelection(){
    Scanner sc = new Scanner(System.in);
    int selection = 0;
      System.out.println("\n\nEnter selection:\n1.Search Name by Key.\n2.Find and Replace name.\n3.Remove dublicates names from file.");
       try {
        selection = sc.nextInt();
      }catch(Exception e){
        System.out.println("Error: Integer was expected: [1-3]");
      }

       switch (selection){
        case 1:
        searchName();
        break;
        case 2:
        findAndReplace();
        break;
        case 3:
        removeDublicateNames();
        break;
        default:
        System.out.println("Invalid selection, Enter [1-3]:");
        showSelection();
    }
    }



    static void searchName() {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter key to search:");
      int selection = 0;
      try {
         selection = sc.nextInt();
      }catch(Exception e){
        System.out.println("Error: Integer was expected:");
      }

      String result = inputHistroy.get(selection);
      if(result == null){
          System.out.println("No name found with that Key."); 
      }else{

      System.out.println("\nSearch result: " + result);
      }
      
      System.out.println("Press enter to go back to main menu...");
      try{
        System.in.read();
      }catch(IOException e){
        e.printStackTrace();
      }
      showSelection();
    }

    static void findAndReplace(){
      try{

          Scanner sc = new Scanner(System.in);
          System.out.println("\n|| Find and Replace ||\nEnter the name to find:");
          String findName = sc.nextLine();
          System.out.println("Enter names to replace with:");
          String replaceName = sc.nextLine();

        

          Path filePath = Paths.get("names.txt");
        
          List<String> lines = Files.readAllLines(filePath);

          int index = 0;
          int changes = 0;
            for(String name : lines){
              if(name.toLowerCase().equals(findName.toLowerCase())){
                System.out.println(name);
                lines.set(index, replaceName);
                changes++;
              }
              index++;
            }
            
          Files.write(filePath, lines, Charset.forName("UTF-8"));
          System.out.println("Task completed. "+ changes + " names were replaced.");
          System.out.println("Press enter to go back to main menu...");

           try{
              System.in.read();
            }catch(IOException e){
              e.printStackTrace();
            }
            showSelection();

      }catch(Exception e){

      }
    



    }

    static void removeDublicateNames(){
      try{
          System.out.println("Removing all dublicate names from the records, Please wait...");
          Path filePath = Paths.get("names.txt");
        
          List<String> names = Files.readAllLines(filePath);
          Set<String> uniqueNames = new HashSet<String>();

           for (String name : names)
            uniqueNames.add(name);


            Files.write(filePath, uniqueNames, Charset.forName("UTF-8"));

            System.out.println("Task completed. Press enter to go back to menu...");
          
              System.in.read();
        }catch(IOException e){
          e.printStackTrace();
        }
            showSelection();



    }




    
}


 