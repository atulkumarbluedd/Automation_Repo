import java.util.Arrays;
import java.util.Comparator;

public class practice {

    public static void main(String[] args) {
        int nums1[] = new int[]{1, 2, 3, 5, 4, 2};
        int nums[]=new int[]{5,4,3,2,1};
        int peek = -1, i = 1;
        while (i < nums.length) {
            if (nums[i - 1] < nums[i]) peek = i;
            i++;
        }
        if (peek == -1) System.out.println("no element found then simply " +
                "return the array with increasing order means reverse the array or sort the array ");
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
//        peek = findPeek(nums);
//        System.out.println(peek);
//        int i = 1;
//
//        if (nums[peek + 1] > nums[peek - 1]) {
//            swap(peek + 1, peek - 1, nums);
//            System.out.println("doing swapping");
//        }
//        System.out.println(Arrays.toString(nums));
//        /** sorting rest of the elements **/
//        reverseSortBetweenIndexes(nums, peek + 1, nums.length - 1);
//
//        System.out.println(Arrays.toString(nums));


    }

    public static int findPeek(int[] nums) {
        int ans = -1;
        int len = nums.length;
        while (len-- >= 0) {
            while (len >= 0 && nums[len - 1] > nums[len]) {
                ans = len - 1;
                len--;
            }
            len--;

        }
        return ans;
    }

    public static void swap(int index1, int index2, int[] nums) {
        int temp = nums[index2];
        nums[index2] = nums[index1];
        nums[index1] = temp;
    }

    private static void reverseSortBetweenIndexes(int[] array, int startIndex, int endIndex) {

        if (startIndex >= 0 && endIndex < array.length && startIndex < endIndex) {
            Integer[] subArray = new Integer[endIndex - startIndex + 1];
            for (int i = 0; i < subArray.length; i++) {
                subArray[i] = array[startIndex + i];
            }

            Arrays.sort(subArray);

            for (int i = 0; i < subArray.length; i++) {
                array[startIndex + i] = subArray[i];
            }
        } else {
            System.out.println("Invalid indexes");
        }
    }


}


