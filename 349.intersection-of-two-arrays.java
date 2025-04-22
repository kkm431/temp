/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start

import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> unique= new HashSet<>();

        for(int num1: nums1){
            unique.add(num1);
        }

        nums1= unique.stream().mapToint(Integer::intValue).toArray();

        unique.clear();

        for(int num2: nums2){
            unique.add(num1);
        }

        nums2= unique.sttream().mapToint(Integer::intValue).toArray();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> temp= new ArrayList<>();

        int i=0, j = 0;
        int n= nums1.length;
        int m= nums2.length;

        while(i < n && j < m){
            if(nums1[i] == nums2[j]){ 
                temp.add(nums1[i]);
            }
            i++;
            j++;
        }
        
        int t = temp.size() ;

        int[] ans= new int[t];

        for (int k = 0; k < t; k++) {
            ans[k] = temp[k];
        }


        return ans;
    }

}
// @lc code=end

