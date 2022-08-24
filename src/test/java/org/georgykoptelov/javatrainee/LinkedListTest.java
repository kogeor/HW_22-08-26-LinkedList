package org.georgykoptelov.javatrainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    MyLinkedList<String> testLinkedList = new MyLinkedList<>();

    @Test
    public void testLinkedListCreating() {

        Assertions.assertNotNull(testLinkedList);
    }

    @Test
    public void testEmptyList() {
        Assertions.assertEquals(0, testLinkedList.size());
    }

    @Test
    public void testElementAdding() {
        testLinkedList.add("test");
        Assertions.assertEquals(1, testLinkedList.size());
    }

    @Test
    public void testSecondElementAdding() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        Assertions.assertEquals(2, testLinkedList.size());
    }

    @Test
    public void testElementAddingWithPosition() {
        testLinkedList.add("test");
        testLinkedList.add("test1");
        testLinkedList.add("test2");
        testLinkedList.add("test3", 1);
        Assertions.assertEquals("test3", testLinkedList.getElement(1));
        Assertions.assertEquals("test1", testLinkedList.getElement(2));
        testLinkedList.add("test4", 0);
        Assertions.assertEquals("test4", testLinkedList.getElement(0));
        testLinkedList.add("test5", 6);
        Assertions.assertNull(testLinkedList.getElement(6));
    }

    @Test
    public void testGetElement() {
        testLinkedList.add("test");
        Assertions.assertEquals("test", testLinkedList.getElement(0));
    }

    @Test
    public void testGetSecondElement() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        Assertions.assertEquals("test2", testLinkedList.getElement(1));
    }

    @Test
    public void testGetFirstElement() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        Assertions.assertEquals("test", testLinkedList.getFirst());
    }

    @Test
    public void testGetLastElement() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        Assertions.assertEquals("test3", testLinkedList.getLast());
    }

    @Test
    public void testDeleteByIndex() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        testLinkedList.add("test4");
        testLinkedList.add("test5");
        int size = testLinkedList.size();
        Assertions.assertEquals("test", testLinkedList.deleteByIndex(0));
        Assertions.assertEquals(--size, testLinkedList.size());
        Assertions.assertEquals("test2", testLinkedList.getFirst());
        testLinkedList.deleteByIndex(1);
        Assertions.assertEquals("test2", testLinkedList.getElement(0));
        Assertions.assertEquals("test4", testLinkedList.getElement(1));
        Assertions.assertEquals("test5", testLinkedList.getLast());
        Assertions.assertEquals(--size, testLinkedList.size());
    }

    @Test
    public void testDeleteByObject() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        testLinkedList.add("test4");
        int size = testLinkedList.size();
        Assertions.assertEquals("test", testLinkedList.delete("test"));
        Assertions.assertEquals(--size, testLinkedList.size());
        Assertions.assertEquals("test3", testLinkedList.delete("test3"));
        Assertions.assertEquals(--size, testLinkedList.size());
        Assertions.assertEquals("test4", testLinkedList.delete("test4"));
        Assertions.assertEquals(--size, testLinkedList.size());
    }

    @Test
    public void testIndexOf() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        Assertions.assertEquals(1, testLinkedList.indexOf("test2"));
        Assertions.assertEquals(-1, testLinkedList.indexOf("test5"));
    }



/*    @Test
    public void testSort() {

    }*/
}
