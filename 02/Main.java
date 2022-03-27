class Main {


   public static void main(String[] args) {

  String s1 = "  Adarsh Chakraborty  ";
  // 1. trim - Removes whitespaces
  System.out.println("1. trim() Method:" +s1.trim());
  
  // 2. toUpperCase 
  System.out.println("2. Uppercased: " + s1.toUpperCase());

  // 3. toLowerCase
  System.out.println("3. Lowercased: "+ s1.toLowerCase());

  // 4. isEmpty
  System.out.println("4. Is String Empty?: "+ s1.isEmpty());

  // 5. length
  System.out.println("5. Length of s1 string: "+ s1.length());

  StringBuilder s2 = new StringBuilder("Adarsh Chakraborty");

  // 6. append()
  s2.append(" MCA-1");
  System.out.println("6. after append: "+ s2);

  // 7. insert
  s2.insert(s2.length(), " 2021-22");
  System.out.println("7. after insert: "+ s2);

  // 8. replace
  s2.replace(0, s2.length(), "Adarsh Chakraborty");
  System.out.println("8. Replaced whole string: " + s2);

  // 9. delete
  s2.delete(0, 6);
  System.out.println("9. Deleted from [0 - 6] index: " + s2);

  // 10. reverse
   s2.reverse();
  System.out.println("10. Reversed String: " + s2);


  StringBuffer s3 = new StringBuffer("Adarsh Chakraborty");
  // 11. capacity()
  System.out.println("11. Capacity of s3: " + s3.capacity());

  // 12. charAt()
  System.out.println("12. Char at Index 0: " + s3.charAt(0));

 // 13. indexOf()
  System.out.println("13. Index of 'Chak' in given string: " +s3.indexOf("Chak"));

  // 14. SubString
  String substr = s3.substring(0,6);
  System.out.println("14. Substring from index [0-6]: " + substr);

   // 15. deleteCharAt
  System.out.println("* String s3: " + s3);
  s3.deleteCharAt(0);
  System.out.println("15. Deleted char at index 0: " + s3);




}
}