import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = List.of(scanner.nextLine().split(", "));
        Map<String, Integer> participants = new LinkedHashMap<>();
        String command;
        while (true) {
            command = scanner.nextLine();
            if (command.equals("end of race"))
                break;
            Pattern namePattern = Pattern.compile("[A-Z]|[a-z]+");
            Pattern distancePattern = Pattern.compile("[1-9]");
            Matcher nameMatcher = namePattern.matcher(command);
            Matcher distanceMatcher = distancePattern.matcher(command);
            String name = "";
            int distance = 0;
            while (nameMatcher.find()) {
                name = name.concat(nameMatcher.group());
            }
            while (distanceMatcher.find()) {
                distance += Integer.parseInt(distanceMatcher.group());
            }
            if (list.contains(name)) {
                if (participants.containsKey(name))
                    participants.put(name, participants.get(name) + distance);
                else
                    participants.put(name, distance);
            }
        }
        Map<String, Integer> finalResult = participants.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        int temp = 1;
        for (Map.Entry<String, Integer> entry : finalResult.entrySet()) {
            if (temp == 1) {
                System.out.println("1st place: " + entry.getKey());
                temp++;
            } else if (temp == 2) {
                System.out.println("2nd place: " + entry.getKey());
                temp++;
            } else if (temp == 3) {
                System.out.println("3rd place: " + entry.getKey());
                break;
            }
        }
    }
}

