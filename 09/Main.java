
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.YearMonth;  
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;;


class Main{
  public static void main(String args[]) throws IOException{
    Path filePath = Paths.get("records.txt");

    List<String> salesRecords = Files.readAllLines(filePath);
    List<Sale> Sales = new ArrayList<Sale>();

     for(String saleRecord : salesRecords){
       Sales.add(new Sale(saleRecord));
     }

     // Now we have all the data in Sales List.


      // Product Name, Count;
     HashMap<String, Integer> hsProducts = new HashMap<String, Integer>();
     HashMap<String, Integer> hsSalesman = new HashMap<String, Integer>();
     HashMap<YearMonth, Integer> totalSale = new HashMap<YearMonth, Integer>();


    // Find Records of this Year and month
    YearMonth yearMonth = YearMonth.of(2021, 11);
    int salesWorthInTheMonth = 0;

     for(Sale sale : Sales){
       Sale highestSellingProduct,highestSellingSalesman;
       if(hsProducts.containsKey(sale.product)){
         int currentCount = hsProducts.get(sale.product);
         currentCount++;
         hsProducts.put(sale.product,currentCount);
       }else{
         hsProducts.put(sale.product,1);
       }

       if(hsSalesman.containsKey(sale.salesman)){
         int currentCount = hsSalesman.get(sale.salesman);
         currentCount++;
         hsSalesman.put(sale.salesman,currentCount);
       }else{
         hsSalesman.put(sale.salesman,1);
       }

      
       if(YearMonth.from(sale.date).equals(yearMonth)){
          if(totalSale.containsKey(yearMonth)){
            int currentCount = totalSale.get(yearMonth);
            currentCount++;
            totalSale.put(yearMonth,currentCount);
            salesWorthInTheMonth += Integer.parseInt(sale.amount);
          }else{
            totalSale.put(yearMonth,1);
            salesWorthInTheMonth += Integer.parseInt(sale.amount);
          }
       }
      
     }



    String highestSellingProduct = Collections.max(hsProducts.entrySet(), Map.Entry.comparingByValue()).getKey();
    String highestSellingSalesman = Collections.max(hsSalesman.entrySet(), Map.Entry.comparingByValue()).getKey();
    YearMonth totalSaleKey = Collections.max(totalSale.entrySet(), Map.Entry.comparingByValue()).getKey();
    System.out.println("Total Sales:\n" + hsProducts.toString());
    System.out.println("Highest Selling Product: "+ highestSellingProduct + " with total " + hsProducts.get(highestSellingProduct) + " sales.");
    System.out.println("Highest Selling Salesman: "+ highestSellingSalesman + " with total " + hsSalesman.get(highestSellingSalesman) + " sales.");
    System.out.println("Total Sales in "+ yearMonth.getMonth() + "-" + yearMonth.getYear()  + ": "+ totalSale.get(totalSaleKey) + " (Amount: " + salesWorthInTheMonth+")");

  }
}


class Sale {
  String salesman, product, amount;
  LocalDate date;
  
  Sale(String record) {
    String[] records = record.split("<>");
     this.salesman = records[0];
     this.product = records[1];
     this.amount = records[2];
   
         
     this.date = LocalDate.parse(records[3]);

   
     
      //Parsing the given String to Date object
  }

  public String toString() { 
    return "Salesman: '" + this.salesman + "', Product: '" + this.product + "', Amount: '" + this.amount + "'" + "', Date: '" + this.date + "'";
} 
}


