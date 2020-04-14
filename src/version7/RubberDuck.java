package version7;

public class RubberDuck extends Duck {

    public RubberDuck() {
        // these properties are inherited from Duck
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("I'm a Rubber Duck");
    }

    @Override
    public String toString() {
        return "Rubber Duck";
    }

}
