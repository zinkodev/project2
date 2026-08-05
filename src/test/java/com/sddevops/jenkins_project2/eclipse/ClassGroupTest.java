package com.sddevops.jenkins_project2.eclipse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClassGroupTest {

    @Test
    void testConstructor() {
        int capacity = 5;
        ClassGroup group = new ClassGroup(capacity);

        assertEquals(5, group.getCapacity());
        assertEquals(0, group.getSize());
        assertNotNull(group.getStudents());
        assertEquals(5, group.getStudents().length);
    }
}