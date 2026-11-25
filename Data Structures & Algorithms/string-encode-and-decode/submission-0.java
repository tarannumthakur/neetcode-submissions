class Solution {

/**
Time complexity: O(m+n) for each encode() and decode() function calls
Space complexity: O(m+n) for each encode() and decode() function calls.
m is the sum of lengths of all the strings and n is the number of strings.
**/
    public String encode(List<String> strs) {
        if(strs.isEmpty()) {
            return "";
        }
        //combining string with there lenght  and # through stream
    //  String s = strs.stream().map(n -> n.length()+"#"+n).collect(Collectors.joining());
    //normal way
    StringBuilder sb = new StringBuilder();
    for(String s: strs) {
        sb.append(s.length()).append('#').append(s);
    }
     return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i =0;
        while(i<str.length()) {
            int j =i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+length;

            res.add(str.substring(i,j));
            i=j;
        }
       return res;
    }
}
