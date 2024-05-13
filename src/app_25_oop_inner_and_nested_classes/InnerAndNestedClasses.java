package app_25_oop_inner_and_nested_classes;

public class InnerAndNestedClasses {
    String value;

    public InnerAndNestedClasses(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        InnerAndNestedClasses app = new InnerAndNestedClasses("test");
        app.handlerMethod();

        InnerAndNestedClasses.InnerClass innerClass = app.new InnerClass();
        innerClass.testInner();

        InnerAndNestedClasses.InnerClass2 innerClass2 = new InnerAndNestedClasses.InnerClass2();
        innerClass2.testInner2();

    }

    void handlerMethod(){
        class NestedClass2 {
            void testInner()  {
                System.out.println("run Nested Class");
            }
        }

        NestedClass2 nestedClass2 = new NestedClass2();
        nestedClass2.testInner();
    }

    static class InnerClass2 {
        void testInner2()  {
            System.out.println("run Nested Class2");
        }
    }


    class InnerClass {
        void testInner()  {
            System.out.println("run Inner Class: " + InnerAndNestedClasses.this.value);
        }
    }
}
