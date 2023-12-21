import java.util.StringTokenizer;
import java.util.Scanner;

public class  StringTokeni{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a line of integers separated by spaces: ");
        String inputLine = scanner.nextLine();

        scanner.close();
        
        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        int sum = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            
            try {
                
                int number = Integer.parseInt(token);

                System.out.println("Integer: " + number);

                sum += number;
            } catch (NumberFormatException e) {
                
                System.out.println("Invalid integer: " + token);
            }
        }

        System.out.println("Sum of all integers: " + sum);
    }
}
