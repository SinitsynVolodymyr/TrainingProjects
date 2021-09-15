package ua.kpi.tef;

/**
 * Created by User on 07.04.2016.
 */
public abstract class Shape {
    public abstract double square();
    public abstract double perimeter();
    public abstract void move(double dx, double dy);

    @Override
    public String toString() {
        return ", perimeter = " + perimeter() +", square = " +square();
    }
}
