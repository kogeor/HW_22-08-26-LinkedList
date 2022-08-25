package org.georgykoptelov.javatrainee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ThreadLocalRandom;

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

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void testShowList() {
        testLinkedList.add("test1");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        testLinkedList.showList();
        Assertions.assertEquals("test1\r\ntest2\r\ntest3\r\n", output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
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
        Assertions.assertNull(testLinkedList.deleteByIndex(10));
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
        Assertions.assertNull(testLinkedList.delete("test5"));
    }

    @Test
    public void testIndexOf() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        Assertions.assertEquals(1, testLinkedList.indexOf("test2"));
        Assertions.assertEquals(-1, testLinkedList.indexOf("test5"));
    }

    @Test
    public void testContains() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        Assertions.assertTrue(testLinkedList.contains("test3"));
        Assertions.assertFalse(testLinkedList.contains("test4"));

    }

    @Test
    public void testClear() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        testLinkedList.clear();
        Assertions.assertEquals(0, testLinkedList.size());
        Assertions.assertNull(testLinkedList.getFirst());
        Assertions.assertNull(testLinkedList.getLast());
    }

    @Test
    public void set() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        testLinkedList.set(2, "replace");
        int size = testLinkedList.size();
        Assertions.assertEquals("test", testLinkedList.getElement(0));
        Assertions.assertEquals("test2", testLinkedList.getElement(1));
        Assertions.assertEquals("replace", testLinkedList.getElement(2));
        testLinkedList.set(1, "replace1");
        Assertions.assertEquals("replace1", testLinkedList.getElement(1));
        Assertions.assertEquals("replace", testLinkedList.getElement(2));
        testLinkedList.set(0, "replace2");
        Assertions.assertEquals("replace2", testLinkedList.getElement(0));
        Assertions.assertEquals(size, testLinkedList.size());
    }

    @Test
    public void testSort() {
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        testLinkedList.add("test");
        testLinkedList.add("test2");
        testLinkedList.add("test3");
        testLinkedList.sort();
        testLinkedList.showList();
        Assertions.assertEquals("test\r\ntest\r\ntest2\r\ntest2\r\ntest3\r\ntest3\r\n", output.toString());
    }

    @Test
    public void testIntegerSort() {
        int randomNum;
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        int numberAmount = 200;
        for (int i = 0; i <= numberAmount; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 1000);
            myList.add(randomNum);
        }
        myList.sort();
        for (int i = 0; i < numberAmount; i++) {
            Assertions.assertTrue(myList.getElement(i) <= myList.getElement(i + 1));
        }
    }
}
