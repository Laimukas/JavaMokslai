package exercises;

public class Main {
    public static void main(String[] args) {

//        int a = 5;
//        long b = 100000000000000L;
//        int c = (int) b;
//        System.out.println(b);

        //Sekanti uzklausa

//        Integer a = 25;
//        Integer b = 10;
//        Integer c = 30;
//        Integer d = 50;
//        String tekstas = "hello";
//        String tekstas1 = "hello";
//        Boolean e = false;
//        Boolean f = !e;
//        Long h = 2000000l;
//        Character j = 'h';
//
//        Object atsakymas = tekstas != tekstas1 ? a > b ? c : d : e ? h : f ? j : h;
//        // tekstas != tekstas1 -> false todel -> e (c:d priklauso a>b)->false -> f->true -> j
//        System.out.println(Character.getName(Integer.valueOf((String.valueOf(atsakymas)))));

        //Atrasti antra didziausia skaiciu
        int[] skaiciai = {10, 20, 30, 40, 50, 10, 20, 30, 42, 34, 48};

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < skaiciai.length; i++) {
            if (max < skaiciai[i]) {
                max = skaiciai[i];
            }
            if (skaiciai[i] < max && secondMax < skaiciai[i]) {
                secondMax = skaiciai[i];
            }
        }
        System.out.println(max);
        System.out.println(secondMax);

    }
}
