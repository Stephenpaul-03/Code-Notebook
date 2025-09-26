import com.google.gson.*;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Entry {
        int index;
        BigInteger decimalValue;

        Entry(int index, BigInteger decimalValue) {
            this.index = index;
            this.decimalValue = decimalValue;
        }
    }

    public static void main(String[] args) throws Exception {
        String file = (args.length > 0) ? args[0] : "test_case_1.json";

        List<Entry> dict = datainitializer(file);

        JsonObject root = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
        int n = root.getAsJsonObject("keys").get("n").getAsInt();
        int k = root.getAsJsonObject("keys").get("k").getAsInt();

        System.out.println("n = " + n + ", k = " + k);
        System.out.println("All Points:");
        for (Entry e : dict) {
            System.out.println("(" + e.index + ", " + e.decimalValue + ")");
        }
        System.out.println();

        List<Entry> selected = dict.subList(0, Math.min(k, dict.size()));
        System.out.println("Selected Points:");
        for (Entry e : selected) {
            System.out.println("(" + e.index + ", " + e.decimalValue + ")");
        }
        System.out.println();

        double[] coefficients = lagrange(selected);

        System.out.println("Polynomial Coefficients:");
        for (int i = 0; i < coefficients.length; i++) {
            System.out.printf("a%d = %.15f\n", i, coefficients[i]);
        }
        System.out.printf("\nConstant term C = %.15f\n", coefficients[0]);
    }

    static List<Entry> datainitializer(String file) throws Exception {
        JsonObject root = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
        List<Entry> entries = new ArrayList<>();

        for (Map.Entry<String, JsonElement> field : root.entrySet()) {
            String key = field.getKey();
            if ("keys".equals(key)) continue;

            JsonObject obj = field.getValue().getAsJsonObject();
            int index = Integer.parseInt(key);
            int base = Integer.parseInt(obj.get("base").getAsString());
            String value = obj.get("value").getAsString();

            BigInteger decimalValue = new BigInteger(value, base);
            entries.add(new Entry(index, decimalValue));
        }

        entries.sort(Comparator.comparingInt(e -> e.index));
        return entries;
    }

    static double[] lagrange(List<Entry> points) {
        int k = points.size();
        double[] coeffs = new double[k];
        for (int i = 0; i < k; i++) {
            double xi = points.get(i).index;
            double yi = points.get(i).decimalValue.doubleValue();

            double[] Li = new double[k];
            Li[0] = 1.0;
            for (int j = 0; j < k; j++) {
                if (i == j) continue;
                double xj = points.get(j).index;

                double denom = (xi - xj);
                for (int d = k - 1; d >= 0; d--) {
                    Li[d] = (d > 0 ? Li[d - 1] : 0) - xj * Li[d];
                }
                for (int d = 0; d < k; d++) {
                    Li[d] /= denom;
                }
            }

            for (int d = 0; d < k; d++) {
                coeffs[d] += yi * Li[d];
            }
        }
        return coeffs;
    }
}
