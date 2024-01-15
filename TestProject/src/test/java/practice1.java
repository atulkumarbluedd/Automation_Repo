import io.cucumber.java.it.Ma;

public class practice1 {
    public static void main(String[] args) {

         int val=Integer.MAX_VALUE;
         int ans=count(new int[]{2,9,2,5,6}, 2, 8);
        System.out.println(ans);
    }

    public static  int count(int [] nums, int left, int right){
        int len=nums.length, count=0;

        int start=0;
        int end=0;
       for(int i=0;i<len;i++){
           start=i;
           end=i;
           int max=Integer.MIN_VALUE;

            if(end<len && nums[end]>= left && nums[start]<=right){
                max= Math.max(max,nums[end]);
                count++;
                end++;

                while (end<len && max>=nums[end] && max>=left && max<=right){
                    max= Math.max(max,nums[end]);
                    end++;
                    count++;
                }
            }
            i=end;


        }

        return count;


    }
    }

