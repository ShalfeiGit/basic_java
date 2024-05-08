package app_15_packages_and_imports;

import app_15_packages_and_imports.test_a.TestA;
import app_15_packages_and_imports.test_a.test_b.TestB;
import app_15_packages_and_imports.test_a.test_b.*;

public class PackagesAndImports {
    public static void main(String[] args) {
        TestB text_b = new TestB();
        TestA text_a = new TestA();
        TestC text_c = new TestC();
    }
}
