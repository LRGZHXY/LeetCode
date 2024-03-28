package HashTable;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum two_Sum = new TwoSum();
        //int[] nums = {2, 7, 11, 15};
        //int target = 9;
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        int[] nums=new int[length];
        for(int i=0;i<length;i++){
            nums[i]=scanner.nextInt();
        }
        int target=scanner.nextInt();
        int[] result = two_Sum.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }
}
