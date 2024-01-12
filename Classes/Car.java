package Classes;

public class Car extends AbstractCar implements InnerCar {
  int doors;
  int whiles;
  String brand;
  Car(int doors, int whiles, String brand) {
    this.doors = doors;
    this.whiles = whiles;
    this.brand = brand;
  }
 
  Car(){
    this(4, 4, "Haval");
  }
  public String drive() {
    return "vroom";
}
}

class SubCar extends Car {
  SubCar(){
    super(4, 4, "Haval");
  }
}
