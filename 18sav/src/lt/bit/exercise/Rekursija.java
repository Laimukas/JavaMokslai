package lt.bit.exercise;

public class Rekursija {
    // rekursija kai metodas kviecia pats save
    //labai svarbu kad metodas turetu isejima
    public static long fakt(long sk) {
        if (sk < 0) { // cia aprasem nesamone pagal matematika bet sitai nenulaus musu programos
            return -1;
        }
        if (sk == 0) { //kai rekursinis metodas grazina reiksme nekviesdamas pats saves
            return 1;
        }
        return sk * fakt(sk - 1);
    }

    public static int fabo(int sk1, int sk2, int max){
        if (sk2>max){
            System.out.println("-------------------------------------------------");
            System.out.println("sekantis sk2: "+sk2+" ir jis yra didesnis uz max: "+max);
            return 0;
        }

        System.out.println(String.format("sk1: %-6d, sk2: %-6d",sk1,sk2));
        int next=sk1+sk2;
        sk1=sk2;
        sk2=next;

        return sk2+fabo(sk1,sk2,max);
    }


    public static void main(String[] args) {
       // System.out.println(fakt(-2));
        fabo(1,1,500);
    }
}
/*
faktorijalai

5!=5*4*3*2*1=5*4!
4!=4*3*2*1  =4*3!
3!=3*2*1    =3*2!
2!=2*1      =2*1!
1!=1        =1*0!
0!=1
 */

/*
parasyti metoda (rekursini), kuris spausdintu fibonaci skaiciu seka
turi nustoti spausdinti, kai naujas skaicius pasidaro didesnis uz max

    public static void fib(int sk1, int sk2, int max) {
        //
    }

fib(1, 1, 500);
 */


