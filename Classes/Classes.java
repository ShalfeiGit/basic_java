package Classes;

public class Classes {
  public static void main(String[] args) throws Exception {
    Car car = new Car();
    System.out.println(car.drive());
    System.out.println(car.honk());

    SubCar subCar = new SubCar();
    System.out.println(subCar.drive());
    System.out.println(subCar.honk());

    Car car2 = new Car(4, 4, "Haval");
    System.out.println(car2.drive());
   
    // Car car3 = Car.class.getConstructor(Car.class, int.class, int.class, String.class).newInstance(4, 4, "Haval");
    // System.out.println(car3.honk());
    // Car car4 = (Car) car.clone();
    // System.out.println(car4.drive());

    // Car car5 = (Car) unsafeInstance.allocateInstance(Car.class);
    // System.out.println(car5.drive());


  }
}
