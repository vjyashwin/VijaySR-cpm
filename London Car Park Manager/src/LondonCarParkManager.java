import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class LondonCarParkManager {
	
	
	 Scanner sc = new Scanner(System.in);

	    static int parkingSlotCount = 10;
	    static int carCounter;
	    static int ticketNumber = 5000;
	    static EmptyParkingSlot emptySlot = new EmptyParkingSlot("Empty");
	    //static List<Vehicle> slots = new ArrayList<Vehicle>();
	    static List slots = new ArrayList();
	    
	

	public static void main(String[] args) {
		
		 	System.out.println();
		 	System.out.println();
		 	System.out.println("\t  London Car Park Management System");
	        System.out.println();
	        System.out.println();
	        
	        LondonCarParkManager carParkManager = new LondonCarParkManager();
	        carParkManager.displayMainMenu();
		}
	
	public void displayMainMenu(){
        try {
            sc = new Scanner(System.in);
            int SelectedOption;

            LondonCarParkManager carParkManager = new LondonCarParkManager();
            System.out.println("                      Main Menu                       ");
            System.out.println();
            System.out.println("1. Park a car");
            System.out.println();
            System.out.println("2. Depart a Car");
            System.out.println();
            System.out.println("3. Compact the cars");
            System.out.println();
            System.out.println("0. Exit Menu");
            System.out.println();
            System.out.print("Please enter your option: ");
            SelectedOption = sc.nextInt();
          
            switch (SelectedOption) {
                case 1:
                	carParkManager.parkCar();
                    break;
                case 2:
                    break;
                case 3:
                   break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("\nYou have entered an invalid option!");
                    System.out.println();
                    displayMainMenu();
                    break;

            }
        }catch (Exception e) {
           System.out.println("\nInvalid option!");
           sc.hasNextInt();
           displayMainMenu();
        }

    }
	
	
	
	public void parkCar(){
        try {
            sc = new Scanner(System.in);
            trackFreeSlots();              
             if (parkingSlotCount > 0) {
            	
            	Car car = new Car();
            	System.out.println("\n\t        Add a car to the park         ");
                System.out.println("\nPlease enter the ID Plate number of the Car");
                car.setIdPlate(sc.next());
                slots.add(car);
                parkingSlotCount--;
                carCounter++;
                ticketNumber++;
                System.out.println("Your Car's registration ID is: "+car.getIdPlate());
                System.out.println("\n your Parking Tocket no is: "+ticketNumber);
              
                  } else {
                return;
            }
        }catch (InputMismatchException ex){ 
            System.out.println("\nInvalid Input. Please try again.");
            sc.hasNextInt();
          
        }

    }
	
	public void trackFreeSlots(){
        if(parkingSlotCount >0){
            if (parkingSlotCount == 1) {
                System.out.println("Hopefully, there's a parking slot remaining");
            }else {
                System.out.println(" \n There are " + parkingSlotCount + " remaining. \n");                
            }
        }else {
            System.out.println("\nThere are no remaining slots. \nThanks");
            displayMainMenu();
        }
    }
	
	
	
	

}
