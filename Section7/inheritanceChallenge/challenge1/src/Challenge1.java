/**
 * Created by johnm on 2017-01-14.
 */
public class Challenge1 {
    public static void main(String[] args) {
        Audi myAu = new Audi("1Audi", "straight", 5, 1, "A2", "22modle");


    }
}

class Vehicle {
    String name;
    String steer;
    int speed;
    int gear;

    public Vehicle() {
        this("No steer", "foward", 1, 1);
    }

    public Vehicle(String name, String steer, int speed, int gear) {
        this.name = name;
        this.steer = steer;
        this.speed = speed;
        this.gear = gear;
    }

    public void changingGear(int gear) {
        this.gear = gear;
    }

    public void steering(String steer) {
        this.steer = steer;
    }

    public void moving(int speed) {
        this.speed = speed;
    }
}

class Car extends Vehicle {
    String type;

    public Car(String name, String steer, int speed, int gear, String type) {
        super(name, steer, speed, gear);
        this.type = type;
    }

}

class Audi extends Car{
    String model;

    public Audi(String name, String steer, int speed, int gear, String type, String model) {
        super(name, steer, speed, gear, type);
        this.model = model;
    }

}
