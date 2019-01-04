

/**
 * @author Vijay Srinivasa Raghavan
 *
 */
public class EmptyParkingSlot extends Vehicle{

    private String availability;

    public EmptyParkingSlot(String availability){
        this.availability = availability;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    
    public String toString() {
        return availability;
    }

   //abstract methods which are in the vehicle class
    public String getIdPlate() {return idPlate;}

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

   
}
