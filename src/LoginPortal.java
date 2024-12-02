import java.util.Scanner;

public class LoginPortal {

    private ClubDatabase clubDatabase;

    public LoginPortal(ClubDatabase clubDatabase) {
        this.clubDatabase = clubDatabase;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the Club Login Portal ===");
        System.out.print("Enter your User ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int userPriv = clubDatabase.getUser(userID, password); 
        if (userPriv != 0) {
            System.out.println("Login successful for User ID: " + userID);
            if (userPriv == 1) {
                this.displayMenu(userPriv);
            } else if (userPriv == 2) {
                this.displayMenu(userPriv);
                // Manager menu can be implemented here
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
            login();
        }

        scanner.close();
    }

    private void displayMenu(int priv) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        StaffMember employee = new StaffMember();

        if(priv == 1) {
            employee = new StaffMember(clubDatabase);
        } else if(priv ==2) {
            employee = new Manager(clubDatabase);
        }

        while (isRunning) {
            System.out.println("\n--- Options Menu ---");
            System.out.println("1. Add New Member");
            System.out.println("2. Member Check-In");
            System.out.println("3. Check Expired Memberships");
            System.out.println("4. Renew Membership");
            System.out.println("5. Remove User");
            System.out.println("6. Send Renewal Notices");
            System.out.println("7. Generate Reports");
            System.out.println("8. Log Out");
            System.out.println("9. Close Program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Privilege Level (1 for Staff, 2 for Manager): ");
                    int privilegeLevel = scanner.nextInt();
                    employee.addNewMember(userID, password, email, firstName, lastName, privilegeLevel);
                    break;
                case 2:
                    System.out.print("Enter User ID to verify: ");
                    userID = scanner.nextInt();
                    employee.verifyCustomerMembership(userID);
                    break;
                case 3:
                    System.out.print("Enter User ID to check expiration: ");
                    userID = scanner.nextInt();
                    employee.checkForExpiredMembership(userID);
                    break;
                case 4:
                    System.out.print("Enter User ID to renew: ");
                    userID = scanner.nextInt();
                    System.out.print("Enter duration in days: ");
                    int duration = scanner.nextInt();
                    employee.renewMembership(userID, duration);
                    break;
                case 5:
                    System.out.print("Enter User ID to remove: ");
                    userID = scanner.nextInt();
                    employee.removeUser(userID);
                    break;
                case 6:
                    employee.sendRenewalNotices();
                    break;
                case 7:
                    employee.generateReport(1);
                    break;
                case 8:
                    isRunning = false;
                    System.out.println();
                    login();

                case 9:
                    System.out.println("Goodbye");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }


}
