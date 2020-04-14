package version6;

/**
 * This interface exists to define a group of ducks that are also part of the
 * DuckGroup
 */
public interface QuackGroup extends DuckGroup {

    void performQuack();

    void setQuackBehavior(QuackStrategy qb);
}
