package version5b;

public class Startup {

    public static void main(String[] args) {
        Flyable flyable = new FlyWithRocketPower();
        Quackable quackable = new Quack();
        DisplayMode displayMode = new Display2D();

        Duck[] ducks = {
                new Duck("Regular Duck",
                        flyable,
                        quackable,
                        displayMode),
                new MallardDuck("Regular Duck",
                        flyable,
                        quackable,
                        displayMode)
        };

        for (Duck duck : ducks) {
            duck.performFly();
            duck.performQuack();
            duck.performDisplay();
        }

//        Duck duck =
//                new Duck("Mallard Duck",
//                        flyable,
//                        quakable,
//                        displayMode);
//
//        System.out.println(duck.getType());
//        duck.performDisplay();
//        duck.performFly();
//        duck.performQuack();
//
//        duck.setDisplayMode(new Display3D());
//        duck.performDisplay();
    }
}
