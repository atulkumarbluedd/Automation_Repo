package com.coco.Tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class sample {
    public static void main(String[] args) {

        // Creating an empty Stack
        Stack<Integer> stack = new Stack<Integer>();

        // Use add() method to add elements into the Stack
        stack.add(322);

        int[] arr = stack.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(arr));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        String ss = list.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(ss + ">>>>>>>>>>>>>>>>>>>>>>>");

// Using Stream mapToInt(ToIntFunction mapper) 
// and displaying the corresponding IntStream 
        list.stream().mapToInt(num -> num).forEach(System.out::println);
        StringBuilder builder = new StringBuilder();
        builder.append("hel00");
        builder.setLength(1212);
        int len = builder.length();
        System.out.println(len);

    }

    @Test(description = "this test is to print prime numbers from 2 to 20 !!")
    public void printPrime() {
        IntStream.range(2, 20).forEach(System.out::println);
        int num = 15;
        while (num != 0) {
            boolean flag = false;

            for (int i = 2; i <= (int) Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = true;
                    break;
                }
            }
//			if(!flag) System.out.println(STR."number is prime \{num}");
            num--;
        }
    }

    @Test(description = "Imagine you have a JSON object that contains multiple email IDs for a single record. How would you approach reading the email ID if the name is \"Abhishek\"? " +
            "Please outline a program that uses the Singleton design pattern to accomplish this task.")

    public void problem_solution() {
        /* here we are utilizing the gson liberary*/
//
        String name = "Abhishek";
        String input = "{\n" +
                "  \"records\": [\n" +
                "    {\n" +
                "      \"name\": \"Abhishek\",\n" +
                "      \"emails\": [\"abhishek@email.com\", \"abhishek2@email.com\"]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"John\",\n" +
                "      \"emails\": [\"john@email.com\"]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Alice\",\n" +
                "      \"emails\": [\"alice@email.com\", \"alice2@email.com\"]\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
        JsonElement jsonElement = JsonParser.parseString(input);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        boolean flag = false;
        JsonArray records = jsonObject.getAsJsonArray("records");

        for (JsonElement record : records) {
            JsonObject recordObject = record.getAsJsonObject();
            String currentName = recordObject.getAsJsonPrimitive("name").getAsString();

            if (currentName.equals(name)) {
                JsonArray emails = recordObject.getAsJsonArray("emails");
                // Assuming there can be multiple emails for a single record
                String out = emails.toString();
                System.out.println(out);
                flag = true;
                break;

            }
        }
        if (!flag)
            System.out.println("No matching record found for the name: " + name);


    }

}
