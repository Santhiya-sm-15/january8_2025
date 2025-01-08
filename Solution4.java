class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> tm=new HashMap<>();
        Map<Character,Integer> sm=new HashMap<>();
        int i;
        for(i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            sm.put(c,sm.getOrDefault(c,0)+1);
        }
        for(i=0;i<t.length();i++)
        {
            char c=t.charAt(i);
            tm.put(c,tm.getOrDefault(c,0)+1);
        }
        if(sm.size()!=tm.size())
            return false;
        for(Map.Entry<Character,Integer> x:sm.entrySet())
        {
            if(!tm.containsKey(x.getKey()))
                return false;
            int a=x.getValue();
            int b=tm.get(x.getKey());
            if(a!=b)
                return false;
        }
        return true;
    }
}