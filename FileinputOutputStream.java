import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileinputOutputStream {
    public static void main(String[] args) {
        String inputFile = "Inputfile.txt";   
        String outputFile = "Outputfile.txt"; 

        try {
            
            FileInputStream inputStream = new FileInputStream(inputFile);

            FileOutputStream outputStream = new FileOutputStream(outputFile);

            int bytesRead;
            byte[] buffer = new byte[4096]; 

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.err.println("File copy failed. Error: " + e.getMessage());
        }
    }
}
