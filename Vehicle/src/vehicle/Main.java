/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

/**
 * BSCIT-01-0016/2024
 * Lyeon Ndungu
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Car class with encapsulation
class Car {
    private String make;
    private String model;
    private boolean isAvailable;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.isAvailable = true; // Cars are available by default
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available; // Update availability status
    }
}

// Customer class with encapsulation
class Customer {
    private String name;

    public Customer(String name) {
        this.name = name; // Set customer name
    }

    public String getName() {
        return name; // Get customer name
    }
}

// RentalAgency class managing cars and customers
class RentalAgency {
    private String name;
    private List<Car> cars; // List to hold cars
    private List<Customer> customers; // List to hold customers

    public RentalAgency(String name) {
        this.name = name; // Set agency name
        this.cars = new ArrayList<>(); // Initialize cars list
        this.customers = new ArrayList<>(); // Initialize customers list
    }

    public String getName() {
        return name; // Get agency name
    }

    public void addCar(Car car) {
        cars.add(car); // Add a new car to the agency
        System.out.println("Car added: " + car.getMake() + " " + car.getModel() + " to " + name);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer); // Add a new customer to the agency
        System.out.println("Customer added: " + customer.getName() + " to " + name);
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars in " + name + ":");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.isAvailable()) {
                System.out.println((i + 1) + ". " + car.getMake() + " " + car.getModel()); // Display available cars
            }
        }
    }

    public Car getCar(int index) {
        if (index >= 0 && index < cars.size()) {
            return cars.get(index); // Get car by index
        }
        return null; // Return null if index is out of bounds
    }

    public void displayCustomers() {
        System.out.println("Customers in " + name + ":");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName()); // Display customers
        }
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index); // Get customer by index
        }
        return null; // Return null if index is out of bounds
    }

    public boolean rentCar(Customer customer, Car car) {
        if (car.isAvailable()) {
            car.setAvailable(false); // Mark car as rented
            System.out.println("Car rented: " + car.getMake() + " " + car.getModel() + " to " + customer.getName());
            return true; // Return true if rent was successful
        } else {
            System.out.println("Car not available. Please select another vehicle."); // Handle car not available case
            return false; // Return false if rent failed
        }
    }

    public void returnCar(Car car) {
        car.setAvailable(true); // Mark car as available
        System.out.println("Car returned: " + car.getMake() + " " + car.getModel());
    }

    public List<Car> getCars() {
        return cars; // Return list of cars
    }

    public List<Customer> getCustomers() {
        return customers; // Return list of customers
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create multiple rental agencies
        List<RentalAgency> agencies = new ArrayList<>();
        agencies.add(new RentalAgency("Kenol Rentals"));
        agencies.add(new RentalAgency("Mwea Rentals"));
        agencies.add(new RentalAgency("Sagana Rentals"));

        // Add some cars to each agency
        agencies.get(0).addCar(new Car("Toyota", "Corolla"));
        agencies.get(0).addCar(new Car("Honda", "Civic"));
        agencies.get(1).addCar(new Car("Ford", "Fiesta"));
        agencies.get(1).addCar(new Car("Chevrolet", "Malibu"));
        agencies.get(2).addCar(new Car("Nissan", "Sentra"));
        agencies.get(2).addCar(new Car("Hyundai", "Elantra"));

        while (true) {
            System.out.println("\nSelect a rental agency (or enter 0 to exit):");
            for (int i = 0; i < agencies.size(); i++) {
                System.out.println((i + 1) + ". " + agencies.get(i).getName()); // Display agencies
            }

            int agencySelection = getIntInput(scanner, 0, agencies.size()) - 1;

            if (agencySelection == -1) break; // Exit the system

            RentalAgency selectedAgency = agencies.get(agencySelection);

            while (true) {
                System.out.println("\n--- " + selectedAgency.getName() + " ---");
                System.out.println("1. Add New Customer");
                System.out.println("2. Select Existing Customer");
                System.out.println("3. Exit");

                int customerOption = getIntInput(scanner, 1, 3);
                Customer selectedCustomer = null;

                if (customerOption == 1) {
                    // Add new customer
                    System.out.println("Enter customer name:");
                    String customerName = scanner.nextLine();
                    if (!customerName.trim().isEmpty()) {
                        Customer customer = new Customer(customerName);
                        selectedAgency.addCustomer(customer); // Add customer to agency
                        selectedCustomer = customer; // Set selected customer
                    } else {
                        System.out.println("Invalid input. Customer name cannot be empty.");
                        continue; // Restart customer menu
                    }

                } else if (customerOption == 2) {
                    // Select existing customer
                    while (true) {
                        selectedAgency.displayCustomers(); // Show customers
                        System.out.println("Select a customer by entering the number:");

                        int customerSelection = getIntInput(scanner, 1, selectedAgency.getCustomers().size()) - 1;
                        selectedCustomer = selectedAgency.getCustomer(customerSelection);

                        if (selectedCustomer != null) {
                            break; // Valid customer selected
                        } else {
                            System.out.println("Customer does not exist. Please select another customer.");
                        }
                    }
                } else {
                    break; // Exit to main menu
                }

                if (selectedCustomer != null) {
                    while (true) {
                        selectedAgency.displayAvailableCars(); // Show available cars
                        System.out.println("Select a car by entering the number (or enter 0 to exit):");
                        int carSelection = getIntInput(scanner, 0, selectedAgency.getCars().size()) - 1;

                        if (carSelection == -1) break; // Exit to customer menu

                        Car selectedCar = selectedAgency.getCar(carSelection);

                        if (selectedCar != null) {
                            if (selectedAgency.rentCar(selectedCustomer, selectedCar)) {
                                while (true) {
                                    System.out.println("Do you want to return the car? (yes/no, or enter 0 to exit)");
                                    String returnChoice = scanner.nextLine();
                                    if (returnChoice.equalsIgnoreCase("yes")) {
                                        selectedAgency.returnCar(selectedCar); // Return the car
                                        break; // Exit to car selection loop
                                    } else if (returnChoice.equalsIgnoreCase("no")) {
                                        break; // Back to car selection
                                    } else if (returnChoice.equals("0")) {
                                        break; // Exit to customer menu
                                    } else {
                                        System.out.println("Invalid input. Please enter yes or no.");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid car selection."); // Handle invalid car selection
                        }
                    }
                }
            }
        }

        scanner.close(); // Close scanner
    }

    // Method to get an integer input with validation
    private static int getIntInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input; // Return valid input
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number .");
            }
        }
    }
}






