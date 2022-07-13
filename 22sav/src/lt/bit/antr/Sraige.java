package lt.bit.antr;

import java.util.Date;

class Sraige extends Thread {
    String name;
    int distancija;
    int nuo;
    int iki;
    Date startas;
    Date finisas;

    public Sraige(int nuo, int iki, String name) {
        this.name = name;
        this.distancija = distancija + ((int)Math.random()*2+8);
        this.nuo = 0;
        this.iki = iki;
        this.startas=startas;
        this.finisas=finisas;
    }
    public Sraige(int nuo, int iki) {
        this.name = name;
        this.distancija = distancija + ((int)Math.random()*2+8);
        this.nuo = 0;
        this.iki = iki;
        this.startas=startas;
        this.finisas=finisas;
    }


    public String getNamee() {
        return name;
    }

    public int getDistancija() {
        return distancija;
    }

    public int getNuo() {
        return nuo;
    }

    public int getIki() {
        return iki;
    }

    public Date getStartas() {
        return startas;
    }

    public Date getFinisas() {
        return finisas;
    }

    @Override
    public void run() {
        int pemMetru=50;
//        int finisoVieta=0;
        for (long i = nuo; i <= iki; i++) {
            distancija += i;

            if (i==pemMetru && i==iki){
//                finisoVieta++;
//                System.out.println("Finisavo "+this+" ,jos vieta "+finisoVieta);
                System.out.println("Finisavo "+this);
            }else if (i==pemMetru){
                System.out.println(name+ " iveike "+pemMetru+" metru");
                pemMetru=pemMetru+50;
            }
        }
//        System.out.println("Finisavo "+this);
    }

    @Override
    public String toString() {
        return name;
    }
}