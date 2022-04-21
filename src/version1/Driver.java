package version1;

public class Driver {

    //Downloaded and ready to go

    public static final String BLANK_LINE = "\n";

    public static void main(String[] args) {
        Duck[] ducks = new Duck[2];

        ducks[0] = new MallardDuck();
        ducks[1] = new RedheadDuck();

        for (int i = 0; i < ducks.length; i++) {
            System.out.println("Duck #" + i + ":\n---------------------");
            ducks[i].quack();
            ducks[i].swim();
            ducks[i].display();
            System.out.println(ducks[i].toString() + Driver.BLANK_LINE);
        }
        system.out.println("downloaded and ready");

    }

}
