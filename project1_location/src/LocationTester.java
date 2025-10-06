
import java.util.InputMismatchException;
import java.util.Scanner;

public class LocationTester {

    static final Scanner input = new Scanner(System.in);

    private static void getUserLocation(SimpleLocation other) {
        try {
            System.out.println("Enter your latitude between(-90,90):");
            double lat = input.nextDouble();
            System.out.println("Enter your langitude between(-180,180):");
            double lon = input.nextDouble();
            SimpleLocation userLocation = new SimpleLocation(lat, lon);
            double dis = userLocation.distance(other);
            System.out.printf("Distance between collage and user:%.2f KM%n", dis);

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number not a text");
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Unexpeted Error " + e);
        }
    }

    public static void main(String args[]) {

        SimpleLocation myCollageLocation = new SimpleLocation(32.85112, 12.06121);
        System.out.println("Do you wanna enter your location manually? (yes/no): ");
        String userAnswer = input.nextLine();
        if (userAnswer.toLowerCase().contains("yes")) {
            getUserLocation(myCollageLocation);
            return;
        }
        SimpleLocation myLocation = new SimpleLocation(32.81091, 12.00213);
        double dis = myLocation.distance(myCollageLocation);
        System.out.printf("Distance between collage and me:%.2f KM%n", dis);
    }
}
