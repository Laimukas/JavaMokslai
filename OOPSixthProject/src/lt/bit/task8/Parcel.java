package lt.bit.task8;

import java.util.ArrayList;

public class Parcel implements Validator {
    private int xLength;
    private int yLength;
    private int zLength;
    private float weight;
    private boolean isExpress;

    public Parcel(int xLength, int yLength, int zLength, float weight, boolean isExpress) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.zLength = zLength;
        this.weight = weight;
        this.isExpress = isExpress;
    }

    @Override
    public boolean validate(Parcel input) {
        ArrayList<String> errors = new ArrayList<>();

        if (input.isExpress == true && weight > 15.00) {
            errors.add("Kai Express = true, weight turetu but mazesnis nei 15");
        }

        if (input.isExpress == false && weight > 30.00) {
            errors.add("Kai Express = false, weight turetu but mazesnis nei 30");
        }
        if (input.xLength < 30 || input.yLength < 30 || input.zLength < 30) {
            errors.add("Lenght turi but daugiau arba lygu 30");
        } else {
            if (input.xLength + input.yLength + input.zLength > 300) {
                errors.add("Suma x,y,z negali buti daugiau nei 300");
            }
        }
        if (errors.size() == 0) {
            return true;
        } else {
            errors.forEach(error -> System.out.println(error));
            return false;
        }
    }
}
