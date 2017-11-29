
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import org.jboss.logging.Logger;

    /* FACHADA */
public class Service implements Garage {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Add.class.getName());

    private HashMap<String, Car> cars;

    public Service() {
        cars = Singleton.getCars();
        if(cars.isEmpty()){
            fillHashMap();
        }
    }
    
     private void fillHashMap() {
        addCar(new Car("0000fzv", "Verso",
                "Toyota", "Blanco"));
        addCar(new Car("0001fzv", "Corolla",
                "Toyota", "Azul"));
        addCar(new Car("0002fzv", "Clio",
                "Renault", "Negro"));
        addCar(new Car("0003fzv", "Megane",
                "Renault", "Verde"));
        addCar(new Car("0004fzv", "Polo",
                "Volkswagen", "Blanco"));
        addCar(new Car("0005fzv", "Golf",
                "Volkswagen", "Rojo"));
        addCar(new Car("0006fzv", "RX-7",
                "Mazda", "Negro"));
        addCar(new Car("0007fzv", "Transporter",
                "Volkswagen", "Azul"));
        addCar(new Car("0008fzv", "Impreza",
                "Subary", "Azul"));
        addCar(new Car("0009fzv", "Jeep",
                "Cheroke", "Gris"));
        addCar(new Car("0010fzv", "Zafira",
                "Opel", "Negro"));
    }

    public HashMap<String, Car> getCars() {
        return cars;
    }

    public void setCars(HashMap<String, Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> findAll() {
        if (!cars.isEmpty()) {
            ArrayList<Car> list = new ArrayList<>((Collection<Car>) cars.values());
            list.sort((Car a, Car b) -> a.getLicense().compareTo(b.getLicense()));
            return list;
        } else {
            return null;
        }
    }

    /*
        lista.sort(new Comparator<Car>() {
        @Override
        public Car compare(Car a, Car b) {
            return a.getLicense().compareTo(b.getLicense());
            }
        });
     */
    @Override
    public Car findCar(Car car) {
        if (car.getLicense() != null && cars != null) {
            return cars.get(car.getLicense());
        } else {
            return null;
        }
    }

    @Override
    public Car addCar(Car car) {
        if (car.getLicense() != null && cars != null) {
            if (!cars.containsKey(car.getLicense())) {
                cars.put(car.getLicense(), car);
                return cars.get(car.getLicense());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Car updateCar(Car car) {
        Car old;
        if (car.getLicense() != null && cars != null) {
            if (cars.containsKey(car.getLicense())) {
                old = cars.get(car.getLicense());
                cars.put(car.getLicense(), car);
                return old;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Car deleteCar(Car car) {
        Car deleted;
        if (car.getLicense() != null && cars != null) {
            if (cars.containsKey(car.getLicense())) {
                deleted = cars.get(car.getLicense());
                cars.remove(car.getLicense());
                return deleted;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
