import java.time.*;
import java.util.*;

public class ClubDatabase {

    Map<Integer, Member> users = new HashMap<>();

    static class Member {

        int userID;
        String password;
        String email;
        String firstName;
        String lastName;

        LocalDate dateOfLastEntry;

        LocalDate dateOfExpiration;

        int totalVisits;
        int privilegeLevel;



        public Member(int userID, String password, String email, String firstName, String lastName, int privilegeLevel) {
            this.userID = userID;
            this.password = password;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfLastEntry = LocalDate.now();
            this.dateOfExpiration = LocalDate.now().plusDays(90);
            this.totalVisits = 0;
            this.privilegeLevel = privilegeLevel;
        }

        public Member(int userID, String password, String email, String firstName, String lastName, int privilegeLevel, int numDaysLeft) {
            this.userID = userID;
            this.password = password;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfLastEntry = LocalDate.now();
            this.dateOfExpiration = LocalDate.now().plusDays(numDaysLeft);
            this.totalVisits = 0;
            this.privilegeLevel = privilegeLevel;
        }

    }

    // Retrieve user info from database
    public int getUser(int userID, String password) {
        Member user = users.get(userID);
        if (user != null && user.password.equals(password)) {
            return user.privilegeLevel;
        }
        return 0;
    }

    // Initializing database with smart userIDs
    public ClubDatabase() {
        
        users.put(101, new Member(101, "password", "Yared@gmail.com", "Yared", "Leake", 1));
        users.put(102, new Member(102, "password", "Red@gmail.com", "Red", "Dot", 2));
        users.put(103, new Member(103, "password", "Red@gmail.com", "Red", "Dot", 2, -1));

    }

}