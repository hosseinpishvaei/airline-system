import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Passenger[] passenger = new Passenger[50];
        Fly[] fly = new Fly[50];
        Ticket[] ticket = new Ticket[50];
//        fly[0] = new Fly("wx_12", "Yazd", "Tehran", 5, 7, 1401, 30, 15, 1500000, 54);
//        fly[1] = new Fly("wz_15", "Yazd", "Ahvaz", 11, 12, 1401, 0, 8, 900000, 245);
//        fly[2] = new Fly("BG_22", "Shiraz", "Tabriz", 12, 12, 1401, 30, 22, 1100000, 12);
//        fly[3] = new Fly("NM_52", "Tabriz", "Ahvaz", 52, 6, 1401, 25, 15, 2500000, 82);
        MENUE_OPTIONS(passenger, fly, ticket);
    }

    /**
     *This function enters the user's account by getting the details
     */
    public static void sign_in(Passenger[] passenger, Fly[] fly, Ticket[] ticket) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter username: ");
            String user = input.nextLine();
            System.out.print("Enter password: ");
            int pass = input.nextInt();
            if (user.equals("H") && pass == 1)
                admin_MENUE(passenger, fly, ticket);
            for (int i = 0; i < 50; i++) {
                if (passenger[i] != null && passenger[i].getUsername().equals(user) && passenger[i].getPassword() == pass) {
                    passenger_MENUE(passenger, fly, i, ticket);
                    break;
                }
                if (passenger[i] == null) {
                    System.out.println("You are not registered");
                    MENUE_OPTIONS(passenger, fly, ticket);
                    break;
                }
            }
        }
        catch (Exception a)
        {
            System.err.println("The password must be a number");
            MENUE_OPTIONS(passenger,fly,ticket);
        }

    }

    /**
     *This function creates an account for the user by getting the information
     */
    public static void sign_up(Passenger[] passenger, Fly[] fly, Ticket[] ticket) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = input.nextLine();
        System.out.print("Enter password: ");
        int pass = input.nextInt();
        for (int i = 0; i < 50; i++) {
            if (check_passenger(passenger,user))
            {
                if (passenger[i] == null) {
                // System.out.println(i);
                passenger[i] = new Passenger();
                passenger[i].setUsername(user);
                passenger[i].setPassword(pass);
                System.out.println("Your account has been created");
                MENUE_OPTIONS(passenger, fly, ticket);
                break;
             }
            }
            else {
                System.err.println("There is a user with this username");
                sign_up(passenger,fly,ticket);
            }

        }
    }

    /**
     *This function checks if the username is duplicated
     */
    public static boolean check_passenger(Passenger[] passenger,String user)
    {
        for (int i = 0; passenger[i]!=null; i++) {
            if (passenger[i].getUsername().equals(user))
                return false;
        }
        return true;
    }

    /**
     *This function prints the menu and passes it to the desired function according to the user's choice
     */
    public static void MENUE_OPTIONS(Passenger[] passenger, Fly[] fly, Ticket[] ticket) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("MENUE OPTIONS \n <1>sign in \n <2>sign up");
            switch (input.nextInt()) {
                case 1:
                    sign_in(passenger, fly, ticket);
                    break;
                case 2:
                    sign_up(passenger, fly, ticket);
                    break;
                default:
                    System.out.println("Your select invalid!");
                    MENUE_OPTIONS(passenger, fly, ticket);
            }
        }
        catch (Exception b)
        {
            System.err.println("your command must be a number");
            MENUE_OPTIONS(passenger,fly,ticket);
        }

    }

    /**
     *This function prints the admin menu and passes it to the desired function according to the user's choice
     */
    public static void admin_MENUE(Passenger[] passenger, Fly[] fly, Ticket[] ticket) {
        Scanner input = new Scanner(System.in);
        System.out.println("ADMIN MENUE OPTIONS");
        System.out.println("<1>Add \n<2>Update \n<3>Remove \n<4>Flight schedules \n<0>sign out");
        switch (input.nextInt()) {
            case 1: {
                add_flight(passenger, fly, ticket);
                break;
            }
            case 2: {
                update_flight(passenger, fly, ticket);
                break;
            }
            case 3: {
                remove_flight(passenger, fly, ticket);
                break;
            }
            case 4: {
                print_flightList(fly);
                admin_MENUE(passenger, fly, ticket);
                break;
            }
            case 0: {
                MENUE_OPTIONS(passenger, fly, ticket);
                break;
            }
            default: {
                System.out.println("This number is not available");
                admin_MENUE(passenger, fly, ticket);
            }
        }
    }

    /**
     *This function prints all flights
     */
    public static void print_flightList(Fly[] fly) {
        System.out.println("|FlightId" + "\t" + "|" + "origin" + "\t" + "\t" + "|" + "Destination" + "\t" + "|" + "Date" + "\t" + "\t" + "\t" + "|" + "Time" + "\t" + "\t" + "|" +
                "Price" + "\t" + "\t" + "\t" + "|" + "Seats");
        for (int i = 0; i < 50; i++) {
            if (fly[i] != null) {
//                if (i==1)
//                {
//                    System.out.println(fly[i].getFlightId() +"\t"+"\t"+"|"+ fly[i].getOrigin() + "\t"+"|"+ fly[i].getDestination() + "\t" +"\t"+"\t"+"|"+ fly[i].getYear() + "-" +
//                            fly[i].getMonth() + "-" + fly[i].getDay() + "\t" +"\t"+"|"+ fly[i].getHour() + ":" + fly[i].getMin() + "\t" +"\t"+"|"+ fly[i].getPrice() + "\t" +"\t"+"\t"+"|"+ fly[i].getSeats());
//                    continue;
//                }
                System.out.println("|"+fly[i].getFlightId() + "\t" + "\t" + "|" + fly[i].getOrigin() + "\t" + "\t" + "|" + fly[i].getDestination() + "\t" + "\t" + "\t" + "|" + fly[i].getYear() + "-" +
                        fly[i].getMonth() + "-" + fly[i].getDay() + "\t" + "\t" + "|" + fly[i].getHour() + ":" + fly[i].getMin() + "\t" + "\t" + "|" + fly[i].getPrice() + "\t" + "\t" + "|" + fly[i].getSeats());
            } else {
                break;
            }
        }
    }

    /**
     *This function receives flight details from the user and adds that flight to the list of flights
     */
    public static void add_flight(Passenger[] passenger, Fly[] fly, Ticket[] ticket) {
        Scanner input = new Scanner(System.in);
        //  print_flightList(fly);
        int n = number_of_flights(fly);
       // fly[n] = new Fly();
        // System.out.println(n);
        // boolean flag=true;
        while (true) {
            System.out.println("Enter the Id of the flight: ");
            String Id = input.nextLine();
            if (check_flightId(fly,Id)==false)
            {
                System.out.println("This flight ID is available!");
                continue;
            }
            fly[n]=new Fly();
            fly[n].setFlightId(Id);
            break;
        }
        System.out.println("Enter the origin of the flight: ");
        fly[n].setOrigin(input.nextLine());
        System.out.println("Enter the Destination of the flight: ");
        fly[n].setDestination(input.nextLine());
        System.out.println("Date of the flight");
        System.out.println("Enter year: ");
        fly[n].setYear(input.nextInt());
        System.out.println("Enter month: ");
        fly[n].setMonth(input.nextInt());
        System.out.println("Enter day: ");
        fly[n].setDay(input.nextInt());
        System.out.println("Time of flight: ");
        System.out.println("Enter hour: ");
        fly[n].setHour(input.nextInt());
        System.out.println("Enter minute: ");
        fly[n].setMin(input.nextInt());
        System.out.println("Enter the price of the flight: ");
        fly[n].setPrice(input.nextInt());
        System.out.println("Enter the number of seats: ");
        fly[n].setSeats(input.nextInt());
        //print_flightList(fly);
        admin_MENUE(passenger, fly, ticket);
    }

    /**
     *This function checks that the flightId is not duplicated
     */
    public static boolean check_flightId(Fly[] fly,String flightId)
    {
        for (int i=0;i<50;i++) {
            if (fly[i]==null)
                return true;
            if (fly[i] != null &&  fly[i].getFlightId().equals(flightId))
                return false;
        }
        return true;
    }

    /**
     *This function returns the index of the first fly class which is null
     */
    public static int number_of_flights(Fly[] fly) {
        int i;
        for (i = 0; i < 50; i++) {
            if (fly[i] != null) {
            } else {
                break;
            }
        }
        return i;
    }

    /**
     * This function changes a characteristic of the flight that the user wants
     */
    public static void update_flight(Passenger[] passenger, Fly[] fly, Ticket[] ticket) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the desired flight ID: ");
        String Id = input.nextLine();
        for (i = 0; fly[i] != null; i++) {
            //  System.out.println(number_of_flights(fly));
            if (fly[i].getFlightId().equals(Id))
                break;
            if (i == number_of_flights(fly) - 1) {
                System.out.println("This flight ID is not available");
                update_flight(passenger, fly, ticket);
                break;
            }
        }
        print_one_flight(fly, i);
        System.out.println("Enter the section you want to edit");
        System.out.println("<1>Origin \n<2>Destination \n<3>Date \n<4>Time \n<5>Price \n<6>Seats");
        switch (input.nextInt()) {
            case 1: {
                System.out.print("Enter new origin: ");
                input.nextLine();
                fly[i].setOrigin(input.nextLine());
                print_one_flight(fly, i);
                break;
            }
            case 2: {
                System.out.print("Enter new Destination: ");
                input.nextLine();
                fly[i].setDestination(input.nextLine());
                print_one_flight(fly, i);
                break;
            }
            case 3: {
                System.out.println("new Date ");
                System.out.print("Enter new year: ");
                fly[i].setYear(input.nextInt());
                System.out.print("Enter new month: ");
                fly[i].setMonth(input.nextInt());
                System.out.print("Enter new day: ");
                fly[i].setDay(input.nextInt());
                print_one_flight(fly, i);
                break;
            }
            case 4: {
                System.out.println("new Time");
                System.out.print("Enter new hour: ");
                fly[i].setHour(input.nextInt());
                System.out.print("Enter new minute: ");
                fly[i].setMin(input.nextInt());
                print_one_flight(fly, i);
                break;
            }
            case 5: {
                System.out.print("Enter new Price: ");
                fly[i].setPrice(input.nextInt());
                print_one_flight(fly, i);
                break;
            }
            case 6: {
                System.out.print("Enter new Seats: ");
                fly[i].setSeats(input.nextInt());
                print_one_flight(fly, i);
                break;
            }
            default: {
                System.out.println("Please select the available options");
                update_flight(passenger, fly, ticket);
            }
        }
        admin_MENUE(passenger, fly, ticket);
    }

    /**
     *This function takes the flight index and prints that flight
     */
    public static void print_one_flight(Fly[] fly, int i) {
        System.out.println("|FlightId" + "\t" + "|" + "origin" + "\t" + "\t" + "|" + "Destination" + "\t" + "|" + "Date" + "\t" + "\t" + "\t" + "|" + "Time" + "\t" + "\t" + "|" +
                "Price" + "\t" + "\t" + "\t" + "|" + "Seats");
        System.out.println("|"+fly[i].getFlightId() + "\t" + "\t" + "|" + fly[i].getOrigin() + "\t" + "\t" + "|" + fly[i].getDestination() + "\t" + "\t" + "\t" + "|" + fly[i].getYear() + "-" +
                fly[i].getMonth() + "-" + fly[i].getDay() + "\t" + "\t" + "|" + fly[i].getHour() + ":" + fly[i].getMin() + "\t" + "\t" + "|" + fly[i].getPrice() + "\t" + "\t" + "|" + fly[i].getSeats());
    }

    /**
     *This function joins the flight index and removes the empty space
     */
    public static void sort_the_list_of_flights(Fly[] fly) {
        for (int i = 0; i < 50; i++) {
            if (fly[i] == null && i + 1 < 50 && fly[i + 1] != null) {
                fly[i] = new Fly();
                fly[i].setFlightId(fly[i + 1].getFlightId());
                fly[i].setOrigin(fly[i + 1].getOrigin());
                fly[i].setDestination(fly[i + 1].getDestination());
                fly[i].setYear(fly[i + 1].getYear());
                fly[i].setMonth(fly[i + 1].getMonth());
                fly[i].setDay(fly[i + 1].getDay());
                fly[i].setHour(fly[i + 1].getHour());
                fly[i].setMin(fly[i + 1].getMin());
                fly[i].setPrice(fly[i + 1].getPrice());
                fly[i].setSeats(fly[i + 1].getSeats());
                fly[i + 1] = null;
            }
        }
    }

    /**
     *This function takes the flightId from the user and deletes that flight
     */
    public static void remove_flight(Passenger[] passenger, Fly[] fly, Ticket[] ticket) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the desired flight ID: ");
        String Id = input.nextLine();
        for (i = 0; fly[i] != null; i++) {
            //  System.out.println(number_of_flights(fly));
            if (fly[i].getFlightId().equals(Id))
                break;
            if (i == number_of_flights(fly) - 1) {
                System.out.println("This flight ID is not available");
                remove_flight(passenger, fly, ticket);
            }
        }
        fly[i] = null;
        sort_the_list_of_flights(fly);
        admin_MENUE(passenger, fly, ticket);
    }

    /**
     *This function prints the passenger's menu and executes the desired function according to the user's choice
     */
    public static void passenger_MENUE(Passenger[] passenger, Fly[] fly, int n, Ticket[] ticket) {
        int[] ary = new int[50];
        ary(ary);
        Scanner input = new Scanner(System.in);
        System.out.println("PASSENGER MENUE OPTIONS");
        System.out.println("<1>Change password\n<2>Search flight tickets\n<3>Booking ticket\n<4>Ticket cancellation\n<5>Booked tickets\n<6>Add charge\n<0>sign out");
        switch (input.nextInt()) {
            case 1: {
                change_password(passenger, fly, n, ticket);
                break;
            }
            case 2: {
                search_flight_ticket(passenger, fly, ary,n,ticket);
                break;
            }
            case 3: {
                booking_ticket(passenger,fly,ticket,n);
                break;
            }
            case 4: {
                ticket_cancellation(ticket,passenger,fly,n);
                break;
            }
            case 5:{
                booked_tickets(ticket,passenger,fly,n);
                break;
            }
            case 6:{
                add_charge(ticket,passenger,fly,n);
                break;
            }
            case 0:{
                MENUE_OPTIONS(passenger,fly,ticket);
                break;
            }
            default:{
                System.out.println("The desired number is not available");
                passenger_MENUE(passenger,fly,n,ticket);
            }
        }
    }

    /**
     *This function replaces the old password with a new password
     */
    public static void change_password(Passenger[] passenger, Fly[] fly, int n, Ticket[] ticket) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new password: ");
        passenger[n].setPassword(input.nextInt());
        System.out.println("New password registered");
        passenger_MENUE(passenger, fly, n, ticket);
    }

    /**
     *This function filters the flights according to the user's choices and shows them to the user
     */
    public static void search_flight_ticket(Passenger[] passenger, Fly[] fly, int[] ary,int n,Ticket[] ticket) {
        Scanner input = new Scanner(System.in);
        System.out.println("Select the desired filter(You can filter based on several elements):");
        System.out.println("<1>flight Id\n<2>Origin\n<3>Destination\n<4>Date\n<5>Time\n<6>Price range\n<0>exit");
        switch (input.nextInt()) {
            case 1: {
                System.out.print("Enter flight Id: ");
                input.nextLine();
                String id = input.nextLine();
                for (int i = 0; i < 50; i++) {
                    if (fly[i] != null && fly[i].getFlightId().equals(id)) {
                        print_one_flight(fly, i);
                        break;
                    }
                }
                search_flight_ticket(passenger, fly,ary,n ,ticket);
                break;
            }
            case 2: {
                // ary(ary,1);

                System.out.println("Enter origin: ");
                input.nextLine();
                String or = input.nextLine();
                System.out.println("|FlightId" + "\t" + "|" + "origin" + "\t" + "\t" + "|" + "Destination" + "\t" + "|" + "Date" + "\t" + "\t" + "\t" + "|" + "Time" + "\t" + "\t" + "|" +
                        "Price" + "\t" + "\t" + "\t" + "|" + "Seats");
                for (int i = 0; i < 50; i++) {
                    if (fly[i] != null && fly[i].getOrigin().equals(or) && ary[i] == 1) {
                        System.out.println(fly[i].getFlightId() + "\t" + "\t" + "|" + fly[i].getOrigin() + "\t" + "\t" + "|" + fly[i].getDestination() + "\t" + "\t" + "\t" + "|" + fly[i].getYear() + "-" +
                                fly[i].getMonth() + "-" + fly[i].getDay() + "\t" + "\t" + "|" + fly[i].getHour() + ":" + fly[i].getMin() + "\t" + "\t" + "|" + fly[i].getPrice() + "\t" + "\t" + "|" + fly[i].getSeats());
                        ary[i] = 2;

                    }
                }
                // printary(ary);
                sort_ary(ary);
                search_flight_ticket(passenger, fly,ary, n,ticket);
                break;
            }
            case 3: {
                System.out.println("Enter destination: ");
                input.nextLine();
                String de = input.nextLine();
                //printary(ary);
                System.out.println("|FlightId" + "\t" + "|" + "origin" + "\t" + "\t" + "|" + "Destination" + "\t" + "|" + "Date" + "\t" + "\t" + "\t" + "|" + "Time" + "\t" + "\t" + "|" +
                        "Price" + "\t" + "\t" + "\t" + "|" + "Seats");
                for (int i = 0; i < 50; i++) {
                    if (fly[i] != null && fly[i].getDestination().equals(de) && ary[i] == 1) {
                        System.out.println(fly[i].getFlightId() + "\t" + "\t" + "|" + fly[i].getOrigin() + "\t" + "\t" + "|" + fly[i].getDestination() + "\t" + "\t" + "\t" + "|" + fly[i].getYear() + "-" +
                                fly[i].getMonth() + "-" + fly[i].getDay() + "\t" + "\t" + "|" + fly[i].getHour() + ":" + fly[i].getMin() + "\t" + "\t" + "|" + fly[i].getPrice() + "\t" + "\t" + "|" + fly[i].getSeats());
                        ary[i] = 2;

                    }
                }
                // printary(ary);
                sort_ary(ary);
                // printary(ary);
                search_flight_ticket(passenger, fly, ary,n,ticket);
                break;
            }
            case 4: {
                System.out.print("Enter year: ");
                int year = input.nextInt();
                System.out.print("Enter month: ");
                int month = input.nextInt();
                System.out.print("Enter day: ");
                int day = input.nextInt();
                System.out.println("|FlightId" + "\t" + "|" + "origin" + "\t" + "\t" + "|" + "Destination" + "\t" + "|" + "Date" + "\t" + "\t" + "\t" + "|" + "Time" + "\t" + "\t" + "|" +
                        "Price" + "\t" + "\t" + "\t" + "|" + "Seats");
                for (int i = 0; i < 50; i++) {
                    if (fly[i] != null && fly[i].getYear() == year && fly[i].getMonth() == month && fly[i].getDay() == day && ary[i] == 1) {
                        System.out.println(fly[i].getFlightId() + "\t" + "\t" + "|" + fly[i].getOrigin() + "\t" + "\t" + "|" + fly[i].getDestination() + "\t" + "\t" + "\t" + "|" + fly[i].getYear() + "-" +
                                fly[i].getMonth() + "-" + fly[i].getDay() + "\t" + "\t" + "|" + fly[i].getHour() + ":" + fly[i].getMin() + "\t" + "\t" + "|" + fly[i].getPrice() + "\t" + "\t" + "|" + fly[i].getSeats());
                        ary[i] = 2;
                    }
                }
                sort_ary(ary);
                search_flight_ticket(passenger, fly, ary,n,ticket);
                break;
            }
            case 5: {
                System.out.print("Enter hour: ");
                int hour = input.nextInt();
                System.out.print("Enter min: ");
                int min = input.nextInt();
                // printary(ary);
                System.out.println("|FlightId" + "\t" + "|" + "origin" + "\t" + "\t" + "|" + "Destination" + "\t" + "|" + "Date" + "\t" + "\t" + "\t" + "|" + "Time" + "\t" + "\t" + "|" +
                        "Price" + "\t" + "\t" + "\t" + "|" + "Seats");
                for (int i = 0; i < 50; i++) {
                    if (fly[i] != null && fly[i].getHour() == hour && fly[i].getMin() == min && ary[i] == 1) {
                        System.out.println(fly[i].getFlightId() + "\t" + "\t" + "|" + fly[i].getOrigin() + "\t" + "\t" + "|" + fly[i].getDestination() + "\t" + "\t" + "\t" + "|" + fly[i].getYear() + "-" +
                                fly[i].getMonth() + "-" + fly[i].getDay() + "\t" + "\t" + "|" + fly[i].getHour() + ":" + fly[i].getMin() + "\t" + "\t" + "|" + fly[i].getPrice() + "\t" + "\t" + "|" + fly[i].getSeats());
                        ary[i] = 2;
                    }
                }
                // printary(ary);
                sort_ary(ary);
                search_flight_ticket(passenger, fly, ary,n,ticket);
                break;
            }
            case 6: {
                System.out.print("Enter first of range: ");
                int first = input.nextInt();
                System.out.print("Enter end of range: ");
                int end = input.nextInt();
                System.out.println("|FlightId" + "\t" + "|" + "origin" + "\t" + "\t" + "|" + "Destination" + "\t" + "|" + "Date" + "\t" + "\t" + "\t" + "|" + "Time" + "\t" + "\t" + "|" +
                        "Price" + "\t" + "\t" + "\t" + "|" + "Seats");
                for (int i = 0; i < 50; i++) {
                    if (fly[i] != null && fly[i].getPrice() <= end && fly[i].getPrice() >= first && ary[i] == 1) {
                        System.out.println(fly[i].getFlightId() + "\t" + "\t" + "|" + fly[i].getOrigin() + "\t" + "\t" + "|" + fly[i].getDestination() + "\t" + "\t" + "\t" + "|" + fly[i].getYear() + "-" +
                                fly[i].getMonth() + "-" + fly[i].getDay() + "\t" + "\t" + "|" + fly[i].getHour() + ":" + fly[i].getMin() + "\t" + "\t" + "|" + fly[i].getPrice() + "\t" + "\t" + "|" + fly[i].getSeats());
                        ary[i] = 2;
                    }
                }
                sort_ary(ary);
                search_flight_ticket(passenger, fly, ary,n,ticket);
                break;
            }
            case 0:{
                passenger_MENUE(passenger,fly,n,ticket);
            }
            default:{
                System.out.println("The desired number is not available");

            }

        }
    }

    /**
     *This function puts the number 1 in all indices of ary
     */
    public static void ary(int[] ary) {
        for (int i = 0; i < 50; i++) {
            ary[i] = 1;
        }
    }

    /**
     *This function puts the number 1 in the indices where the number 2 is and puts the number 0 in the indices where the number 1 is present.
     */
    public static void sort_ary(int[] ary) {
        for (int i = 0; i < 50; i++) {
            if (ary[i] == 2) {
                ary[i] = 1;
                continue;
            }
            if (ary[i] == 1)
                ary[i] = 0;
        }
    }

    /**
     *This function takes the flightId from the user and reserves that flight
     */
    public static void booking_ticket(Passenger[] passenger, Fly[] fly, Ticket[] ticket, int n) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter flightId: ");
        Random random = new Random();
        String id = input.nextLine();
        boolean flag = true;
        int a = number_of_tickets(ticket);
        for (int i = 0; i < 50; i++) {
            if (fly[i]!=null && fly[i].getFlightId().equals(id)) {
                print_one_flight(fly,i);
                if (passenger[n].getCharge()>=fly[i].getPrice())
                {
                    ticket[a] = new Ticket();
                    passenger[n].setCharge(passenger[n].getCharge()-fly[i].getPrice());
                    fly[i].setSeats(fly[i].getSeats()-1);
                    ticket[a].setPrice(fly[i].getPrice());
                    ticket[a].setFlightId(fly[i].getFlightId());
                    break;
                }
                System.err.println("The account charge is not enough");
                passenger_MENUE(passenger,fly,n,ticket);
                break;
            }
            if(fly[i]==null)
            {
                System.out.println("This flightId not available!");
                booking_ticket(passenger,fly,ticket,n);
                break;
            }
        }

        while (flag) {
            int c = random.nextInt(50) + 1;
            if (check_ticketId(ticket, c) == true) {
                ticket[a].setTicketId(c);
                flag = false;
            }
        }
        ticket[a].setPassenger(n);
        System.out.println("The ticket was booked\nyour ticketId: "+ticket[a].getTicketId());
        passenger_MENUE(passenger,fly,n,ticket);
    }

    /**
     *This function checks that the TicketId is not duplicated
     */
        public static boolean check_ticketId (Ticket[]ticket ,int c)
        {
            boolean flag = true;
            for (int i = 0; i < 50; i++) {
                if (ticket[i] != null && ticket[i].getTicketId() == c)
                    return false;
            }
            return true;
        }

    /**
     *This function returns the first null index of the Ticket class
     */
    public static int number_of_tickets (Ticket[]ticket)
        {
            for (int i = 0; i < 50; i++) {
                if (ticket[i] == null)
                    return i;
            }
            return 50;
        }

    /**
     *This function joins the ticket class indices together and removes the empty spaces
     */
    public static void sort_the_list_of_tickets(Ticket[] ticket) {
        for (int i = 0; i < 50; i++) {
            if (ticket[i] == null && i + 1 < 50 && ticket[i + 1] != null) {
                ticket[i] = new Ticket();
                ticket[i].setPassenger(ticket[i + 1].getPassenger());
                ticket[i].setTicketId(ticket[i + 1].getTicketId());
                ticket[i].setFlightId(ticket[i + 1].getFlightId());
                ticket[i + 1] = null;
            }
        }
    }

    /**
     *This function takes the ticket ID from the user and cancels the ticket
     */
    public static void ticket_cancellation(Ticket[] ticket,Passenger[] passenger,Fly[] fly,int n)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter ticketId: ");
        int Id=input.nextInt();
        for (int i = 0; i<50; i++) {
            if (ticket[i].getTicketId()==Id)
            {
               int b= search_flightId(fly,ticket[i].getFlightId());
                fly[b].setSeats(fly[b].getSeats()+1);
                passenger[n].setCharge(passenger[n].getCharge()+ticket[i].getPrice());
                ticket[i]=null;
                sort_the_list_of_tickets(ticket);
                System.out.println("The ticket was cancelled");
                break;
            }
            if (ticket[i]==null)
            {
                System.err.println("This ticket ID does not exist");
                break;
            }
        }
        passenger_MENUE(passenger,fly,n,ticket);
    }

    /**
     *This function takes the flightID and returns the index of that flight
     */
    public static int search_flightId(Fly[] fly,String flightId)
    {
        for (int i = 0; i < 50; i++) {
            if (fly[i].getFlightId().equals(flightId))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     *This function shows the reserved tickets
     */
    public static void booked_tickets(Ticket[] ticket,Passenger[] passenger,Fly[] fly,int n)
    {
        for (int i = 0; i < 50; i++) {
            if (ticket[i]!=null && ticket[i].getPassenger()==n)
            {
                System.out.println("ticketID: "+ticket[i].getTicketId());
                print_one_flight(fly,search_flightId(fly,ticket[i].getFlightId()));
            }
        }
        passenger_MENUE(passenger,fly,n,ticket);
    }

    /**
     *This function takes the charge amount from the user and adds it to the account charge
     */
    public static void add_charge(Ticket[] ticket,Passenger[] passenger,Fly[] fly,int n)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the charge: ");
        passenger[n].setCharge(passenger[n].getCharge()+input.nextInt());
        System.out.println("Your account has been charged");
        passenger_MENUE(passenger,fly,n,ticket);
    }
}





