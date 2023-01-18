package p;
abstract class Shape{

    String name;
    int noSides;
    Shape(String name,int noSides){
        this.name=name;
        this.noSides=noSides;
    }
    abstract double getArea();
    abstract double getPerimeter();
    public String toString(){
        return name+" "+noSides;
    }
}
class Circle extends Shape{
    int radius;
    Circle(int radius,String name,int noSides){
        super(name,noSides);
        this.radius=radius;
    }

    @Override
    double getArea() {
        return 3.14*radius*radius;
    }

    @Override
    double getPerimeter() {
        return 2*3.14*radius;
    }
}
class Rectangle extends Shape{
    int length,breadth;
    Rectangle(int length,int breadth,String name,int noSides){
        super(name,noSides);
        this.length=length;
        this.breadth=breadth;
    }

    @Override
    double getArea() {
        return length*breadth;
    }

    @Override
    double getPerimeter() {
        return 2*(length+breadth);
    }
}

public class Assign4 {
    public static void main(String[] args) {
        Circle c =new Circle(4,"circle",0);
        System.out.println(c);
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());

        Rectangle r=new Rectangle(5,4,"rectangle",4);
        System.out.println(r);
        System.out.println(r.getArea());
        System.out.println(r.getPerimeter());
    }
}
