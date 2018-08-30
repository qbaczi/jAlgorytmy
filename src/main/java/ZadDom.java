import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZadDom {

    private static List<Integer> list = Arrays.asList(7, 6, 1, 3, 8, 10, 13, 2);
    private static List<String> listOfStrings = Arrays.asList("Warszawa", "Poznań", "Łódź", "Bydgoszcz", "Toruń", "Olsztyn");
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        printArray(secondNumber());
        System.out.println();
        System.out.println("Wyświetl pozycje parzyste podaj '0' albo nieparzyste podaj '1'.");
        printArray(oddEvenNumbers());
        System.out.println();
        cityOfPoland(listOfStrings);
        System.out.println(cityOfPolandStream());
        System.out.println("Podaj słowo do sprawdzenia: ");
        System.out.println(isPalindrom());

    }

    private static void printArray(List list) {

        Stream.of(list).forEach((number) -> System.out.print(number + " "));
    }

    private static List<Integer> secondNumber() {

        int[] n = {0};

        return list
                .stream()
                .filter(x -> n[0]++ % 2 == 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> oddEvenNumbers() {

        int oddEven = sc.nextInt();

        int[] n = {0};

        return list
                .stream()
                .filter(x -> n[0]++ % 2 == oddEven)
                .collect(Collectors.toList());
    }

    private static void cityOfPoland(List<String> list) {

        String maxCity = listOfStrings.get(0);
        String maxCity2 = listOfStrings.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (listOfStrings.get(i).length() > maxCity.length()) {
                maxCity = listOfStrings.get(i);
            } else if (listOfStrings.get(i).length() > maxCity2.length() && !maxCity2.equals(maxCity)) {
                maxCity2 = listOfStrings.get(i);
            }
        }

        System.out.println(maxCity);
        System.out.println(maxCity2);
    }

    private static List<String> cityOfPolandStream() {

        return listOfStrings
                .stream()
                .sorted((word1, word2) -> Integer.compare(word2.length(), word1.length()))
                .limit(2)
                .collect(Collectors.toList());
    }

    private static boolean isPalindrom() {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {

            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}