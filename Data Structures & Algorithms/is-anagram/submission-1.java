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

        //through has Map
        // Map<Character, Integer> m = new HashMap<>();
        // Map<Character, Integer> m1 = new HashMap<>();

        // for(char c: s.toCharArray()){
        //    m.put(c, m.containsKey(c) ? m.get(c) +1 : 1);
        // }
        // System.out.println(m);
        // for(char c: t.toCharArray()){
        //     m1.put(c, m1.containsKey(c) ? m1.get(c) +1 : 1);
        // }
        // System.out.println(m1);
        // for (Character a: m.keySet()){
        //   if(!(m.get(a)).equals(m1.get(a))) {
        //     return false;
        //   }
        // }
        // return true;

        // through array
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
