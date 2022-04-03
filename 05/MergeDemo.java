//MergeDemo.java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class MergeDemo {

    public static void main(String[] args) {

        String idFile = "100";
        int numFiles = 3;

        try {
            mergeCsvFiles(idFile, numFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void mergeCsvFiles(String idFile, int numFiles) throws IOException {

        ArrayList<File> files = new ArrayList<File>();
        Iterator<File> iterFiles;
        File fileOutput;
        BufferedWriter fileWriter;
        BufferedReader fileReader;
        String csvFile;
        String csvFinal = "./output/merged.csv";
        String[] headers = null;
        String header = null;

        // Files: Input
        for (int i = 1; i <= numFiles; i++) {
            csvFile = "./csvfiles/cities" +  "_"  + i  + ".csv";
            System.out.println("Merging "+ csvFile + " into merged.csv");
            files.add(new File(csvFile));
        }

        // Files: Output
        fileOutput = new File(csvFinal);
        if (fileOutput.exists()) {
            fileOutput.delete();
        }
        try {
            fileOutput.createNewFile();
            
        } catch (IOException e) {
            
        }

        iterFiles = files.iterator();
        fileWriter = new BufferedWriter(new FileWriter(csvFinal, true));

        // Headers
        Scanner scanner = new Scanner(files.get(0));
        if (scanner.hasNextLine())
            header = scanner.nextLine();
        
        scanner.close();

        fileWriter.write(header);
        fileWriter.newLine();

        while (iterFiles.hasNext()) {

            String line;// = null;
            String[] firstLine;// = null;

            File nextFile = iterFiles.next();
            fileReader = new BufferedReader(new FileReader(nextFile));

            if ((line = fileReader.readLine()) != null)
                firstLine = line.split(";");

            while ((line = fileReader.readLine()) != null) {
                fileWriter.write(line);
                fileWriter.newLine();
            }
            fileReader.close();
        }

        fileWriter.close();

    }

}