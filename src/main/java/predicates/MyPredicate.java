package predicates;

import java.io.*;
import java.util.function.*;

class MyPredicate implements Predicate<Integer>, Serializable {
    @Override
    public boolean test(Integer i) {
        return i == 42;
    }
}

