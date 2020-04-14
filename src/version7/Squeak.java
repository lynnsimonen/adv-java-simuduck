package version7;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }

    @Override
    public String toString() {
        return "Squeak";
    }

}
