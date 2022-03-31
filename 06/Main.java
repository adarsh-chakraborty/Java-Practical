import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.Charset;

class Main {
 public static void main (String args []) throws IOException{

    String[] findAndRemoveCity = {"Mumbai", "Delhi", "Navi Mumbai", "Bangalore", "Ahmedabad"};    

    Path filePath = Paths.get("data.txt");
    
     List<String> lines = Files.readAllLines(filePath);

        for(String city : findAndRemoveCity){
           // Check for substring here
          lines.remove(city);
        }
        
    Files.write(filePath, lines, Charset.forName("UTF-8"));
        
        
 }
}