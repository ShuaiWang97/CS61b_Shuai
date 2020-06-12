import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

@Test
public void test() {
    StudentArrayDeque <Integer> sad1 = new StudentArrayDeque <>();
    ArrayDequeSolution <Integer> good1 = new ArrayDequeSolution <>();
    for (int i = 0; i < 20; i += 1) {
        double numberBetweenZeroAndOne = StdRandom.uniform();

        if (numberBetweenZeroAndOne < 0.5) {
            sad1.addLast(i);
            good1.addLast(i);
        } else {
            sad1.addFirst(i);
            good1.addFirst(i);
        }
    }

    for (int i = 0; i < 15; i += 1) {
        double numberBetweenZeroAndOne = StdRandom.uniform();

        if (numberBetweenZeroAndOne < 0.5) {
            sad1.removeLast();
            good1.removeLast();
        } else {
            sad1.removeFirst();
            good1.removeFirst();
        }
    }

    for (int i = 0; i < 10; i += 1) {
        double numberBetweenZeroAndOne = StdRandom.uniform();

        if (numberBetweenZeroAndOne < 0.5) {
            sad1.addLast(i);
            good1.addLast(i);
        } else {
            sad1.addFirst(i);
            good1.addFirst(i);
        }
    }

  //  sad1.printDeque();
   // good1.printDeque();

    for (int i=0; i<15; i++) {
        int actual = sad1.get(i);
        int expected = good1.get(i);
        assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number at " + i + " th item " + actual
                        + " not equal to " + expected + "!",
                expected, actual);
    }
}


}
