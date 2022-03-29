import java.io.*;
import java.util.*;
  
public class FileAppend {
  
    // Main driver method
    public static void main(String[] args)
    {

      SharedResource resource = new SharedResource();
  
        ThreadA obj1 = new ThreadA(resource);
        ThreadB obj2 = new ThreadB(resource);
  
        // Starting the thread
        obj1.start();
        obj2.start();
        
    }
}

class ThreadA extends Thread{

 SharedResource resource;

 ThreadA(SharedResource resource){
  this.resource = resource;
 }

 @Override
 public void run() {

  try{
   synchronized (resource) {
 
    for (String quote : resource.list) {
      while(resource.flag !=1 ){
      resource.wait();
     }
     // File writer, append? true
      FileWriter fw = new FileWriter("quotes.txt",true);
      fw.write(quote + "\n");
      // need to close to save the changes for other thread!
      fw.close();

      resource.flag = 2;
      resource.notify();
    }


   }
  }catch (Exception e) {
   System.out.println("Exception 1 :"+e.getMessage());
  }

 }

}


class ThreadB extends Thread{

 SharedResource resource;

 ThreadB(SharedResource resource){
  this.resource = resource;
 }

 @Override
 public void run() {

  try{
   synchronized (resource) {


    for (int i = 0; i< resource.list.size(); i++) {


     while(resource.flag != 2){
      resource.wait();
     }
      
      String line;
      try  {
        BufferedReader br = new BufferedReader(new FileReader("quotes.txt"));
          for (int j= 0; j < i; j++)
              br.readLine();
              line = br.readLine();
              System.out.println(line);
      }
      catch(IOException e){
        System.out.println(e);
      }
    

      resource.flag = 1;
      resource.notifyAll();
     
    }

   
    

   }
  }catch (Exception e) {
   System.out.println("Exception 2 :"+e.getMessage());
  }

 }
}




class SharedResource{
 public volatile int flag = 1;
  public List <String> list = Collections.synchronizedList(
   new ArrayList<String>(
     (Arrays.asList(
      "The way to get started is to quit talking and begin doing. -Walt Disney",
      "Life is what happens when you're busy making other plans. -John Lennon",
      "It is during our darkest moments that we must focus to see the light. -Aristotle",
      "Whoever is happy will make others happy too. -Anne Frank",
      "I'm Iron-man - Iron man"
      )
   )));
}