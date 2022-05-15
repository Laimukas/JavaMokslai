package exercise32;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {

    private static final String OUTPUT_FILE = "src/main/resources/listOfCars.txt";

    public static void main(String[] args) throws IOException {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("BMW", 140.20, 1400, 2006));
        carList.add(new Car("Audi", 120.20, 1200, 2008));
        carList.add(new Car("Mercedes-Benz", 150.40, 1600, 2011));
        carList.add(new Car("Toyota", 90.49, 980, 2004));

        writeToFileFromArrayList(carList, new File(OUTPUT_FILE));
        ArrayList<Car> retrievedCar = getArrayListFromFile(new File(OUTPUT_FILE));
        retrievedCar.forEach(car -> System.out.println(car));
    }

    private static void writeToFileFromArrayList(ArrayList<Car> carList, File outputFile) throws IOException {
        String formattedString = "";

        for (Car car : carList) {
            formattedString += String.format("%s,%.2f,%.2f,%d \n", car.getModel(), car.getHeight(), car.getWeight(), car.getYears());
        }

        FileUtils.writeStringToFile(outputFile, formattedString, StandardCharsets.UTF_8);
    }

    private static ArrayList<Car> getArrayListFromFile(File outputFile) throws IOException {

        String textFromFile = FileUtils.readFileToString(outputFile, StandardCharsets.UTF_8);
        String[] lines = textFromFile.split("\n");

        ArrayList<Car> cars = new ArrayList<>();

        for (String line : lines) {
            String[] attributes = line.split(",");

            Car car = new Car(attributes[0].trim(), Double.valueOf(attributes[1].trim()),
                    Double.valueOf(attributes[2].trim()), Integer.valueOf(attributes[3].trim()));

            cars.add(car);
        }

        return cars;
    }
}
