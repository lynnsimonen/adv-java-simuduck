package version5b;


public class Duck {

    private Flyable flyable;
    private Quackable quackable;
    private DisplayMode displayMode;
    private String type;

    public Duck(String type, Flyable flyable, Quackable quakable, DisplayMode displayMode) {
        this.type = type;
        this.flyable = flyable;
        this.quackable = quakable;
        this.displayMode = displayMode;
    }

    public DisplayMode getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.displayMode = displayMode;
    }

    public Flyable getFlyable() {
        return flyable;
    }

    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public Quackable getQuackable() {
        return quackable;
    }

    public void setQuackable(Quackable quackable) {
        this.quackable = quackable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public final void performDisplay() {
        displayMode.display();
    }

    public final void performFly() {
        flyable.fly();
    }

    public final void performQuack() {
        quackable.quack();
    }

}
