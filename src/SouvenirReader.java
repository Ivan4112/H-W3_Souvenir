import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@SuppressWarnings({"deprecation", "MagicConstant"})
public class SouvenirReader {
    List<Souvenir> souvenirList = new ArrayList<>();
    public List<Souvenir> readSouvenirs() throws FileNotFoundException {
        final String fileNameSouvenirs = "Souvenirs";
        File file = new File(fileNameSouvenirs);
        Scanner scanner = new Scanner(file);

        StringTokenizer token;

        String nameSouvenir;
        int idManufacturer, year, day, month;
        double price;

        while (scanner.hasNextLine()){
            token = new StringTokenizer(scanner.nextLine(), ",");
            idManufacturer = Integer.parseInt(token.nextToken());
            nameSouvenir = token.nextToken();
            year = Integer.parseInt(token.nextToken());
            month = Integer.parseInt(token.nextToken());
            day = Integer.parseInt(token.nextToken());
            price = Double.parseDouble(token.nextToken());

            Souvenir souvenir = new Souvenir(idManufacturer, nameSouvenir, new Date(year,month,day), price);
            souvenirList.add(souvenir);
        }
        return souvenirList;
    }
}
