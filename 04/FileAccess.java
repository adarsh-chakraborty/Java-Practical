import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Scanner;

class FileRead {
   String fileName;

   FileRead(String f){
    this.fileName = f;
  }

    void readLine(int n) {
      String line;
      try  {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
          for (int i = 0; i < n; i++)
              br.readLine();
          line = br.readLine();
          System.out.println(line);
      }
      catch(IOException e){
        System.out.println(e);
      }
    }

    void readUntill(int n) {
      String line;
      try  {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
          for (int i = 0; i < n; i++){
              
            line = br.readLine();
             System.out.println(line);

          }
      }
      catch(IOException e){
        System.out.println(e);
      }
    }
}

class FileWrite {
  File file;


  FileWrite(String fname){
    file = new File(fname);
  }


 void writetoFile(String content, int position){
    // No overwrite
    // Read entire file
    // Put somethings at a specific position
    // Put the data back in the file
    try{
      String fName = file.getName();
      StringBuilder fileContent =  new StringBuilder(Files.readString(Paths.get(fName)));
      fileContent.insert(position, content);
      Files.write( Paths.get(fName), fileContent.toString().getBytes());
      
     
    }
    catch(IOException e){
      System.out.println(e);
    }
  }


  void writetoFile(String content, int position, Boolean overwrite){
    
    String fName = file.getName();
    try{
     if(overwrite == true){
        // file, appendMode?
        Files.write( Paths.get(fName), content.getBytes());
     }else{
        StringBuilder fileContent =  new StringBuilder(Files.readString(Paths.get(fName)));
        fileContent.insert(position, content);
        Files.write( Paths.get(fName), fileContent.toString().getBytes());
     }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }

}

class FileCopy{
  File src;

  FileCopy(String f){
    this.src = new File(f);
  }

  void copyTo(String fileName){

    try{
     File dest = new File(fileName);
             
    // using copy(InputStream,Path Target); method
    Files.deleteIfExists(dest.toPath());
    Files.copy(src.toPath(), dest.toPath());
    }catch(Exception e){
        System.out.println(e);
    }
  }
}

class FileAccess {
  public static void main(String args[]){
    
    // Read a portion of file.
    FileRead file = new FileRead("input.txt");
    // Pass line number to read.
    file.readUntill(3);
    file.readLine(4);

    // Write to a file at specific position.
    FileWrite file2 = new FileWrite("FileOverwrite.txt");
    
    // Content, LineNumber (Position), Overwrite? (optional)
    file2.writetoFile("Hello, This file was overwritten.", 0, true );
    file2.writetoFile("Hello......", 4);

    FileCopy file3 = new FileCopy("input.txt");
    file3.copyTo("output.txt");
    }
  }




