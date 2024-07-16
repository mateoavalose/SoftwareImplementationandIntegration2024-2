package Animals;

public class Cat implements IHouseFeline{
    @Override
    public void hunt() {
        System.out.println("Cat is hunting");
    }

    @Override
    public void purr() {
        System.out.println("Cat is purring");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping");
    }

    @Override
    public void reproduce() {
        System.out.println("Cat is reproducing");
    }
}