import java.io.*;
import java.util.function.*;

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
