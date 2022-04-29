package designpattern.creation.singleton.destroysingleton;

import java.io.*;

public class SerializableSingletonTest {

    private static final String FILE_NAME = "SerializableSingleton.obj";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableSingleton instance1 = SerializableSingleton.getInstance();

        serializeObject(instance1);

        SerializableSingleton instance2 = deserializeObject();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }

    private static SerializableSingleton deserializeObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializableSingleton instance2 = (SerializableSingleton) objectInputStream.readObject();
        objectInputStream.close();
        return instance2;
    }

    private static void serializeObject(SerializableSingleton instance1) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(instance1);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

}
