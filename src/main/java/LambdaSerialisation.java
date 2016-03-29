import java.io.*;

class LambdaSerialisation {
    public static void main(String[] args) throws Exception {
        File file = new File("lambda.ser");

        ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(file));
        Runnable r = (Runnable & Serializable)() -> System.out.println("Serializable!");
        oo.writeObject(r);
        System.out.println("wrote lambda to " + file);
    }
}

class LambdaDeserialisation {
    public static void main(String[] args) throws Exception {
        File file = new File("lambda.ser");
        System.out.println("reading lambda from " + file);

        ObjectInput oi = new ObjectInputStream(new FileInputStream(file));
        Runnable  r = (Runnable) oi.readObject();
        r.run();
    }
}
