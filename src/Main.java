import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(calc(string));
    }

    public static String calc(String input) throws Exception {
        int result = 0;
        String response = "";
        int a;
        int b;
        List<String> rims = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

        String[] str = input.split(" ");
        if (str.length != 3) throw new Exception();

        try {
            a = Integer.parseInt(str[0]);
            if (a > 10 || a < 1) throw new Exception();
            b = Integer.parseInt(str[2]);
            if (b > 10 || b < 1) throw new Exception();
            response = String.valueOf(math(str[1], a, b));

        } catch (NumberFormatException e) {
            a = rims.indexOf(str[0]) + 1;
            b = rims.indexOf(str[2]) + 1;
            if (a == 0 || b == 0) throw new Exception();
            result = math(str[1], a, b);
            if (result < 1) throw new Exception();
            response = toRim(result, rims);
        }
        return response;
    }
    static int math(String x, int a, int b) {
        int result = 0;
        switch (x) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }
        return result;
    }

    static String toRim(int a, List<String> list) {
        StringBuilder str = new StringBuilder();
        if (a == 100) {
            str.append("C");
            a = 0;
        } else if (a >= 90) {
            str.append("XC");
            a = a - 90;
        } else if (a >= 80) {
            str.append("LXXX");
            a = a - 80;
        } else if (a >= 70) {
            str.append("LXX");
            a = a - 70;
        } else if (a >= 60) {
            str.append("LX");
            a = a - 60;
        } else if (a >= 50) {
            str.append("L");
            a = a - 50;
        } else if (a >= 40) {
            str.append("XL");
            a = a - 40;
        } else if (a >= 30) {
            str.append("XXX");
            a = a - 30;
        } else if (a >= 20) {
            str.append("XX");
            a = a - 20;
        } else if (a >= 10) {
            str.append("X");
            a = a - 10;
        }
        if (a >= 1)
            str.append(list.get(a - 1));
        return str.toString();
    }
}


