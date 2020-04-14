package version7;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }

    @Override
    public String toString() {
        return "Mute";
    }

}
