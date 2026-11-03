package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

        public static void  main(String[] args) throws ParseException {

            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Room Number:  ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy):  ");
            Date CheckOut = sdf.parse(sc.next());

            if (!CheckOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                Model.Entities.Reservation reservation = new Model.Entities.Reservation(number, checkIn, CheckOut);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation: ");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy):  ");
                CheckOut = sdf.parse(sc.next());

                Date now = new Date();
                if (checkIn.before(now) || CheckOut.before(now)) {
                    System.out.println("Error in reservation: Reservation dates for update must be future dates");
                } else if (!CheckOut.after(checkIn)) {
                    System.out.println("Error in reservation: Check-out date must be after check-in date");
                } else {
                    reservation.UpdateDates(checkIn, CheckOut);
                    System.out.println("Reservation: " + reservation);
                }
            }















            sc.close();


        }
}
