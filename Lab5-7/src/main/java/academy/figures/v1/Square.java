package academy.figures.v1;
import java.awt.Point;
import java.util.Objects;

public class Square {
    private  Point topLeft;
    private int sideLength;

    public Square(Point topLeft, int size) {
        this.topLeft = topLeft;
        this.sideLength = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.topLeft = new Point(xLeft, yTop);
        this.sideLength = size;
    }

    public Square(int size) {
        this.topLeft = new Point(0, -size);
        this.sideLength = size;
    }

    public Square() {
        this.topLeft = new Point(0, -1);
        this.sideLength = 1;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return new Point(topLeft.x + sideLength, topLeft.y + sideLength);
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getLength() {
        return sideLength;
    }

    public void moveTo(int x, int y) {
        this.topLeft.setLocation(x, y);
    }

    public void moveTo(Point point) {
        this.topLeft = point;
    }

    public void moveRel(int dx, int dy) {
        this.topLeft.translate(dx, dy);
    }

    public void resize(double ratio) {
        this.sideLength = (int) (sideLength * ratio);
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        return 4 * sideLength;
    }

    public boolean isInside(double x, double y) {
        return topLeft.getX() <= x && x <= topLeft.getX() + sideLength &&
                topLeft.getY() <= y && y <= topLeft.getY() + sideLength;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        Point myTL = getTopLeft();
        Point myBR = getBottomRight();
        Point otherTL = square.getTopLeft();
        Point otherBR = square.getBottomRight();

        return !(myBR.x < otherTL.x || myTL.x > otherBR.x ||
                myBR.y < otherTL.y || myTL.y > otherBR.y);
    }

    public boolean isInside(Square square) {
        Point myTL = getTopLeft();
        Point myBR = getBottomRight();
        Point otherTL = square.getTopLeft();
        Point otherBR = square.getBottomRight();

        return (
                myTL.x <= otherTL.x && otherBR.x <= myBR.x &&
                        myTL.y <= otherTL.y && otherBR.y <= myBR.y
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return sideLength == square.sideLength &&
                Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, sideLength);
    }

    @Override
    public String toString() {
        return "Square{" +
                "leftTop=" + topLeft +
                ", sideLength=" + sideLength +
                '}';
    }
}

