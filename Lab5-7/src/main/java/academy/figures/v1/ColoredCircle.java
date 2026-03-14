package academy.figures.v1;
import java.awt.Point;

public class ColoredCircle extends Circle {

    private int color;

    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius); // Передаем координаты центра и радиус родительскому классу
        this.color = color;    // Присваиваем локальную переменную color
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        super(xCenter, yCenter, radius);
        this.color = color;
    }

    public ColoredCircle(int radius, int color) {
        super(radius);
        this.color = color;
    }

    public ColoredCircle(int color) {
        super(1); // Радиус 1
        this.color = color;
    }

    public ColoredCircle() {
        super(1); // Радиус 1, цвет 1
        this.color = 1;
    }

    public java.awt.Point getCenter() {
        return super.getCenter();
    }

    public int getRadius() {
        return super.getRadius();
    }

    public void setCenter(Point center) {
        super.setCenter(center);
    }

    public void setRadius(int radius) {
        super.setRadius(radius);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int newRadius = (int) (getRadius() * ratio);
        setRadius(newRadius);
    }

    public double getArea() {
        return super.getArea();
    }

    public double getPerimeter() {
        return super.getPerimeter();
    }

    public boolean isInside(int x, int y) {
        return super.isInside(x, y);
    }

    public boolean isInside(Point point) {
        return super.isInside(point);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ColoredCircle)) return false;
        if (!super.equals(obj)) return false;
        ColoredCircle that = (ColoredCircle) obj;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color;
        return result;
    }

    @Override
    public String toString() {
        return "ColoredCircle{" +
                "center=" + getCenter() +
                ", radius=" + getRadius() +
                ", color=" + color +
                '}';
    }

}