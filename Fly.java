public class Fly {
  private   String flightId;
  private   String origin;
  private   String destination;
  private   int day;
  private   int month;
  private   int year;
  private   int min;
  private   int hour;
  private   int price;
  private   int seats;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Fly(String flightId, String origin, String destination, int day, int month, int year, int min, int hour, int price, int seats) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.day = day;
        this.month = month;
        this.year = year;
        this.min = min;
        this.hour = hour;
        this.price = price;
        this.seats = seats;
    }

    public Fly() {
    }
}
