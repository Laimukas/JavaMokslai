package lt.bit.exercise.ketv;

import lt.bit.exercise.antr.Masina;

public class Overloading {

    public static int suma(int a,int b){
        return a+b;
    }
    public static int suma(int a,int b,int c){
        return a+b+c;
    }
    public static String suma(int a,String b,int c){
        return a+b+c;
    }
    public static void main(String[] args) {
        System.out.println(suma(1,2));
        System.out.println(suma(1,2,3));
        System.out.println(suma(1,"2",3));
        System.out.println(1 +"2" +3);// atsakyma ismeta 123 nes operande esant bent vienam stringui,visi verciami i Stringus
        //                 1 +"2"
        //                "1"+"2"
       // tai yra metodu overloadinimas, kai funkcija yra pasirenkama pagal tinkama kintamuju kieki, charakteristika, tipus

        Masina m = new Masina("a", 100);
        String s = "labas " + m.toString();
        System.out.println(s);
        System.out.println(Integer.toString(1)+"2"+3);
    }
}
