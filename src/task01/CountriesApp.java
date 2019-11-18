package task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountriesApp {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("countries.txt")))) {
            Map<String, Country> countryMap = getCountries(bufferedReader);
            printCountry(countryMap);
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }

    private static Map<String, Country> getCountries (BufferedReader bufferedReader) throws IOException {
        Map<String, Country> countryMap = new HashMap<>();

        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] country = line.split(";");
            String id = country[0];
            countryMap.put(id, new Country(id, country[1], Integer.parseInt(country[2])));
        }
        return countryMap;

    }

    private static void printCountry(Map<String, Country> countryMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(countryMap.keySet());
        System.out.print("Podaj id kraju: ");
        String id = scanner.nextLine();
        if(countryMap.containsKey(id)){
            System.out.println(countryMap.get(id));
        } else {
            System.out.println("Mapa nie zawiera kraju o takim kodzie.");
        }
        scanner.close();
    }
}