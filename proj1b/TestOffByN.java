import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.


     CharacterComparator offBy5 = new OffByN(4);

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    @Test
    public void TestequalChars(){
        assertTrue(offBy5.equalChars('a', 'e'));
        assertTrue(offBy5.equalChars('e', 'a'));
        assertFalse(offBy5.equalChars('a', 'b'));
    }
}
