package src.oop;

public abstract class AbstractUser {

    protected String name;

    public AbstractUser(String name) {
        this.name = name;
    }

    public abstract void showRole();

    public void displayName() {
        System.out.println("User Name: " + name);
    }
}


