# january8_2025
The problems that I solved today

1.You are given a 0-indexed string array words. Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2: isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix and a suffix of str2, and false otherwise.For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false. Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.

Code:
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int i,j,n=words.length;
        int cnt=0;
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i]))
                    cnt++;
            }
        }
        return cnt;
    }
}

2.Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t. All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Code:
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

3.Given a pattern and a string s, find if s follows the same pattern.Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:Each letter in pattern maps to exactly one unique word in s.Each unique word in s maps to exactly one letter in pattern.No two letters map to the same word, and no two words map to the same letter.

Code:
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

4.Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Code:
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
