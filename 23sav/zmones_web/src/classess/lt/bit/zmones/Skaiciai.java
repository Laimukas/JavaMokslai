package lt.bit.zmones;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Skaiciai {
    public static void main(String[] args) {
        BigDecimal skaic1=new BigDecimal("0.111111111111111111111111111111111111111111111111111111115");
        BigDecimal skaic2=new BigDecimal("0.2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222228");

        BigDecimal skaic3=skaic1.add(skaic2);
        System.out.println(skaic3);

        BigInteger sk4 = new BigInteger("4464684646464846464684646464684446468468468464646464846464664646464646468464464");
        BigInteger sk5 = new BigInteger("984646464649849849498498494949498494849498498498498498498498484949849849494949444994949498");

        BigInteger sk6 = sk4.add(sk5);

        System.out.println(sk6);
    }
}
