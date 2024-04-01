package HashTable;
//四数之和
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
///
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]>target){
                return result;
            }
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }

            for(int j=i+1;j<nums.length;j++){
                /*if(nums[i]+nums[j]>0&&nums[i]+nums[j]>target){
                    return result;
                }*/
                if(j>i+1&&nums[j-1]==nums[j]){
                    continue;
                }

                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum>target){
                        right--;
                    }
                    else if(sum<target){
                        left++;
                    }
                    else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                        while(left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        while(left<right&&nums[left]==nums[left+1]){
                            left++;
                        }

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}


/*
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {    // 对nums[i]去重
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对nums[j]去重
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}*/
