public class binarySearch {
    public static void main(String args[]) {
        String s = "sdfsv";
        String t = "sdgbv";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {

        int letter [] = new int [26];
        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); ++i){
            letter[s.charAt(i) - 'a']++;
            letter[t.charAt(i) - 'a']--;
        }
        for(int count: letter)
            if(count != 0)
                return false;
        return true;

    }

}
