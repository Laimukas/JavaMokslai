package lt.bit.zmones;

public class Skaiciai2 {
    public static void main(String[] args) {

        //        String ss = "651657";
//        long s = 0;
////        int daugiklis = 1;
////        for (int i = ss.length() - 1; i >= 0; i--) {
////            char c = ss.charAt(i);
////            int skaitmuo = c - 48;
////            System.out.println(c + " - " + skaitmuo);
////            if (i != ss.length() - 1) {
////                daugiklis *= 10;
////                int temp = skaitmuo * daugiklis;
////                s += temp;
////            } else {
////                s += skaitmuo;
////            }
////        }
//        for (int i = 0; i < ss.length(); i++) {
//            char c = ss.charAt(i);
//            s *= 10;
//            s += c - 48;
//        }
//        System.out.println(s); //651657
//        long s = 6519657;
//        String rez = "";
//        long tmp = s;
//        int daliklis = 1;
//        while (tmp != 0) {
//            daliklis *= 10;
//            int skaitmuo = (int) (tmp % daliklis);
//            int vnzSkaitmuo = skaitmuo * 10 / daliklis;
//            System.out.println(vnzSkaitmuo);
//            tmp -= skaitmuo;
//            rez = vnzSkaitmuo + rez;
//        }
//        System.out.println(rez); //6519657
        long s = 6519657;
        String rez = "";
        long tmp = s;
        while (tmp != 0) {
            int skaitmuo = (int) (tmp % 10);
            tmp = tmp / 10;
            rez = skaitmuo + rez;
        }
        System.out.println(rez); //6519657

    }
}
