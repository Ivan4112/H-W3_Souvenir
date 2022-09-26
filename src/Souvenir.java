import java.util.Date;

@SuppressWarnings("deprecation")
public class Souvenir {
    private String nameSouvenir;
    private int idManufacturer;
    private Manufacturer manufacturer;
    private Date dateRelease;
    private double price;

    public Souvenir(int requisite, String nameSouvenir, Date dateRelease, double price) {
        this.idManufacturer = requisite;
        this.nameSouvenir = nameSouvenir;
        this.dateRelease = dateRelease;
        this.price = price;
    }

    public String getNameSouvenir() {
        return nameSouvenir;
    }

    public void setNameSouvenir(String nameSouvenir) {
        this.nameSouvenir = nameSouvenir;
    }
    public int getIdManufacturer() { return idManufacturer; }

    public void setIdManufacturer(int requisite) {
        this.idManufacturer = requisite;
    }

    public Date getDateRelease() { return dateRelease; }

    public void setDateRelease(Date dateRelease) { this.dateRelease = dateRelease; }
    public double getPrice() {return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return  String.format("%-2d %-9s %-3d %-3d %-3d %-6.1f", idManufacturer, nameSouvenir, dateRelease.getYear(),
                dateRelease.getMonth(), dateRelease.getDay(), price);
    }
}