/**
 * ClassName：MaxSubArray
 * Package:PACKAGE_NAME
 * Description:给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * Related Topics
 * 数组
 * 分治算法
 * 动态规划
 *
 * @Date:2020/8/27 16:25
 * @Author:13975567160@163.com
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 思路：DP
     * 1.获取到前i个的最大子序和的数据
     * dp[i]=max(nums[i], dp[i−1]+nums[i])
     * dp[0] = nums[0]
     * 2.比较
     * 复杂度： O(n) 的解法
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        //1.获取到前i个num的最大子序和的数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int i1 = dp[i - 1] + nums[i];
            if (i1 >= nums[i]) {
                dp[i] = i1;
            } else {
                dp[i] = nums[i];
            }
        }
        //2.比较获取最大子序和
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
    /**
     * todo 分治法
     */
}
