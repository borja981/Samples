public class Car {
    private String license;
    private String model;
    private String brand;
    private String color;

    public Car() {
    }
    
    public Car(Car car) {
        this.license = car.getLicense();
        this.model = car.getModel();
        this.brand = car.getBrand();
        this.color = car.getColor();
    }

    public Car(String license, String model, String brand, String color) {
        this.license = license;
        this.model = model;
        this.brand = brand;
        this.color = color;
    }
    
    public Car(String license) {
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String matricula) {
        this.license = matricula;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String modelo) {
        this.model = modelo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String marca) {
        this.brand = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
