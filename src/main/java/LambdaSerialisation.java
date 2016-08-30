import java.io.*;
import java.util.function.*;

class LambdaSerialisation {
    public static void main(String[] args) throws Exception {
        File file = new File("lambda.ser");

        ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(file));
        Predicate<Integer> predicate = new MyPredicate();
        // Runnable r = (Runnable & Serializable)() -> System.out.println("Serializable!");

        oo.writeObject(predicate);
        System.out.println("wrote lambda to " + file);
    }
}
