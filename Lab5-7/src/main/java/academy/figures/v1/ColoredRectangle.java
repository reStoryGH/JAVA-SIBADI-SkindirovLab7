package academy.figures.v1;

public class ColoredRectangle extends Rectangle {

    private int color;

    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        super(leftTop, rightBottom);
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color = color;
    }

    public ColoredRectangle(int length, int width, int color) {
        super(length, width);
        this.color = color;
    }

    public ColoredRectangle(int color) {
        super(1, 1); // Размеры 1x1
        this.color = color;
    }

    public ColoredRectangle() {
        super(1, 1); // Размеры 1x1
        this.color = 1; // Стандартный цвет 1
    }

    public Point getTopLeft() {
        return super.getTopLeft();
    }

    public Point getBottomRight() {
        return super.getBottomRight();
    }

    public int getColor() {
        return color;
    }

    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
    }

    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLength() {
        return super.getLength();
    }

    public int getWidth() {
        return super.getWidth();
    }

    // Логика перемещения и растяжения
    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        super.resize(ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        super.stretch(xRatio, yRatio);
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

    public boolean isIntersects(ColoredRectangle otherRect) {
        return super.isIntersects(otherRect);
    }

    public boolean isInside(ColoredRectangle innerRect) {
        return super.isInside(innerRect);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ColoredRectangle)) return false;
        if (!super.equals(obj)) return false;
        ColoredRectangle that = (ColoredRectangle) obj;
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
        return "ColoredRectangle{" +
                "topLeft=" + getTopLeft() +
                ", bottomRight=" + getBottomRight() +
                ", color=" + color +
                '}';
    }
}