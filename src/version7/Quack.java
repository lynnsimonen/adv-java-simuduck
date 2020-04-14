package version7;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public String toString() {
        return "Quack";
    }

}
