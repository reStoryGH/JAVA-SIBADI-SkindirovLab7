package academy.figures.v1;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Rectangle {

    private Point leftTop, rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.leftTop = new Point(xLeft, yTop); // Верхний левый угол
        this.rightBottom = new Point(xRight, yBottom); // Нижний правый угол
    }

    public Rectangle(int length, int width) {

            this.leftTop = new Point(0, -width);              // Верхний левый угол
            this.rightBottom  = new Point(length, 0);
        }

    public Rectangle() {

        this(1, 1);
    }

    public Point getTopLeft() {

        return leftTop;
    }

    public void setTopLeft(Point leftTop) {
        this.leftTop = leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setBottomRight(Point rightBottom) {
        this.rightBottom = rightBottom;
    }

    public int getLength() {
        return Math.abs(this.rightBottom.getX() - this.leftTop.getX());
    }

    public int getWidth() {
        return Math.abs(this.leftTop.getY() - this.rightBottom.getY());
    }

    public void moveTo(int x, int y) {
        int deltaX = x - this.leftTop.getX();
        int deltaY = y - this.leftTop.getY();

        this.leftTop = new Point(x, y);
        this.rightBottom = new Point(this.rightBottom.getX() + deltaX, this.rightBottom.getY() + deltaY);
    }

    public void moveTo(Point point) {
        this.moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        this.leftTop.moveRel(dx, dy);
        this.rightBottom.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int currentWidth = rightBottom.getX() - leftTop.getX();
        int currentHeight = -(rightBottom.getY() - leftTop.getY());

        int newWidth = (int)(currentWidth * ratio);
        int newHeight = (int)(currentHeight * ratio);

        rightBottom = new Point(leftTop.getX() + newWidth, leftTop.getY() - newHeight);
    }

    public void stretch(double xRatio, double yRatio) {
        int currentWidth = rightBottom.getX() - leftTop.getX();
        int currentHeight = -(rightBottom.getY() - leftTop.getY());
        int newWidth = (int)(currentWidth * xRatio);
        int newHeight = (int)(currentHeight * yRatio);

        rightBottom = new Point(leftTop.getX() + newWidth, leftTop.getY() - newHeight);
    }

    public double getArea() {
        return this.getLength() * this.getWidth();
    }

    public double getPerimeter() {
        return (this.getLength() * 2) + (this.getWidth() * 2);
    }

    public boolean isInside(int x, int y) {
        return leftTop.getX() <= x && x <= rightBottom.getX() &&
                rightBottom.getY() >= y && y >= leftTop.getY(); // Обращаем проверку Y
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    private Point getLeftBottom() {
        return new Point(this.leftTop.getX(), this.rightBottom.getY());                    // Берём Y нижней точки
    }

    private Point getRightTop() {
        return new Point(this.rightBottom.getX(), this.leftTop.getY());                         // Берём Y верхней точки
    }

    public boolean isIntersects(Rectangle other) {
        return !(other.getTopLeft().getX() > this.getBottomRight().getX() || // полностью справа
                other.getBottomRight().getX() < this.getTopLeft().getX() || // полностью слева
                other.getTopLeft().getY() > this.getBottomRight().getY() || // полностью ниже
                other.getBottomRight().getY() < this.getTopLeft().getY());  // полностью выше
    }

    public boolean isInside(Rectangle innerRect) {
        return this.getTopLeft().getX() <= innerRect.getTopLeft().getX() &&
                this.getTopLeft().getY() <= innerRect.getTopLeft().getY() && // Меняем знак здесь
                this.getBottomRight().getX() >= innerRect.getBottomRight().getX() &&
                this.getBottomRight().getY() >= innerRect.getBottomRight().getY(); // Меняем знак здесь
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftTop, rectangle.leftTop)
                && Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(leftTop, rightBottom);
    }
}