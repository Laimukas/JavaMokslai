package lt.bit;

public class IlgiausiasZodis {
    public static void main(String[] args){
        String[] zodziai = new String[]{"labas", "abc","langas","kompiuteris"};
        String ilgiausias = surastiIlgiausiaZodi(zodziai);
        System.out.println(ilgiausias);
    }
    public static String surastiIlgiausiaZodi(String[] masyvas){
        int maxLength = 0;
        String longestString = null;
        for (int i=0;i< masyvas.length;i++ ) {
            if (maxLength < masyvas[i].length()) {
                maxLength = masyvas[i].length();
                longestString = masyvas[i];
            }
        }
        return longestString;
    }
}
