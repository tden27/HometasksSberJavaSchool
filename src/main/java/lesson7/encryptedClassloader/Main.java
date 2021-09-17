package lesson7.encryptedClassloader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        EncryptedClassloader encryptedClassloader = new EncryptedClassloader("key",
                new File("C:\\Users\\t_den\\IdeaProjects\\HometasksSberJavaSchool\\src\\main\\resources"),
                ClassLoader.getSystemClassLoader());
        System.out.println(encryptedClassloader.findClass("String.java"));
    }
}
