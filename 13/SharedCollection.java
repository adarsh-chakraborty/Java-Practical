// Java program to Illustrate notify() method in Thread
// Synchronization.
  
// Importing required classes
import java.io.*;
import java.util.*;
  
// Class 1
// Thread1
// Helper class extending Thread class
public class SharedCollection {
  
    // Main driver method
    public static void main(String[] args)
    {

      SharedResource resource = new SharedResource();
  
        // Creating object(thread) of class 2
        ThreadA obj1 = new ThreadA(resource);
        ThreadB obj2 = new ThreadB(resource);

        System.out.println("\n* Removing all " + resource.list.size() + " Countries from the list...");
  
        // Starting the thread
        obj1.start();
        obj2.start();
        
    }
}
// Class 2
// Thread2
// Helper class extending Thread class
class ThreadA extends Thread{

 SharedResource resource;

 ThreadA(SharedResource resource){
  this.resource = resource;
 }

 @Override
 public void run() {

  try{
   synchronized (resource) {

    while (!resource.list.isEmpty()) {

     while(resource.flag !=1 ){
      resource.wait();
     }

    if(!resource.list.isEmpty()) {
       String item = resource.list.get(0);
       resource.list.remove(0);
       System.out.println("x - ThreadA removed "+ item + " ("+ resource.list.size() + " items remaining.)");

    }

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


    while (!resource.list.isEmpty()) {


     while(resource.flag != 2){
      resource.wait();
     }

      if(!resource.list.isEmpty()) {
       String item = resource.list.get(0);
       resource.list.remove(0);
       System.out.println("x - ThreadB removed "+ item + " ("+ resource.list.size() + " items remaining.)");
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
      "Afghanistan",
      "Australia",
      "Bulgaria",
      "China",
      "Denmark",
      "Egypt",
      "Finland",
      "France",
      "Germany",
      "Iceland",
      "India",
      "Indonesia",
      "Iraq",
      "Ireland",
      "Israel",
      "Italy",
      "Jamaica",
      "Japan",
      "Kazakhstan",
      "Kuwait",
      "Nauru",
      "Nepal",
      "Netherlands",
      "New Zealand",
      "Norway",
      "Pakistan",
      "Philippines",
      "Poland",
      "Portugal",
      "Qatar",
      "Romania",
      "Russia",
      "Saudi Arabia",
      "Serbia",
      "Singapore",
      "Spain",
      "Sri Lanka",
      "Switzerland",
      "Syria",
      "Tajikistan",
      "Tanzania",
      "Thailand",
      "Tunisia",
      "Turkey",
      "Uganda",
      "Ukraine",
      "United Kingdom",
      "Vietnam",
      "Yemen",
      "Zimbabwe"
      )
   )));
}