class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        return false;

        // char [] ch1 = s.toCharArray();
        // Arrays.sort(ch1);
        // char [] ch2 = t.toCharArray();
        // Arrays.sort(ch2);

        // s = new String(ch1);
        // t = new String(ch2);
        // if(s.equals(t)) {
        //  return true;
        // } else{
        //     return false;
        // }

        //through has Map best way if stirng includes all kinds of special,numeric and uppercase letters.
        //Time Complexity: O(n)
        //Space Complexity: O(k) where k is the number of distinct characters in the string.
       // Map<Character, Integer> freq = new HashMap<>();

       //  for (int i = 0; i < s.length(); i++) {
       //      char c1 = s.charAt(i);
       //      char c2 = t.charAt(i);
       //      freq.put(c1, freq.getOrDefault(c1, 0) + 1);
       //      freq.put(c2, freq.getOrDefault(c2, 0) - 1);
       //  }

       //  for (int count : freq.values()) {
       //      if (count != 0) {
       //          return false;
       //      }
       //  }
       //  return true;

        // through array - best for in string includes only lower case letters
        //Time Complexity: O(n)
        //Space Complexity: O(1)
        int[] count = new int[26]; // intially will be placed with zero value at every index

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; //this will add increment from zero to one at specified index
            count[t.charAt(i) - 'a']--; //this will add decrement from zero to minus one at specified index
            
        }

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;

    }
}
