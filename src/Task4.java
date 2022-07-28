import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        int attackedPlanetsCount = 0;
        List<String> destroyedPlanets = new ArrayList<>();
        int destroyedPlanetsCount = 0;
        String message;
        for (int i = 0; i < n; i++) {
            int count = 0;
            message = scanner.nextLine();
            for (int j = 0; j < message.length(); j++) {
                if(message.charAt(j) == 'S' || message.charAt(j) == 'T' || message.charAt(j) == 'A' || message.charAt(j) == 'R' ||
                        message.charAt(j) == 's' || message.charAt(j) == 't' || message.charAt(j) == 'a' || message.charAt(j) == 'r')
                    count++;
            }
            String decryptedMessage = "";
            for (int j = 0; j < message.length(); j++) {
                char temp = (char) (message.charAt(j) - count);
                decryptedMessage = decryptedMessage.concat(String.valueOf(temp));
            }

            Pattern pattern = Pattern.compile("[^@\\-!:>]*@(?<name>[A-z]*)[^@\\-!:>]*:*(?<population>\\d*)[^@\\-!:>]*!(?<type>[AD])![^@\\-!:>]*->*(?<soldiers>\\d*)");
            Matcher matcher = pattern.matcher(decryptedMessage);
            if(matcher.find()){
                if(matcher.group("type").equals("A")){
                    attackedPlanetsCount++;
                    attackedPlanets.add(matcher.group("name"));
                }else if(matcher.group("type").equals("D")){
                    destroyedPlanetsCount++;
                    destroyedPlanets.add(matcher.group("name"));
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.println("Attacked planets: " + attackedPlanetsCount);
        for(String planet : attackedPlanets){
            System.out.println("-> " + planet);
        }
        System.out.println("Destroyed planets: " + destroyedPlanetsCount);
        for(String planet : destroyedPlanets){
            System.out.println("-> " + planet);
        }
    }
}
