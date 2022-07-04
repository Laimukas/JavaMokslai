package lt.bit.penkt.klaidos;

import java.io.IOException;

public class Run {
    public static double klaiduGeneratorius(int sk)
            throws IOException, InterruptedException, ManoKlaida {
        if (sk > 0) {
            if (sk < 10) {
                throw new IllegalArgumentException("Klaida");
            } else if (sk < 20) {
                throw new IndexOutOfBoundsException("Kita klaida");
            } else if (sk < 30) {
                throw new ArithmeticException("Dar Kita klaida");
            } else if (sk < 40) {
                throw new RuntimeException("super klaida");
            } else if (sk < 50) {
                throw new IOException("IO klaida");
            } else if (sk < 60) {
                throw new InterruptedException("IO klaida");
            } else if (sk < 70) {
                throw new StackOverflowError("tipo bloga rekursija");
            } else if (sk < 80) {
                throw new ManoKlaida("mano klaidos aprasymas");
            } else if (sk < 90) {
                throw new ManoUncheckedKlaida("mano unchecked klaidos aprasymas");
            }
        }
        System.out.println("Praejo be klaidu");
        return Math.random();
    }

    public  static double tustiVartai(int sk)
            throws IOException,InterruptedException,ManoKlaida{
        System.out.println("pradeda tustiVartai");
        double ret = klaiduGeneratorius(sk);
        System.out.println("baigia tustiVartai");
        return ret;
    }



    public static void main(String[] args) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // ignore
        }


        System.out.println("pradzia");
        try {
            double sk = tustiVartai(55);
            System.out.println("gavau rezultata: " + sk);
            System.out.println("dirbam toliau");
//        } catch (IllegalArgumentException ex) {
//            System.out.println("vartininkas pagavo klaida: " + ex.getMessage());
//        } catch (IndexOutOfBoundsException ex) {
//            System.out.println("kitas vartininkas: " + ex.getMessage());
//        } catch (RuntimeException ex) {
//            System.out.println("Storas vartininkas pagavo klaida: " + ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println("IO klaida: " + ex.getMessage());
//        } catch (InterruptedException ex) {
//            System.out.println("Interrupted klaida: " + ex.getMessage());
        } catch (Exception ex) {
//            System.out.println("Pats storiausias vartininkas: " + ex.getMessage());
//            System.out.println(ex);
            ex.printStackTrace();

        } finally {
//            System.out.println("Sitas VISADA suveiks !!!");
        }

        System.out.println("pabaiga");
    }

}
