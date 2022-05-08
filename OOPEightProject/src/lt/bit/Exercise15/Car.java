package lt.bit.Exercise15;

public enum Car {
    FERRARI(300000,640),
    PORSCHE(200000,500),
    MERCEDES(140000,240),
    BMW(75000,200),
    OPEL(35000,100),
    FIAT(55000,160),
    TOYOTA(46000,155),
    FORD(55000,140),
    AUDI(85000,200);

    private final double price;
    private final int power;

    Car(double price,int power){
        this.price = price;
        this.power=power;
    }
    public boolean isRegular(){
        return this.price <100000;
    }
    public boolean isPremium(){
        return !isRegular();
    }
    public boolean isFasterThan(Car car){
        return this.power > car.power;
    }
}
