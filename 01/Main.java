// Java program to demonstrate difference between
// String, StringBuilder and StringBuffer
 
// Main class
class Main {
 
    // Method 1
    // Concatenates to String
    public static void concat1(String s1)
    {
        s1 = s1 + " Chakraborty";
    }
 
    // Method 2
    // Concatenates to StringBuilder
    public static void concat2(StringBuilder s2)
    {
        s2.append(" Chakraborty");
    }
 
    // Method 3
    // Concatenates to StringBuffer
    public static void concat3(StringBuffer s3)
    {
        s3.append(" Chakraborty");
    }
 
    // Method 4
    // Main driver method
    public static void main(String[] args)
    {
        // Custom input string
        // String 1
        String s1 = "Adarsh";
 
        // Calling above defined method
        concat1(s1);
 
        // s1 is not changed
        System.out.println("String: " + s1 );
 
        // String 2
        StringBuilder s2 = new StringBuilder("Adarsh");
 
        // Calling above defined method
        concat2(s2);
 
        // s2 is changed
        System.out.println("StringBuilder: " + s2 );
 
        // String 3
        StringBuffer s3 = new StringBuffer("Adarsh");
 
        // Calling above defined method
        
        concat3(s3);
 
        // s3 is changed
        System.out.println("StringBuffer: " + s3 );



        System.out.println("\n Now, Checking time comparision, appending x1000 times.\n");
        long startTime1 = System.currentTimeMillis();
           for (int i=0; i<10000; i++){  
            concat1(s1);
        }  
         System.out.println("Time taken by String Class: " + (System.currentTimeMillis() - startTime1) + "ms"); 
        long startTime2 = System.currentTimeMillis(); 
          for (int i=0; i<10000; i++){  
            concat2(s2);
        }  
         System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime2) + "ms"); 
        long startTime3 = System.currentTimeMillis();  
        for (int i=0; i<10000; i++){  
            concat3(s3);
        } 
         System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime3) + "ms"); 


    }
}