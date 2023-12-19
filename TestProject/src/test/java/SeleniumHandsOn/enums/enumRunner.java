package SeleniumHandsOn.enums;


import SeleniumHandsOn.ConfigSource.CONFIGS;
import SeleniumHandsOn.Factories.PropertyUtils;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

public class enumRunner {
    public static void main(String[] args) throws java.lang.Exception {

        String s = severity.CRITICAL.toString().toLowerCase();
        System.out.println(s);

        for (severity severity : severity.values()) System.out.println(severity);

        System.out.println("/* using lambdas */");
        Arrays.asList(severity.values()).forEach(System.out::println);

        System.out.println("using /*Enum set*/");
        EnumSet.of(severity.CRITICAL, severity.HIGH, severity.MEDIUM).forEach(System.out::println);
        EnumMap<severity, String> enumMap = new EnumMap<>(severity.class);
        enumMap.put(severity.CRITICAL, "critical");
        enumMap.put(severity.HIGH, "HIGH");
        enumMap.put(severity.MEDIUM, "medium");
        enumMap.forEach((k, v) -> System.out.println(k + "::" + v));
        System.out.println("/* enums getters and stters */");
        /* we can use setters and getters as well with enums*/
        System.out.println(severity.CRITICAL.getFixingHrs());
        severity.CRITICAL.setFixingHrs(3);
        System.out.println(severity.CRITICAL.getFixingHrs());

        /* read enum from property files*/

        System.out.println( PropertyUtils.get(CONFIGS.URL));
    }

}
