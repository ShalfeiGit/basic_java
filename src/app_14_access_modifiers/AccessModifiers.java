package app_14_access_modifiers;

public class AccessModifiers {
    public static void main(String[] args) {
        Home home = new Home(4);
    }
}

 class Home{
    //���������� ������������
    // private(�� �������� ��� ������ ��� ������� � �����),
    // public (�������� ������ �� ��� ��� ������, ������� � �����),
    // default(�� ������������ - �������� ������ ������ ��� ������, ������� � �����)
    // protected(������� ������ ������ � ��� ����������� �������, ��� ������� � �����)
     private Home(){}
     protected Home(int window){
         this.window = window;
     }
     public int window;
     private void build(){}
     protected void reboot(){}

}
