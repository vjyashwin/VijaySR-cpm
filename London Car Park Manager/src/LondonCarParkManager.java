/**
 * @author vjyashwin
 *
 *This is the Main class which implements the park, unpark, availability of parking
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class LondonCarParkManager {
	
	
	 Scanner sc = new Scanner(System.in);

	    static int parkingSlotCount = 10; //total parking slots are 10
	    static int carCounter;
	    static int ticketNumber = 5000; //ticket number always starts with 5000
	    static EmptyParkingSlot emptySlot = new EmptyParkingSlot("Empty");
	    static List<Vehicle> slots = new ArrayList<Vehicle>();
	  
	    
	

	public static void main(String[] args) {
		
		 	System.out.println();
		 	System.out.println();
		 	System.out.println("\t  London Car Park Management System");
	        System.out.println();
	        System.out.println();
	        
	        LondonCarParkManager carParkManager = new LondonCarParkManager();
	        carParkManager.displayMainMenu();
		}
	
	/**
	 * 
	 * Method to display the menu for the car parking 
	 * 
	 */
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
                	carParkManager.unparkCar();
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
	
	/**
	 * This is the method which implements the parking of the car based on the available slots
	 * The parkings are allowed till the freeslots are available and after that the parking are restricted
	 * A parked car is provided with a ticket no starting from 5000
	 * 
	 */
	
	
	
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
                returnToMenu();
              
                  } else {
                return;
            }
        }catch (InputMismatchException ex){ 
            System.out.println("\nInvalid Input. Please try again.");
            sc.hasNextInt();
          
        }

    }
	
	/**
	 * This method will find out the free slots for the parking and if the slots are zero 
	 * it will restrict further parking
	 */
	
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
	
	/**
	 * 
	 * This method is used to unpark the car. unpark the car and increment the freeslots count
	 */
	
	public void unparkCar(){

        System.out.println();
        System.out.println("                  Delete a vehicle                   \n ");
        if (carCounter == 0) {
            System.out.println("Cannot Perform this action as there are no cars parked");
       }else {
            System.out.println("List of cars in the parking\n");
            for (Vehicle vehicle : slots) {
                String ID = vehicle.getIdPlate();
                if (ID != null)
                    System.out.println("\t" + ID+ "Ticket no is: "+ticketNumber);
            }
            System.out.println("\n your car's resiration number? : ");

            try {

                String unparkCar = sc.next();
                parkingSlotCount++;
                carCounter--;
                               slots.remove(getIndexByProperty(unparkCar));

            } catch (Exception e) {
               System.out.print(e);
            }
        }
        returnToMenu();
      }
	
	/**
	 * This method will get the registration id for the car and then validates if the car bearing
	 * the ID is being parked in the parking lot.
	 * @param yourString
	 * @return
	 */
	
	 private int getIndexByProperty(String yourString) {
	        for (int i = 0; i < slots.size(); i++) {
	            if (slots.get(i).getIdPlate() !=null && slots.get(i).getIdPlate().equalsIgnoreCase(yourString)) {
	              return i;
	            }
	        }
	        System.out.println("\nSorry! There is no car parked with the specified ID plate.\n");
	        return -1;
	    }
	
	 /**
	  * This method get the input from the user whether to continue with the main menu or to exit the menu.
	  * 
	  */
	 public void returnToMenu(){
	        try {

	            System.out.println("\n\tDo you want to continue with main menu?\n");
	            System.out.println(" Please select your option \n 1. Yes \n 2. No");

	            switch (sc.nextInt() ){
	                //will go to the main menu
	                case 1:
	                    displayMainMenu();
	                    break;
	                //will terminate the program
	                case 2:
	                    System.exit(0);
	                    break;
	                //to track invalid options
	                default:
	                    System.out.println("\nInvalid option!");
	                    displayMainMenu();
	                    break;
	            }

	        }catch (Exception ex3){
	            System.out.println("\nInvalid option!");
	            displayMainMenu(); //return
	        }


	    }
	
	

}
