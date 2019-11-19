package task02a;

class Vehicle {
    private String type;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private String vin;

    Vehicle(String type, String brand, String model, int year, int mileage, String vin) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return type + " " + brand + " " + model + " rocznik " + year + " przebieg " + mileage +
                " VIN " + vin;
    }
    public String toCsv(){
        return type + ";" + brand + ";" + model + ";" + year + ";" + mileage + ";" + vin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}