package ua.kpi.tef;

import java.util.Objects;

public class Triangle extends Shape{

    private Point pointA;
    private Point pointB;
    private Point pointC;


    public Triangle(Point pointA, Point pointB, Point pointC) {
        Objects.requireNonNull(pointA);
        Objects.requireNonNull(pointB);
        Objects.requireNonNull(pointC);
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    private void checkPoints(Point pointA, Point pointB, Point pointC){
        if (pointA.equals(pointB)||pointA.equals(pointC)) throw new IllegalArgumentException("Point are equals");
        checkDistance(pointA, pointB, pointC);

        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    private void checkDistance(Point pointA, Point pointB, Point pointC) {
        double distanceA = getDistance(pointA, pointB);
        double distanceB = getDistance(pointA, pointC);
        double distanceC = getDistance(pointC, pointB);
        if (distanceA > (distanceB + distanceC)
                || distanceB > (distanceA + distanceC)
                || distanceC > (distanceA + distanceB))
            throw new IllegalArgumentException("It's incorrect triangle");
    }

    private double getDistance(Point p1, Point p2){
        double firstValue = Math.pow(p2.getX() - p1.getX(), 2);
        double secondValue = Math.pow(p2.getY() - p1.getY(), 2);
        return Math.sqrt(firstValue+secondValue);
    }


    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public double square() {
        double squareParameterA = getSquareParameter(pointA, pointC);
        double squareParameterB = getSquareParameter(pointC, pointB);
        double squareParameterC = getSquareParameter(pointA, pointB);
        return Math.abs(squareParameterA+squareParameterB-squareParameterC);
    }

    private double getSquareParameter(Point p1, Point p2){
        return (p1.getY()/2+p2.getY()/2)*(p2.getX()-p1.getX());
    }

    @Override
    public double perimeter() {
        double distanceA = getDistance(pointA, pointB);
        double distanceB = getDistance(pointA, pointC);
        double distanceC = getDistance(pointC, pointB);
        return distanceA+distanceB+distanceC;
    }

    @Override
    public void move(double dx, double dy) {
        pointA.setX(pointA.getX()+dx);
        pointB.setX(pointB.getX()+dx);
        pointC.setX(pointC.getX()+dx);
        pointA.setY(pointA.getY()+dy);
        pointB.setY(pointB.getY()+dy);
        pointC.setY(pointC.getY()+dy);
    }

}
