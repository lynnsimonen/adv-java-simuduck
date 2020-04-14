package version5b;

public class FlyNoWay implements Flyable {

    @Override
    public final void fly() {
        System.out.println("Can't fly");
    }
}
