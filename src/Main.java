import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings({"deprecation", "MagicConstant"})
public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listId = new ArrayList<>();

        List<Manufacturer> manufacturerList;
        List<Souvenir> souvenirList;
        int control = -1;

        //wrote data about souvenir in array
        SouvenirReader souvenirReader = new SouvenirReader();
        souvenirList = souvenirReader.readSouvenirs();

        //wrote data about manufacturer in array
        ManufacturerReader mr = new ManufacturerReader();
        manufacturerList = mr.readManufacturer();
        for (Manufacturer m : manufacturerList)
            listId.add(Integer.parseInt(m.toString().substring(0,1)));


        //add function of edit info
        System.out.println("""
                ----Program menu----
                1 Show data with arrays
                2 Add manufacturer in the array
                3 Add souvenir in the array
                4 Find all souvenirs by manufacturer
                5 Find all souvenirs by country
                6 Show info about manufacturer by Price
                7 Show info about manufacturer&your souvenirs
                8 Show info about manufacturer by Date
                9 Show info about souvenirs by Date
                10 Delete the manufacturer and your souvenirs
                0 Exit""");

        while (control!=0){
            System.out.print("\nEnter the point of menu -> "); control = scanner.nextInt();

            String nameSouvenir, nameManufacturer, countryManufacturer;
            int idManufact,idManufacturer, year, day, month;
            double price;
            boolean checkAppearElement;

            switch (control) {
                case 1 -> {
                    System.out.printf("%-2s %-10s %-3s %-3s %-3s %-6s", "Id", "Souvenir", "Y", "M", "D", "Price\n");
                    for (Souvenir s : souvenirList)
                        System.out.println(s);
                    System.out.println();
                    System.out.printf("%-2s %-14s %-6s", "Id", "Manufacturer", "Country\n");
                    for (Manufacturer m : manufacturerList)
                        System.out.println(m);
                }
                case 2 -> {
                        System.out.print("Add manufacturer\nInput id manufacturer -> "); idManufacturer = scanner.nextInt();
                        System.out.print("Input name manufacturer -> "); nameManufacturer = scanner.next();
                        System.out.print("Input country manufacturer -> "); countryManufacturer = scanner.next();

                        checkAppearElement = manufacturerList.stream().allMatch(id -> id.getIdManufacturer() != idManufacturer);

                        if (checkAppearElement) {
                            listId.add(idManufacturer);
                            manufacturerList.add(new Manufacturer(idManufacturer, nameManufacturer, countryManufacturer));
                            System.out.println("Data added success ...");
                        } else System.out.println("Id this company already exist.");
                }
                case 3 -> {
                        System.out.print("Add souvenir\nInput name souvenir -> "); nameSouvenir = scanner.next();
                        System.out.print("Input request manufacturer -> "); idManufact = scanner.nextInt();
                        System.out.print("Input year created -> "); year = scanner.nextInt();
                        System.out.print("Input month created -> "); month = scanner.nextInt();
                        System.out.print("Input day created -> "); day = scanner.nextInt();
                        System.out.print("Input price of the souvenir -> "); price = scanner.nextDouble();

                        checkAppearElement = manufacturerList.stream().anyMatch(id -> id.getIdManufacturer() == idManufact);
                        if (checkAppearElement) {
                            souvenirList.add(new Souvenir(idManufact, nameSouvenir, new Date(year, month, day), price));
                            System.out.println("Data added success ...");
                        } else System.out.println("This company doesn't exist. Choose right company");
                }
                case 4 -> {
                    System.out.print("Find souvenirs by manufacturer\nInput id manufacturer -> "); idManufact = scanner.nextInt();
                    checkAppearElement = souvenirList.stream().anyMatch(id -> id.getIdManufacturer() == idManufact);
                    if (checkAppearElement)
                        souvenirList.stream().filter(comp -> comp.getIdManufacturer() == idManufact).forEach(System.out::println);
                    else System.out.println("This company doesn't exist. Enter the right id again");
                }
                case 5 -> {
                    System.out.print("Find souvenirs by country\nInput country manufacturer -> "); countryManufacturer = scanner.next();

                    List<Manufacturer> filterList; // for elements which will be filtered
                    filterList = manufacturerList.stream().filter(country -> countryManufacturer.equals(country.getCountryManufacturer()))
                            .collect(Collectors.toList());

                    if(!filterList.isEmpty()){
                        int id;
                        for (Manufacturer m: filterList){
                            id = Integer.parseInt(m.toString().substring(0,1));
                            int finalId = id;
                            souvenirList.stream().filter(com -> com.getIdManufacturer() == finalId).forEach(System.out::println);
                        }
                    }
                    else System.out.println("Such souvenirs don't exist");
                }
                case 6 -> {
                    System.out.print("Input price (,) of the souvenir -> "); price = scanner.nextDouble();
                    List<Souvenir> filterList;
                    filterList = souvenirList.stream().filter(p -> p.getPrice()<price).collect(Collectors.toList());

                    if(!filterList.isEmpty()){
                        int id;
                        for (Souvenir s: filterList){
                            id = Integer.parseInt(s.toString().substring(0,1));
                            int finalId = id;
                            manufacturerList.stream().filter(com -> com.getIdManufacturer() == finalId).forEach(System.out::println);
                        }
                    }
                    else System.out.println("Such souvenirs don't exist");

                }
                case 7 -> {
                    for(int i = 0; i < listId.size(); i++){
                        int finalI = i;
                        System.out.println("**************Company**************");
                        manufacturerList.stream().filter(n -> n.getIdManufacturer() == listId.get(finalI)).forEach(System.out::println);
                        System.out.println("********Company's souvenirs********");
                        souvenirList.stream().filter(numb -> numb.getIdManufacturer() == listId.get(finalI)).forEach(System.out::println);
                        System.out.println();
                    }
                }
                case 8 -> {
                    int souvenirYear; List<Souvenir> filterList;
                    System.out.print("Input year the souvenir was created "); souvenirYear = scanner.nextInt();
                    filterList = souvenirList.stream().filter(d -> d.getDateRelease().getYear() == souvenirYear).collect(Collectors.toList());

                    if(!filterList.isEmpty()){
                        int id;
                        for (Souvenir s: filterList){
                            id = Integer.parseInt(s.toString().substring(0,1));
                            int finalId = id;
                            manufacturerList.stream().filter(com -> com.getIdManufacturer() == finalId).forEach(System.out::println);
                        }
                    }
                }
                case 9 -> {
                    //System.out.print("Input year the souvenir was created "); souvenirYear = scanner.nextInt(); int souvenirYear;
                    Map<Object, List<Souvenir>> filterList = souvenirList.stream() //.filter(d->d.getDateRelease().getYear() == souvenirYear)
                                .collect(Collectors.groupingBy(g -> g.getDateRelease().getYear(), Collectors.toList()));
                    System.out.println(filterList);
                }
                case 10 -> {
                    Iterator<Manufacturer> iterManufacturer = manufacturerList.listIterator();
                    Iterator<Souvenir> iterSouvenir = souvenirList.listIterator();
                    Iterator<Integer> iterId = listId.listIterator();

                    int idOfDeleted = -1;
                    System.out.print("Input name the manufacturer "); nameManufacturer = scanner.next();

                    List<Manufacturer> filterList = manufacturerList.stream()
                            .filter(n -> nameManufacturer.equals(n.getNameManufacturer())).toList();
                    if(filterList.isEmpty()) System.out.println("Such company doesn't exist");
                    else {
                        for (Manufacturer m : filterList)
                            idOfDeleted = Integer.parseInt(m.toString().substring(0, 1));

                        while (iterId.hasNext()) {
                            Integer lId = iterId.next();
                            if (lId == idOfDeleted)
                                iterId.remove();
                        }

                        while (iterManufacturer.hasNext()) {
                            Manufacturer mList = iterManufacturer.next();
                            if (mList.getNameManufacturer().equals(nameManufacturer))
                                iterManufacturer.remove();
                        }


                        while (iterSouvenir.hasNext()) {
                            Souvenir sList = iterSouvenir.next();
                            if (sList.getIdManufacturer() == idOfDeleted)
                                iterSouvenir.remove();
                        }
                    }
                    souvenirList.forEach(System.out::println);System.out.println();
                    manufacturerList.forEach(System.out::println);

                }
            }
        }

    }
}
