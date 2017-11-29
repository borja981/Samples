import java.util.HashMap;

//Para asegurar una única instancia de un objeto aún con multihilo o servicio
//Patrón Singleton. Atributo, constructor y métodos estáticos

public class Singleton{

    private static HashMap<String,Car> cars;

    private Singleton() {
    }

    public static HashMap getCars() {
        if (cars == null || cars.isEmpty()) {
            return new HashMap<String, Car>();
        } else {
            return cars;
        }
    }
}
