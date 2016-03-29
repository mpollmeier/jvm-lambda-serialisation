import java.io.*;
import java.util.function.*;

class MyPredicate implements Predicate<Integer>, Serializable {
    @Override
    public boolean test(Integer i) {
        return i == 42;
    }
}

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

class LambdaDeserialisation {
    public static void main(String[] args) throws Exception {
        File file = new File("lambda.ser");
        System.out.println("reading lambda from " + file);

        ObjectInput oi = new ObjectInputStream(new FileInputStream(file));
        Predicate<Integer> predicate = (Predicate<Integer>) oi.readObject();
        System.out.println("predicate.test(42): " + predicate.test(42));
        System.out.println("predicate.test(43): " + predicate.test(43));
    }
}
