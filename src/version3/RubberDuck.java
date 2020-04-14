package version3;

/**
 * Only implement Quackable because Rubber Ducks don't fly.
 *
 * @version 3
 * @see Quackable
 */
public class RubberDuck extends Duck implements Quackable {

    @Override
    public void display() {
        System.out.println("Drawing a Rubber Duck to screen");
    }

    // Custom implementation
    @Override
    public void quack() {
        System.out.println("Squeak");
    }

}
