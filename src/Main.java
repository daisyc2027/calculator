import java.util.Scanner;
import java.util.ArrayList;
public class Main {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Double> listOfNumbers = new ArrayList<>();
    ArrayList<Character> listOfOperators = new ArrayList<>();

    String input = sc.nextLine();
    String[] numberList = input.split("[+\\-*/]");
    String[] opList = input.split("[0-9]+");

    for (String s : numberList) {
        listOfNumbers.add(Double.parseDouble(s));
    }

    for (int k = 0; k < numberList.length; k++) {
        if (!opList[k].isEmpty()) {
            listOfOperators.add(opList[k].charAt(0));
        }
    }

    double result = getResult(listOfNumbers, listOfOperators);
    System.out.println(result);

}

private static double getResult(ArrayList<Double> listOfNumbers, ArrayList<Character> listOfOperators) {
    double result = listOfNumbers.getFirst();
    for (int j = 0; j < listOfOperators.size(); j++) {
        char operator = listOfOperators.get(j);
        double nextNumber = listOfNumbers.get(j + 1);

        if (operator == '+') {
            result += nextNumber;
        } else if (operator == '-') {
            result -= nextNumber;
        } else if (operator == '*') {
            result *= nextNumber;
        } else if (operator == '/') {
            result /= nextNumber;
        }
    }
    return result;
}

}

