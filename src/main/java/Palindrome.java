public class Palindrome {
    public boolean isPalindrome(String text){
        if(text==null){
            return false;
        }
        text= text.replaceAll("[^a-zA-Z0-9]","" );
       // System.out.println(text);
        text=text.toLowerCase();
        if(text.length()>=2) {
            for (int i = 0; i < (text.length() / 2); i++) {
                //System.out.println(text.charAt(i));
               // System.out.println(text.charAt(text.length() -i -1));
                if (text.charAt(i) != text.charAt(text.length() -i -1)) {
                    return false;
                }
            }
        }
        return true;

    }
}
