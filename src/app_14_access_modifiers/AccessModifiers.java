package app_14_access_modifiers;

public class AccessModifiers {
    public static void main(String[] args) {
        Home home = new Home(4);
    }
}

 class Home{
    //допустимые модификаторы
    // private(не доступен вне класса для функций и полей),
    // public (доступен везеде из вне для класса, функций и полей),
    // default(не отображается - доступен внутри пакета для класса, функций и полей)
    // protected(достпен внутри пакета и для наследуемых классов, для функций и полей)
     private Home(){}
     protected Home(int window){
         this.window = window;
     }
     public int window;
     private void build(){}
     protected void reboot(){}

}
