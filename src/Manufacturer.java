public class Manufacturer {
    private int idManufacturer;
    private String nameManufacturer;
    private String countryManufacturer;
    public Manufacturer(int idManufacturer,String nameManufacturer, String countryManufacturer) {
        this.idManufacturer = idManufacturer;
        this.nameManufacturer = nameManufacturer;
        this.countryManufacturer = countryManufacturer;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    public String getCountryManufacturer() {
        return countryManufacturer;
    }

    public void setCountryManufacturer(String countryManufacturer) {
        this.countryManufacturer = countryManufacturer;
    }
    public int getIdManufacturer() {return idManufacturer;}

    public void setIdManufacturer(int idManufacturer) {this.idManufacturer = idManufacturer; }

    @Override
    public String toString() {
        return String.format("%-2d %-15s %-8s",idManufacturer, nameManufacturer, countryManufacturer);
    }
}