import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ManufacturerReader {
    List<Manufacturer> manufacturerList = new ArrayList<>();

    public List<Manufacturer> readManufacturer() throws FileNotFoundException {
        String fileNameManufacturer = "Manufacturer";
        File file = new File(fileNameManufacturer);
        Scanner scanner = new Scanner(file);

        StringTokenizer token;

        int idManufacturer;
        String nameManufacturer;
        String countryManufacturer;

        while (scanner.hasNextLine()){
            token = new StringTokenizer(scanner.nextLine(), ",");
            idManufacturer = Integer.parseInt(token.nextToken());
            nameManufacturer = token.nextToken();
            countryManufacturer = token.nextToken();

            Manufacturer manufacturer = new Manufacturer(idManufacturer,nameManufacturer,countryManufacturer);
            manufacturerList.add(manufacturer);
        }
        return manufacturerList;
    }
}
