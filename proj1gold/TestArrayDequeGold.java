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
        Integer actual = sad1.get(i);
        Integer expected = good1.get(i);
        assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number at " + i + " th item " + actual
                        + " not equal to " + expected + "!",
                expected, actual);
        assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number at " + i + " th item " + actual
                        + " not equal to " + expected + "!",
                expected, actual);
    }
}


    @Test
    public void test2() {
        StudentArrayDeque <Integer> sad1 = new StudentArrayDeque <>();
        ArrayDequeSolution <Integer> good1 = new ArrayDequeSolution <>();

        int random = StdRandom.uniform(100);
        sad1. addFirst(random);
        good1.addFirst(random);
        assertEquals("addFirst(" + random + ")\n",good1.get(0),sad1.get(0) );
        System.out.println("addFirst("+random+")");

        random = StdRandom.uniform(100);
        sad1.addLast(random);
        good1.addLast(random);
        assertEquals("addLast("+random+")", sad1.get(1), good1.get(1));
        System.out.println("addLast("+random+")");

        int act = sad1.removeFirst();
        int exp = good1.removeFirst();
        assertEquals("removeFirst()", act, exp);
        System.out.println("removeFirst()");


        act = sad1.removeFirst();
        exp = good1.removeFirst();
        assertEquals("removeLast()", exp, act);
        System.out.println("removeLast()");


    }
}
