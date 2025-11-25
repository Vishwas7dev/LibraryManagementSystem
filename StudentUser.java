package src.oop;

public class StudentUser extends AbstractUser {

    public StudentUser(String name) {
        super(name);
    }

    public void showRole() {
        System.out.println("Role: Student User");
    }

    public static void main(String[] args) {
        StudentUser s = new StudentUser("Vishwas");
        s.displayName();
        s.showRole();
    }

	public void displayName() {
		// TODO Auto-generated method stub
		
	}
}
