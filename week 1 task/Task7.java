package firstweektask;

import java.util.ArrayList;
import java.util.List;
public class Task7 {    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        if (matches(pCount, sCount)) {
            result.add(0); 
        }
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            if (matches(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }        
        return result;
    }
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Task7 finder = new Task7();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = finder.findAnagrams(s, p);     
        System.out.println(anagrams); 
    }
}
