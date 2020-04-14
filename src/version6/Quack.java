package version6;

/**
 * This is an implementation (low-level object) of the QuackStrategy
 */
public class Quack implements QuackStrategy {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

}
