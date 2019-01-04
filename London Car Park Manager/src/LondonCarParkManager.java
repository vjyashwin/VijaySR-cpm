import java.util.InputMismatchException;
import java.util.Scanner;


public class LondonCarParkManager {
	
	
	 Scanner sc = new Scanner(System.in);

	    static int parkingSlotCount = 10;
	    static int carCounter;
	    static int ticketNumber = 5000;
	    static EmptyParkingSlot emptySlot = new EmptyParkingSlot("Empty");
	    
	

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
              
             if (parkingSlotCount > 0) {
            	
            	Car car = new Car();
               System.out.println("\n\t# # # # Add a car to the park # # # # ");
                System.out.println("\nPlease enter the ID Plate number of the Car");
                car.setIdPlate(sc.next());
                parkingSlotCount--;
                carCounter++;
                ticketNumber++;
                System.out.println("Your Vehicle ID is: "+car.getIdPlate());
                System.out.println("\n your Parking Tocket no is: "+ticketNumber);
              
                  } else {
                return;
            }
        }catch (InputMismatchException ex){ 
            System.out.println("\nInvalid Input. Please try again.");
            sc.hasNextInt();
          
        }

    }
	
	
	
	

}
