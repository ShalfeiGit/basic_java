package Classes;

public class Classes {
  public static void main(String[] args) {
    Car car = new Car();
    System.out.println(car.drive());
    System.out.println(car.honk());

    SubCar subCar = new SubCar();
    System.out.println(subCar.drive());
    System.out.println(subCar.honk());

  }
}
