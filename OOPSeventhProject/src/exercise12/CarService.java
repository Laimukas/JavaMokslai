package exercise12;

import java.util.ArrayList;

public class CarService {

    private ArrayList<Car> carList;

    public CarService(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void deleteFromList(Car car) {
        carList.remove(car);
    }

    public ArrayList<Car> getCars() {
        return carList;
    }

    public ArrayList<Car> getCarListWithEngine(EngineType engineType) {
        ArrayList<Car> carsWithEngine = new ArrayList<>();

        for (Car car : carList) {
            if (car.getEngineType().equals(engineType)) {
                carsWithEngine.add(car);
            }
        }

        return carsWithEngine;
    }

    public ArrayList<Car> getCarsProducedBefore(int producedYears) {
        ArrayList<Car> carsProducedBefore = new ArrayList<>();

        for (Car car : carList) {
            if (car.getYearOfManufacture() == producedYears) {
                carsProducedBefore.add(car);
            }
        }

        return carsProducedBefore;
    }

    public Car getMostExpensiveCar() {
//        Car car = carList.stream().
//                max(((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()))).orElse(null);

        double price = 0;
        Car theMostExpensiveCar = null;

        for (Car car : carList) {
            if (car.getPrice() > price) {
                theMostExpensiveCar = car;
                price = car.getPrice();
            }
        }

        return theMostExpensiveCar;
    }


    public Car getCheapestCar() {
        double price = Double.MAX_VALUE;
        Car theCheapestCar = null;

        for (Car car : carList) {
            if (car.getPrice() < price) {
                theCheapestCar = car;
                price = car.getPrice();
            }
        }

        return theCheapestCar;
    }

    public ArrayList<Car> getCarsWithAtleastManufactures(int numberOfManufactures) {
        ArrayList<Car> carsWithAtleastManufactures = new ArrayList<>();

        carList.forEach(car -> {
            if (car.getManufacturerList().size() >= numberOfManufactures) {
                carsWithAtleastManufactures.add(car);
            }
        });

        return carsWithAtleastManufactures;
    }

    public ArrayList<Car> getSortedCarsList(SortOrder sortOrder) {

        if (SortOrder.ASCENDING.equals(sortOrder)) {
            carList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        }

        if (SortOrder.DESCENDING.equals(sortOrder)) {
            carList.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
        }

        return carList;
    }

    public boolean ifSpecificCarIsOnTheList(Car car){
        return carList.contains(car);
    }

    public ArrayList<Car> getCarsListByManufacturer(Manufacturer manufacturer){
        ArrayList<Car> carsByManufacturer = new ArrayList<>();

        for(Car car : carList){
            if(car.getManufacturerList().contains(manufacturer)){
                carsByManufacturer.add(car);
            }
        }

        return carsByManufacturer;
    }

    public ArrayList<Car> getCarListByManufacturerByEstablishmentYears(int yearOfEstablishment, String symbol){
        ArrayList<Car> carListByManufacturerByEstablishmentYears = new ArrayList<>();

        for(Car car : carList){
            for(Manufacturer manufacturer : car.getManufacturerList()){
                switch (symbol){
                    case "<":
                        if(manufacturer.getYearOfEstablishment() < yearOfEstablishment){
                            carListByManufacturerByEstablishmentYears.add(car);
                        }
                        break;
                    case ">" :
                        if(manufacturer.getYearOfEstablishment() > yearOfEstablishment){
                            carListByManufacturerByEstablishmentYears.add(car);
                        }
                        break;
                    case "<=" :
                        if(manufacturer.getYearOfEstablishment() <= yearOfEstablishment){
                            carListByManufacturerByEstablishmentYears.add(car);
                        }
                        break;
                    case ">=" :
                        if(manufacturer.getYearOfEstablishment() >= yearOfEstablishment){
                            carListByManufacturerByEstablishmentYears.add(car);
                        }
                        break;
                    case "=":
                        if(manufacturer.getYearOfEstablishment() == yearOfEstablishment){
                            carListByManufacturerByEstablishmentYears.add(car);
                        }
                        break;
                    case "!=":
                        if(manufacturer.getYearOfEstablishment() != yearOfEstablishment){
                            carListByManufacturerByEstablishmentYears.add(car);
                        }
                        break;
                    default:
                        System.out.println("Atsiprasome, bet toks veiksmas negalimas.");
                }
            }
        }

        return carListByManufacturerByEstablishmentYears;
    }
}
