package com.sddevops.jenkins_project2.eclipse;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentTest {

    @Test
    void testConstructorWithoutBestFriend() {
        Student student = new Student(1, "Alice", LocalDate.of(2025, 1, 1));

        assertEquals(1, student.getId());
        assertEquals("Alice", student.getName());
        assertEquals(LocalDate.of(2025, 1, 1), student.getBirthday());
        assertNull(student.getFriend());
    }
}