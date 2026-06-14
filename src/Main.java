import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String calc(String input) {
        input = input.trim();

        int index = -1;
        char operator = 0;

        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);

            if (a == '+' || a == '-' || a == '*' || a == '/') {
                if (index != -1) {
                    throw new IllegalArgumentException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
                index = i;
                operator = a;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("т.к. строка не является математической операцией");
        }

        int b;
        int c;

        try {
            b = Integer.parseInt(input.substring(0, index).trim());
            c = Integer.parseInt(input.substring(index + 1).trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (b < 1 || b > 10 || c < 1 || c > 10) {
            throw new IllegalArgumentException();
        }

        int result;

        switch (operator) {
            case '-':
                result = b-c;
                break;

            case '+':
                result = b+c;
                break;

            case '/':
                result = b/c;
                break;

            case '*':
                result = b*c;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return String.valueOf(result);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }
}