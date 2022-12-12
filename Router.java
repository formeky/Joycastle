package joyCastle;

public class Router {

    public int max(int[][] nums){
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (nums[i][0]>nums[j][0]){
                    int l, r;
                    l = nums[i][0];
                    r = nums[i][1];
                    nums[i][0] = nums[j][0];
                    nums[i][1] = nums[j][1];
                    nums[j][0] = l;
                    nums[j][1] = r;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            int sum = 1;
            int l = nums[i][0];
            int r = nums[i][1];
            for (int j = i+1; j < length; j++) {
                if(nums[j][0]<r){
                    l = nums[j][0];
                    r = Math.min(r,nums[j][1]);
                    sum++;
                }else{
                    break;
                }
            }
            max = Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,9},
                {2,4},
                {5,6},
                {3,7},
                {1,8},
        };
        int max = new Router().max(nums);
        System.out.println(max);
    }
}
