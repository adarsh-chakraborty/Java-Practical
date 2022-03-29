// Java program to Illustrate notify() method in Thread
// Synchronization.
  
// Importing required classes
import java.io.*;
import java.util.*;
  
// Class 1
// Thread1
// Helper class extending Thread class
public class PrintNumbers {
  
    // Main driver method
    public static void main(String[] args)
    {

      ResourceLock lock = new ResourceLock();
  
        // Creating object(thread) of class 2
        ThreadA obj1 = new ThreadA(lock);
        ThreadB obj2 = new ThreadB(lock);
        ThreadC obj3 = new ThreadC(lock);
  
        // Starting the thread
        obj1.start();
        obj2.start();
        obj3.start();

        
  
        
    }
}
// Class 2
// Thread2
// Helper class extending Thread class
class ThreadA extends Thread{

 ResourceLock lock;

 ThreadA(ResourceLock lock){
  this.lock = lock;
 }

 @Override
 public void run() {

  try{
   synchronized (lock) {

    for (int i = 1; i <= 50; i++) {

     while(lock.flag !=1 ){
      lock.wait();
     }

     System.out.println("ThreadA prints "+ i);
      if(i == 10){
         lock.flag = 2;
         lock.notify();
      }
    }

   }
  }catch (Exception e) {
   System.out.println("Exception 1 :"+e.getMessage());
  }

 }

}


class ThreadB extends Thread{

 ResourceLock lock;

 ThreadB(ResourceLock lock){
  this.lock = lock;
 }

 @Override
 public void run() {

  try{
   synchronized (lock) {


    for (int i = 1; i <= 50; i++) {

     while(lock.flag != 2){
      lock.wait();
     }

     System.out.println("ThreadB prints 10."+ i);
     if(i == 20){
      lock.flag = 3;
      lock.notifyAll();
     }
    }

    lock.flag = 1;
    lock.notify();
   
    

   }
  }catch (Exception e) {
   System.out.println("Exception 2 :"+e.getMessage());
  }

 }
}

class ThreadC extends Thread{

 ResourceLock lock;

 ThreadC(ResourceLock lock){
  this.lock = lock;
 }

 @Override
 public void run() {

  try{
    
   synchronized (lock) {

    for (int i = 1; i <= 50; i++) {

     while(lock.flag != 3){
      lock.wait();
     }

     System.out.println("ThreadC prints 10.20."+ i);    
    }
    lock.flag = 2;
    lock.notify();


   }
  }catch (Exception e) {
   System.out.println("Exception 3 :"+e.getMessage());
  }

 }
}


class ResourceLock{
 public volatile int flag = 1;
}