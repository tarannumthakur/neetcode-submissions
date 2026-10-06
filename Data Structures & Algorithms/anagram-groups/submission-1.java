class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //This approach work for unicode characters
        //Time complexity O(m*nlongn)
        //Space complexity O(m*n)
        // sorting string putting it in hasmap
        HashMap<String, ArrayList<String>> res = new HashMap<>();
        for(String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sString = new String(c);
            res.putIfAbsent(sString, new ArrayList<>());
            res.get(sString).add(s);
            //System.out.println(res);
        }
        return new ArrayList<>(res.values());

        //Second approach without sorting: The frequency array approach with size 26 only works for lowercase English letters
        //Time complexity:O(m*n)
        //space complexity:O(m*n)
        // Map<String, List<String>> res = new HashMap<>();

        // for(String s: strs) {
        //     int [] count = new int[26];
        //     for(char c: s.toCharArray()) {
        //         count[c -'a']++;
        //     }
        //     String key = Arrays.toString(count);
        //     res.putIfAbsent(key, new ArrayList<>());
        //     res.get(key).add(s);
        // }

        // return new ArrayList<>(res.values());

        //Third approach Using a Mutable Key Type for the Hash Map

        
    }
}