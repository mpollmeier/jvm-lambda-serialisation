import java.io.*;

class LambdaSerialisation {
    public static void main(String[] args) throws Exception {
        File file = new File("/tmp/lambda.ser");

        ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(file));
        Runnable r = (Runnable & Serializable)() -> System.out.println("Serializable!");
        oo.writeObject(r);
        System.out.println("wrote lambda to " + file);

        // ObjectInput oi = new ObjectInputStream(new FileInputStream(file));
        // Runnable  r2 = (Runnable) oi.readObject();
        // r2.run();
    }
}

class LambdaDeserialisation {
    public static void main(String[] args) throws Exception {
        File file = new File("lambda.ser");
        // File file = new File("/tmp/lambda.ser");
        System.out.println("reading lambda from " + file);

        ObjectInput oi = new ObjectInputStream(new FileInputStream(file));
        Runnable  r = (Runnable) oi.readObject();
        r.run();
    }
}
