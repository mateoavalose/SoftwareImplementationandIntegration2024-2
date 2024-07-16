package Shapes;

public class Rectangle implements IShape{
    private float height;
    private float width;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public float getheight() {
        return height;
    }
    public void setheight(float height) {
        this.height = height;
    }

    public float getwidth() {
        return width;
    }
    public void setwidth(float width) {
        this.width = width;
    }

    @Override
    public float getArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}