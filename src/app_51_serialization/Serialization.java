package app_51_serialization;

import java.io.*;
import java.nio.file.Path;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Path.of("src", "app_51_serialization", "resources", "person.out");
        serializeObject(path);
        deserializeObject(path);
    }
    public static void serializeObject (Path path) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))){
            Person person = new Person("Vaska", 18);
            objectOutputStream.writeObject(person);
        }
    }
    public static void deserializeObject (Path path) throws IOException, ClassNotFoundException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))){
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
        }
    }
}

class Person implements Serializable {
    static final long serialVersionUID = 1L; // для того чтобы при зизменении класса не было ошибок с новым uuid
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
