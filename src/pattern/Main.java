package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String maskId = "13987129846178956_dadfastable";
        String regex = ".*_.*?stable";
        System.out.println(regex);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(maskId);
        if (matcher.matches()) {
            // 稳定版：不可进行root
            System.out.println("不可root");
        } else {
            // 可以进行root
            System.out.println("可root");
        }
    }
}
