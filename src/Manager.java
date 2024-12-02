import java.time.LocalDate;

public class Manager extends StaffMember {
// Call the parent class (StaffMember) constructor
    public Manager(ClubDatabase clubDatabase) {
        super(clubDatabase);
    }

    @Override
    public void sendRenewalNotices() {
        System.out.println("=== Renewal Notices ===");
        /*for (ClubDatabase.Member member : clubDatabase.users.values()) {
            if (member.dateOfExpiration.isBefore(LocalDate.now().plusDays(7)) && member.dateOfExpiration.isAfter(LocalDate.now())) {
                System.out.println("Reminder: Membership for " + member.firstName + " " + member.lastName + " is expiring on " + member.dateOfExpiration + ".");
            }
        }*/
    }

    @Override
    public void generateReport(int reportType) {
        switch (reportType) {
            case 1:
                System.out.println("Report generated: List of all members.");
                break;
            case 2:
                System.out.println("Report generated: List of expired memberships.");
                break;
            case 3:
                System.out.println("Report generated: Total visits by all members.");
                break;
            default:
                System.out.println("Invalid report type. Please select a valid option.");
        }
    }

}