package Model.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer RoomNumber;
    private Date CheckIn;
    private Date CheckOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        RoomNumber = roomNumber;
        CheckIn = checkIn;
        CheckOut = checkOut;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return CheckIn;
    }

    public Date getCheckOut() {
        return CheckOut;
    }

    public long duration(){
        long diff = CheckOut.getTime() - CheckIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void UpdateDates (Date CheckIn, Date CheckOut){
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
    }
    @Override
    public String toString(){
        return "Room "
                + RoomNumber
                + ", check-in: "
                + sdf.format(CheckIn)
                + ", check-out: "
                + sdf.format(CheckOut)
                + ", "
                + duration()
                + " nights";
    }

}
