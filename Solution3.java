class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] x=s.split(" ");
        int i;
        Map<Character,String> m=new HashMap<>();
        if(pattern.length()!=x.length)
            return false;
        for(i=0;i<pattern.length();i++)
        {
            char c=pattern.charAt(i);
            if(m.containsKey(c))
            {
                if(!m.get(c).equals(x[i]))
                    return false;
            }
            else if(m.containsValue(x[i]))
                return false;
            else
                m.put(c,x[i]);
        }
        return true;
    }
}