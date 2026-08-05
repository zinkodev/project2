package com.sddevops.jenkins_project2.eclipse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ClassGroupTest {

    private ClassGroup group;
    private Student alice;
    private Student bob;

    @BeforeEach
    void setUp() {
        group = new ClassGroup(2); 
        alice = new Student(1, "Alice", LocalDate.of(1990, 1, 1));
        bob = new Student(2, "Bob", LocalDate.of(2000, 1, 1));
    }

    @Test
    void testAddStudentFlows() {
        System.out.println("Running: testAddStudentFlows...");
        assertTrue(group.addStudent(alice)); 
        assertEquals(1, group.getSize());
        
        assertTrue(group.addStudent(bob));
        Student charlie = new Student(3, "Charlie", LocalDate.of(2005, 1, 1));
        assertFalse(group.addStudent(charlie)); // Capacity limit reached
        System.out.println("Success: Student addition and capacity boundaries verified.");
    }

    @Test
    void testRemoveStudentFlows() {
        System.out.println("Running: testRemoveStudentFlows...");
        group.addStudent(alice);
        group.addStudent(bob);

        assertTrue(group.removeStudent(1)); 
        assertEquals(1, group.getSize());
        assertEquals(bob, group.getStudents()[0]); 
        
        assertFalse(group.removeStudent(99)); 
        System.out.println("Success: Student removal and array shifting verified.");
    }

    @Test
    void testGetTheOldestStudent() {
        System.out.println("Running: testGetTheOldestStudent...");
        assertNull(group.getTheOldestStudent()); // empty case

        group.addStudent(bob);   
        group.addStudent(alice); 

        Student oldest = group.getTheOldestStudent();
        assertEquals(alice, oldest);
        System.out.println("Success: Correct oldest student found (Alice).");
    }
    
    @Test
    void testGetters() {
        System.out.println("Running: testGetters (ClassGroup)...");
        assertEquals(2, group.getCapacity());
        assertNotNull(group.getStudents());
        System.out.println("Success: ClassGroup metadata verified.");
    }
}