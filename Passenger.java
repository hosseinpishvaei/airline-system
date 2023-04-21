public class Passenger {
int Password;
private String username;
 private int charge;
    public int getPassword() {
        return Password;
    }


    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public void setPassword(int password) {
        Password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Passenger(int password, String username) {
        Password = password;
        this.username = username;
    }

    public Passenger() {
    }
}
