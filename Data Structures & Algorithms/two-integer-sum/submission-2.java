class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Time & Space Complexity
        //Time complexity: O(n*n)
        //Space complexity: O(1)
        // for(int i=0; i < nums.length; i++) {
        //     for(int j=i +1; j<nums.length; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             return new int [] {i, j};
        //         }
            
        //     }
        // }
        // return new int[0];

        //****two pointers approach***
        //Time complexity:O(nlog⁡n)
        //Space complexity:O(n) 
//         int [] [] A = new int[nums.length][2];
//         for(int i =0; i<nums.length; i++) {
//             //store number and there index
//             A[i][0] = nums[i];
//             A[i][1] = i;
//         }
//         System.out.println(Arrays.deepToString(A));
//         //sort Array
//         Arrays.sort(A, Comparator.comparingInt(a ->a[0]));
//         System.out.println(Arrays.deepToString(A));
// int i=0, j=nums.length -1;
//         while(i< j){
//             if(A[i][0] + A[j][0] == target) {
//                return new int [] {Math.min(A[i][1], A[j][1]), Math.max(A[i][1], A[j][1])};
//             } else if(A[i][0] + A[j][0] > target) {
//              j--;
//             } else{
//                 i++;
//             }

//         }
//         return new int[0];

// Hash Map (Two Pass)
//Time complexity:O(n)
//Space complexity:O(n) 
Map<Integer, Integer> a =  new HashMap<>(nums.length);
for(int i=0; i< nums.length; i++) {
    int sum = target - nums[i];
    if(a.containsKey(sum)) {
        return new int [] {a.get(sum), i};
    } else {
        a.put(nums[i], i);
    }
}
return new int[0];
    }
}
