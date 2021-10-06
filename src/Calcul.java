import java.util.Arrays;
import java.util.Scanner;

public class Calcul {static String[] Roman  = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] Arabic  = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    public static void main(String[] args) {
        ToArabic converterToArabic = new ToArabic();
        ToRoman converterToRoman = new ToRoman();


        try{
            Scanner in = new Scanner(System.in);
            System.out.print("Введите выражение, пример: 2 [*,/,+,-] 3 или I [*,/,+,-] VII: ");
            String expression = in.nextLine();
            String[] Symbols = expression.split(" ");

            int num1 = 0;
            int num2 = 0;

            if (Symbols.length != 3) {
                throw new Exception("Пример: 2 + 3 или I * X");
            }

            if ((IsAllowedArabic(Symbols[0]) == true & IsAllowedArabic(Symbols[2]) != true) | (IsAllowedRoman(Symbols[0]) == true
                    & IsAllowedRoman(Symbols[2]) != true)) {
                throw new Exception("Числа должны быть арабскими или римскими от 1 до 10");
            }

            if (IsAllowedRoman(Symbols[0]) == true) {
                num1 = converterToArabic.toArabic(Symbols[0]);
                num2 = converterToArabic.toArabic(Symbols[2]);
            } else {
                num1 = Integer.parseInt(Symbols[0]);
                num2 = Integer.parseInt(Symbols[2]);
            }

            int result = 0;

            switch (Symbols[1]){
                case "+":
                    result = num1 + num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    int doubleNum1 = num1;
                    int doubleNum2 = num2;
                    result = doubleNum1 / doubleNum2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                default:
                    throw new Exception("Неверная операция");
            }

            if (IsAllowedRoman(Symbols[0]) == true) {
                System.out.print("Ответ: " + converterToRoman.toRoman((int) result));
            } else {
                System.out.print("Ответ: " + result);
            }

        }

        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static boolean IsAllowedArabic(String Symbol) {
        return Arrays.asList(Arabic).contains(Symbol);
    }

    static boolean IsAllowedRoman(String Symbol) {
        return Arrays.asList(Roman).contains(Symbol);
    }
}



