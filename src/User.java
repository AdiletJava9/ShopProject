public class User {
    private int userID;
    private String userName;
    private Role userRole;
    private double balance;

    public User(int userID, String userName, Role userRole, double balance) {
        this.userID = userID;
        this.userName = userName;
        this.userRole = userRole;
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUSer() {
        return null;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{id='" + userID + "', name='" + userName + "', balance=" + balance + "}";
    }
}
