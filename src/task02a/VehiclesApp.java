package task02a;

import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VehiclesApp {
    public static void main(String[] args) {

        try {
            Queue<Vehicle> vehicleQueue = getStoredData();
            queueController(vehicleQueue);
        } catch (InputMismatchException ex) {
            System.err.println("Wprowadzono niepoprawny typ.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static Queue<Vehicle> getStoredData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("vehicles.txt")));
        Queue<Vehicle> vehicleQueue = new LinkedList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] vehicle = line.split(";");
            vehicleQueue.offer(new Vehicle(vehicle[0], vehicle[1], vehicle[2], Integer.parseInt(vehicle[3]), Integer.parseInt(vehicle[4]), vehicle[5]));
        }
        bufferedReader.close();
        return vehicleQueue;
    }

    private static void queueController(Queue<Vehicle> vehicleQueue) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("MENU:");
            System.out.println("0 - Zakończ działanie programu.");
            System.out.println("1 - Dodaj nowy pojazd do kolejki");
            System.out.println("2 - Zrób przegląd pojazdu z kolejki");
            System.out.println("Wybierz opcję: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    terminateApplication(vehicleQueue);
                    break;
                case 1:
                    vehicleQueue.offer(addNewVehicle(scanner));
                    System.out.println("\nDodano pojazd do kolejki\n");
                    break;
                case 2:
                    inspectNextVehicle(vehicleQueue);
                    break;
                default:
                    System.out.println("\nPodano niepoprawną opcję. Spróbuj ponownie. \n");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void terminateApplication(Queue<Vehicle> vehicleQueue) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("vehicles.txt")));
        if (vehicleQueue.peek() != null) {
            while (vehicleQueue.peek() != null) {
                Vehicle remainingVehicle = vehicleQueue.poll();
                bufferedWriter.write(remainingVehicle.toCsv());
                bufferedWriter.newLine();
            }
        } else {
            bufferedWriter.write("");
        }
        bufferedWriter.close();
        System.out.println("\nZakończenie działania aplikacji.\n");
        System.exit(0);
    }

    private static Vehicle addNewVehicle(Scanner scanner) {
        System.out.println("Podaj typ:");
        String type = scanner.nextLine();
        System.out.println("Podaj markę:");
        String brand = scanner.nextLine();
        System.out.println("Podaj model:");
        String model = scanner.nextLine();
        System.out.println("Podaj rok:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj przebieg:");
        int mileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj VIN:");
        String vin = scanner.nextLine();

        return new Vehicle(type, brand, model, year, mileage, vin);
    }

    private static void inspectNextVehicle(Queue<Vehicle> vehicleQueue) {
        if (vehicleQueue.peek() != null) {
            System.out.println("\nPojazd " + vehicleQueue.poll() + " pomyślnie przeszedł przeszedł przegląd.\n");
        } else {
            System.out.println("\nNie ma pojazdów w kolejce do przeglądu.\n");
        }
    }
}

