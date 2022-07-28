import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String string = scanner.nextLine();
         Pattern pattern = Pattern.compile("[a-z\\d][a-z-_.\\d]*@([a-z][a-z-]*\\.)+([a-z][-a-z]*[a-z])");
         Matcher matcher = pattern.matcher(string);
         while (matcher.find()){
             System.out.println(matcher.group());
         }
     }
}
