package lt.bit;

public enum VandensAgregatinesBusenos {
    KIETOJI(-1),
    SKYSTOJI(0),
    DUJINE(101);

    private final int temperatura;  //viena kart priskiriam ir daugiau nemodifikuojam

    VandensAgregatinesBusenos(int temperatura){
        this.temperatura=temperatura;
    }
    public int getTemperatura(){
        return temperatura;
    }
}
