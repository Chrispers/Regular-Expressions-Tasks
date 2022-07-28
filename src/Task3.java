import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        double total = 0;
        while(true){
            command = scanner.nextLine();
            if(command.equals("end of shift"))
                break;
            Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$");
            Matcher matcher = pattern.matcher(command);
            if(matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                total += count * price;
                System.out.printf("%s: %s - %.2f%n", name, product, count * price);
            }
        }
        System.out.printf("Total income: %.2f", total);
    }
}
