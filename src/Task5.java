import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> demons = Arrays.stream(scanner.nextLine().split("\\s*,\\s*")).collect(Collectors.toList());
        for (String name : demons) {
            int health = 0;
            double damage = 0.0;
            Pattern namePattern = Pattern.compile("[^\\d.+\\-*/]");
            Matcher nameMatcher = namePattern.matcher(name);
            while (nameMatcher.find()) {
                char temp = nameMatcher.group().charAt(0);
                health += temp;
            }
            Pattern damagePattern = Pattern.compile("(-\\d+\\.\\d+)+|(-\\d+)|(\\d+\\.\\d+)|(\\d+)");
            Matcher damageMatcher = damagePattern.matcher(name);
            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
            }
            //Pattern calculationPattern = Pattern.compile("[*|/]");
            //Matcher calculationMatcher = calculationPattern.matcher(name);
            for (char symbol : name.toCharArray()) {
                if(symbol == '/'){
                    damage /= 2;
                }else if (symbol == '*'){
                    damage *= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n",name,health,damage);
        }
    }
}
