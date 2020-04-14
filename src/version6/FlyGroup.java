package version6;

/**
 * This interface exists to define a group of ducks that are also part of the
 * DuckGroup
 */
public interface FlyGroup extends DuckGroup {

    void performFly();

    void setFlyBehavior(FlyStrategy fb);
}
