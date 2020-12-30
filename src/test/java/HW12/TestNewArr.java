package HW12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNewArr {

    @Test
    public void testAddElement(){
        NewArr test = new NewArr();
        Assertions.assertEquals(true, test.add(22));
    }

    @Test
    public void testAddToIndex (){
        NewArr test = new NewArr();
        Assertions.assertTrue( test.add(0,1));
    }


    @Test
    public void testGet(){
        NewArr test = new NewArr();
        test.add(1);
        Assertions.assertEquals(1, test.get(0));
    }

    @Test
    public void testContains(){
        NewArr test = new NewArr();
        test.add(1);
        Assertions.assertTrue(test.contain(1));
    }

    @Test
    public void testClear(){
        NewArr test = new NewArr();
        test.add(1);
        Assertions.assertTrue(test.clear());
    }

    @Test
    public void testEquals() {
        NewArr test = new NewArr();
        test.add(1);
        test.add(22);
        test.add(333);
        NewArr test1 = new NewArr();
        test1.add(1);
        test1.add(22);
        test1.add(333);
    Assertions.assertEquals(true, test.equals(test1));

    }
}
