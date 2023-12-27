package JavaHandsOn.streamConcepts;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import com.google.common.base.Predicate;

public class StreamDemo {
    /**
     * This class is to just demonstrate various methods and ways to use stream
     *
     * @param args
     */
    public static void main(String[] args) {
//	
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        IntStream.range(1, 1890).forEach(System.out::print);
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println(" plain stream took time of execution " + (end - start) + "__");

        long start1 = System.currentTimeMillis();

        IntStream.range(1, 1890).parallel().forEach(System.out::print);
        long end1 = System.currentTimeMillis();
        System.out.println();
        System.out.println(" parallel stream took time of execution " + (end1 - start1) + "__");

    }

    @Test(description = "for odd values double the number in a sorted order")
    public void testcase1() {
        List<Integer> nums = Arrays.asList(9, 3, 2, 4, 19);
        nums.stream().sorted().filter(a -> a % 2 != 0).map(a -> a * 2).forEach(a -> System.out.print(a + " "));
    }

    @Test(description = "use predicate functional interface as map takes predicate functional interface arg. and overide the test method and provide your logic")
    public void testcase2() {
        Predicate<Integer> predi = new Predicate<Integer>() {
            @Override
            public boolean test(Integer input) {
                // TODO Auto-generated method stub
                return input % 2 == 0;
            }

            @Override
            public boolean apply(Integer input) {
                // TODO Auto-generated method stub
                return false;
            }

        };
        List<Integer> nums = Arrays.asList(9, 3, 2, 4, 19);
        nums.stream().sorted().filter(predi).forEach(a -> System.out.print(a + " "));

    }

    @Test(description = "reduce method demo")
    public void reduce_demo() {
        List<Integer> nums = Arrays.asList(9, 3);
        int sum = nums.stream().reduce(0, (c, e) -> c + e);
        System.out.println(sum);
    }

    @Test()
    public void intstreamDemo() {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> data = nums.stream();
        data.forEach(a -> System.out.println(a));
        /***
         * 1. once stream is used can not be reused >>>> 2. actual list is untouched.
         *
         */
        data.forEach(a -> System.out.println(a)); // this will not work as stream is already used
    }

    @Test(description = "This method is to format string in a way that we wanted usig joining method")
    public void formatStreamOutput() {
        List<String> nums = Arrays.asList("ron", "sam", "josh", "jerry");
        String listToString = nums.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(listToString);
    }

    @Test(description = "convert int array into list")
    public void intArray_toList() {
        int[] nums = {3, 30, 34, 5, 9};
//		ArrayList<Integer> list = Arrays.stream(nums).boxed().distinct().collect(Collectors.toCollection(ArrayList::new));
//		int[] ans=Arrays.stream(nums).sorted(Comparator.reverseOrder()).toArray();
//		System.out.println(Arrays.toString(ans));

        List<Integer> ans = IntStream.of(nums).boxed() // boxed is used to convert into Integer stream
                .sorted(Comparator.reverseOrder()).toList().stream().filter(a -> a > 10).toList();

        System.out.println(ans);
        List<Integer> ans1 = IntStream.of(nums).boxed() // boxed is used to convert into Integer stream
                .sorted(Comparator.reverseOrder()).toList().stream().filter(a -> a > 10).toList();

        String out = "";
        for (int a : ans) out += a;
        for (int a : ans1) out += a;
        System.out.println(out);
        ArrayList<Integer> tree = new ArrayList<>();
        for (int a : nums) {
            if (a < 10) {
                tree.add(a);
            }


        }
        for (int a : nums)
            if (a > 10) {
                int[] temp = breakintodigits(a);
                for (int b : temp) tree.add(b);
            }
//
//		ArrayList<Integer> a =   tree.stream().sorted().collect(Collectors.toList());
        System.out.println(tree + " tree");


    }

    public int[] breakintodigits(int num) {

        int len = String.valueOf(num).length();
        int[] nums = new int[len];
        int count = 0;
        while (num > 0) {
            nums[count++] = num % 10;

            num = num / 10;
        }
        return nums;
    }

    @Test(description = "leetcode 179")
    public String leetcode_179(int[] nums) {

        // Convert int array to String array
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        // Sort the String array in a custom order
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));
        System.out.println(STR."\{Arrays.toString(numStrings)} nums string");
        // Handle the case where the result is "00" (multiple zeros)
        if (numStrings[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (String numString : numStrings) {
            result.append(numString);
        }

        return result.toString();
    }

    @Test(description = "random idea to call another test from one test !! oh yeah its working omg ")
    public void call() {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(leetcode_179(nums));
    }

    @Test
    public void samplew() {
        int lower = 10, x = 5, upper = 21;
        boolean inRange = x >= lower && x <= upper;
        System.out.println(inRange);

        int[] nums = {3, 0, 1};

        List<Integer> list = Arrays.stream(nums).boxed().toList();
        List<Integer> ans = list.stream().filter(a -> a != 0).filter(a -> !(list.contains(a + 1) && list.contains(a - 1))).toList();
        var val = ans.getFirst();
        var anss = list.contains(val - 1) ? val + 1 : val - 1;
        System.out.println(anss);
        System.out.println(val);


    }

    @Test(description = "Min window substring >> HARD << !!")
    public void leetcode_76() {
		String str="ADOBECODEBANC";
		  int ans=printSubstrings(str);
		  System.out.println(ans);
          /* min window substring leetcode 76*/
        String res = Min_window_substring("aaffhkksemckelloe", "fhea");
        System.out.println(res);
        /** easy solution */
        String res1 = Min_window_substring2("aabdccdbcacd", "aad");
        System.out.println(res1);
//
        String res12 = logics("aaffhkksemckelloe", "fhea");
        System.out.println(res12);
        String res11 = logics("aabdccdbcacd", "aad");
        System.out.println(res11);


    }
    @Test
    public void test(){
        String str= "aaaabb";
        HashMap<Character,Integer > map = new HashMap<>();
        for(char c: str.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        AtomicBoolean flag= new AtomicBoolean(false);
        map.forEach((k,v)->{
            if(v>=6) {
                flag.set(true);
            }
        });

        System.out.println(flag);
    }


    @Test(description = "Leetcode 1984")
    public void leetcode_1984(){
        int arr[] = new int[]{1,2,3};
        List<Integer> ans=  Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        ans.add(1);
        System.out.println(ans);

        /**
         * 2144
         * 1984 : min diff b/w highest and lowest of k scores -> sliding window
         *
         */
    }

    public int printSubstrings(String str) {
        int n = str.length();

        ArrayList<String> list = new ArrayList<>();
        System.out.println("All substrings of \"" + str + "\":");

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = str.substring(i, j);
                System.out.println(substring);
                list.add(substring);
            }
        }
        if(list.contains("BANC"))
            System.out.println(true);
        return list.size();
    }


    public String Min_window_substring2(String s, String t){
        int[] freq= new int[256];

        for(char c:t.toCharArray()) freq[c]++;
        int minLen=Integer.MAX_VALUE;
        int start=0,end=0,counter=t.length();
        int min_start=0;
        while(end<s.length()){
            if(freq[s.charAt(end)]>0) counter--;
            freq[s.charAt(end)]--;
            end++;
            while(counter==0){
                if(minLen > end-start){
                    minLen=end-start;
                    /** maintain the start pointer */
                    min_start=start;
                }
                freq[s.charAt(start)]++;
                if(freq[s.charAt(start)]>0) counter++;
                start++;
            }

        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(min_start, min_start+minLen);

    }
    public String Min_window_substring(String mainString, String targetString) {
        // Initialize character count maps
        int[] charCountMain = new int[256];
        int[] charCountTarget = new int[256];

        // Populate charCountTarget array
        for (char c : targetString.toCharArray()) {
            charCountTarget[c]++;
        }

        int start = 0;
        int end = 0;
        int requiredChars = targetString.length();
        int currcharLengths = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";

        while (end < mainString.length()) {
            char ch = mainString.charAt(end);
            charCountMain[ch]++;

            if (charCountMain[ch] <= charCountTarget[ch]) {
                currcharLengths++;
            }

            // Try to minimize the window size
            while (currcharLengths == requiredChars) {
                int windowSize = end - start + 1;
                if (windowSize < minLength) {
                    minLength = windowSize;
                    result = mainString.substring(start, end + 1);
                }
                char startChar = mainString.charAt(start);
                charCountMain[startChar]--;
                if (charCountMain[startChar] < charCountTarget[startChar]) {
                    currcharLengths--;
                }
                start++;
            }
            end++;
        }
        return result;
    }

    public String logics(String str1, String target) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int minlen = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = i; j < str1.length(); j++) {
                String subString = str1.substring(i, j);
                if (minlen > subString.length()) {
                    if (matchcharsOfTwoStrings(subString, targetMap, target)) {
                        minlen = subString.length();
                        ans = subString;
                    }
                }

            }
        }
        return ans;
    }

    public boolean matchcharsOfTwoStrings(String substring, HashMap<Character, Integer> targetMap, String target) {

        int[] charCountSubstring = new int[256];
        int[] charCountTarget = new int[256];
        /**
         *  store char count of target string
         */
        for (char c : target.toCharArray()) {
            charCountTarget[c]++;
        }

        /**
         *  store char count of substring
         */
        for (char c : substring.toCharArray()) {
            charCountSubstring[c]++;
        }

        /** here we have to traverse via target because we wanted in any case the chars of target should be in the
         *so, here the logic should be target driven, not the substring driven as there might me chances
         * if we drive via substring then there may be the case we might have no element which is present in the target.
         * so in that case it will skip all elements of the target, becayse we will add condition in those cases where we
         * will have the target element is present so her we will be in good position if we add the condition based on the
         * target. "**/
        for (char c:target.toCharArray()){
            if(charCountSubstring[c]<charCountTarget[c]) return false;
        }
        /** below code is via HashMap **/

//
//        HashMap<Character, Integer> subStringmap = new HashMap<>();
//
//
//        for (char c : substring.toCharArray()) {
//            subStringmap.put(c, subStringmap.getOrDefault(c, 0) + 1);
//        }
//
//        for (char c : target.toCharArray()) {
//            int freq = targetMap.get(c);
//            if (freq > subStringmap.getOrDefault(c, 0)) return false;
//        }
        return true;
    }


}