import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        double total = 0;
        System.out.println("Bought furniture:");
        while(true){
            command = scanner.nextLine();
            if(command.equals("Purchase"))
                break;
            Pattern pattern = Pattern.compile(">*(?<item>[A-Z]+|[A-Z]+[a-z]*)<*(?<price>\\d*.\\d+)!(?<quantity>\\d*)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()){
                String name = matcher.group("item");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                total += price * quantity;
                System.out.println(name);
            }
        }
        System.out.printf("Total money spend: %.2f",total);
    }
}