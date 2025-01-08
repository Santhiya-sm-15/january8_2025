class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> m=new HashMap<>();
        int i;
        for(i=0;i<s.length();i++)
        {
            if(m.containsKey(s.charAt(i)))
            {
                if(m.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }
            else if(m.containsValue(t.charAt(i)))
                return false;
            else
                m.put(s.charAt(i),t.charAt(i));
        }
        return true;
    }
}