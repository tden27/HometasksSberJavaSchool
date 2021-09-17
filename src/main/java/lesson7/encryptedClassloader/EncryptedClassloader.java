package lesson7.encryptedClassloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EncryptedClassloader extends ClassLoader {
    private final String key;   //  ключ шифрования
    private final File dir;     //  рутовую папку, в которой будет искать классы

    public EncryptedClassloader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    // считывает зашифрованный массив байт,
    // дешифрует его и превращает в класс (с помощью метода defineClass)
    @Override
    protected Class<?> findClass(String name) {
        Class<?> c = null;
        File[] list = dir.listFiles();
        if(list!=null)
            for (File fil : list) {
                if (fil.isDirectory()) {
                    findClass(name);
                }
                else if (name.equalsIgnoreCase(fil.getName())) {
                    byte[] bytes = encryptByteArray(readFile(fil.getAbsolutePath()));
                    c = defineClass(name, bytes, 0, bytes.length);
                    System.out.println(fil.getParentFile());
                }
            }
        return c;
    }

    //  Читает байты из файла и возвращает массив этих байтов
    private byte[] readFile(String fileName) {
        byte[] buffer = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            buffer = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                fileInputStream.read(buffer, 0, fileInputStream.available());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
            e.printStackTrace();
        }
        return buffer;
    }

    //  Дешифрует переданный массив байт
    private byte[] encryptByteArray(byte[] cryptedByte){
        byte[] encryptedByteArray = new byte[cryptedByte.length];
        for (int i = 0; i < cryptedByte.length; i++){
            encryptedByteArray[i] = (byte) (cryptedByte[i] + (byte) key.length());
            encryptedByteArray[i] = (byte) (cryptedByte[i] >>> key.hashCode());
        }
        return encryptedByteArray;
    }
}
