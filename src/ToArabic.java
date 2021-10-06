import java.util.Arrays;
import java.util.TreeMap;

public class ToArabic extends Calcul{
    public final static TreeMap<String, Integer> map = new TreeMap<String, Integer>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    static String[] digits = {"I", "V", "X", "L", "C", "D", "M"};

    public final static int toArabic(String number) {
        number = number.toUpperCase();
        String[] romans = number.split("");
        int res = 0;

        for (int i = 0; i < romans.length; i++) {
            if (Arrays.asList(digits).indexOf(romans[i]) < Arrays.asList(digits).indexOf(romans[Math.min(romans.length - 1, i + 1)])) {
                res -= map.get(romans[i]);
            } else {
                res += map.get(romans[i]);
            }
        }
        return res;
    }
}
