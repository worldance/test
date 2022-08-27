import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {
        String expectedParam = "N,Y,S";
        String[] split = expectedParam.split(",");
        Stream<String> sorted = Arrays.stream(split).sorted();
        expectedParam = String.join(",", sorted.collect(Collectors.toList()));
        System.out.println(expectedParam);

        Set<String> auditInfos = new TreeSet<>();
        auditInfos.add("Y");
        auditInfos.add("N");
        String auditInfo = String.join(",", auditInfos);
        System.out.println(auditInfo);
        System.out.println(expectedParam.contains(auditInfo));

        String str1 = "0.01";
        System.out.println(Math.round(Double.parseDouble(str1)));
        String str2 = "10.01";
        System.out.println(Math.round(Double.parseDouble(str2)));
        String str3 = "10.116";
        System.out.println(Math.round(Double.parseDouble(str3)));
        String str4 = "0.9";
        System.out.println(Math.round(Double.parseDouble(str4)));

    }
}
