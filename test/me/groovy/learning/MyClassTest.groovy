package me.groovy.learning

import org.junit.Test
import static org.junit.Assert.assertEquals

class MyClassTest {
   
    @Test
    void testAdd() {
        def myClass = new MyClass()
        def result = myClass.add(2, 3)
        assertEquals(5, result)
    }
}