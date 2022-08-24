import org.georgykoptelov.javatrainee.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    MyLinkedList testLinkedList = new MyLinkedList();

    @Test
    public void testLinkedListCreating() {

        Assertions.assertNotNull(testLinkedList);
    }

    @Test
    public void testEmptyList() {
        Assertions.assertEquals(0, testLinkedList.size);
    }

    @Test
    public void testElementAdding() {
        testLinkedList.add("test");
        Assertions.assertEquals(1, testLinkedList.size);
    }
}
