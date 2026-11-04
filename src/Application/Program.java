package Application;

import Model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
        public static void  main(String[] args) {

            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {
                System.out.print("Room Number:  ");
                int number = sc.nextInt();
                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy):  ");
                Date CheckOut = sdf.parse(sc.next());

                Model.Entities.Reservation reservation = new Model.Entities.Reservation(number, checkIn, CheckOut);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation: ");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy):  ");
                CheckOut = sdf.parse(sc.next());

                reservation.updateDates(checkIn, CheckOut);
                System.out.println("Reservation: " + reservation);
              }
            catch (ParseException e) {
                System.out.println("Invalid date Format");
            }
            catch (DomainException e) {
                System.out.println("Error in reservation: " + e.getMessage());
            }
            catch (RuntimeException e) {
                System.out.println("Unexpected error");
            }


            sc.close();

        }
}
