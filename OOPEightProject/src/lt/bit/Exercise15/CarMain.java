package lt.bit.Exercise15;

public class CarMain {
    public static void main(String[] args) {
        boolean tikrinamArGreitesne = Car.FERRARI.isFasterThan(Car.MERCEDES);
        System.out.println(tikrinamArGreitesne);

        boolean arPremium = Car.TOYOTA.isPremium();
        System.out.println(arPremium);

        boolean arRegular = Car.PORSCHE.isRegular();
        System.out.println(arRegular);
    }
}
