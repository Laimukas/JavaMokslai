package lt.bit;

public class MaziausiasSkaiciusMasyve {
    public static void main(String[] args){
        int[] numbers = {88,33,55,23,64,123};
        int maziausiaReiksme = randamMaziausiaReiksme(numbers);
        System.out.println("Maziausia reiksme: " +maziausiaReiksme);
        int didziausiaReiksme = randamDidziausiaReiksme(numbers);
        System.out.println("Didziausia reiksme: " +didziausiaReiksme);

    }
    public static int randamMaziausiaReiksme(int[] numbers) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }
        return smallest;
    }
    public static int randamDidziausiaReiksme(int[] numbers) {
        int bigest = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (bigest < numbers[i]) {
                bigest = numbers[i];
            }
        }
        return bigest;
    }
}
