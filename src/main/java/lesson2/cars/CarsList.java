package lesson2.cars;

import java.util.ArrayList;
import java.util.List;

public class CarsList {
    private static ArrayList<Car> cars = new ArrayList<Car>();

    static {
        cars.add(new Car("Lada", Type.Sedan));
        cars.add(new Car("Lada", Type.Hatchback));
        cars.add(new Car("Mersedes", Type.Sedan));
        cars.add(new Car("BMW", Type.Crossover));
        cars.add(new Car("Pegout", Type.Crossover));
        cars.add(new Car("Ford", Type.Hatchback));
        cars.add(new Car("Toyota", Type.Sedan));
    }

    public static void main(String[] args) {
        List<Car> carSedan = new ArrayList<>();
        List<Car> carHatchback = new ArrayList<>();
        List<Car> carCrossover = new ArrayList<>();
        for (Car car : cars) {
            if (Type.Sedan.equals(car.getType())) {
                carSedan.add(car);
            } else if (Type.Hatchback.equals(car.getType())) {
                carHatchback.add(car);
            } else if (Type.Crossover.equals(car.getType())) {
                carCrossover.add(car);
            }
        }
        System.out.println(cars);
        System.out.println(carSedan);
        System.out.println(carHatchback);
        System.out.println(carCrossover);
    }

    static class Car {
        private String model;
        private Enum type;

        public Car(String model, Enum type) {
            this.model = model;
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public Enum getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "model='" + model + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    enum Type{
        Sedan, Hatchback, Crossover
    }
}
