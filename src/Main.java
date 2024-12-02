public class Main {

public static void main(String args[]) {
    
    ClubDatabase database = new ClubDatabase();

    LoginPortal loginPortal = new LoginPortal(database);

    loginPortal.login();
}

}