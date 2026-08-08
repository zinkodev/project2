package com.sddevops.jenkins_project2.eclipse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

	private Student student;
	private Student friend;

	@BeforeEach
	void setUp() {
		friend = new Student(2, "Bob", LocalDate.of(2000, 5, 15));
		student = new Student(1, "Alice", LocalDate.of(2001, 3, 10), friend);
	}

	@Test
	void testConstructorAndGetters() {
		System.out.println("Running: testConstructorAndGetters...");
		assertEquals(1, student.getId());
		assertEquals("Alice", student.getName());
		assertEquals(LocalDate.of(2001, 3, 10), student.getBirthday());
		assertEquals(friend, student.getFriend());
		System.out.println("Success: Student object and getters verified.");
	}

	@Test
	void testSetters() {
		System.out.println("Running: testSetters...");
		student.setId(10);
		student.setName("Charlie");
		student.setBirthday(LocalDate.of(1999, 1, 1));
		student.setFriend(null);

		assertEquals(10, student.getId());
		assertEquals("Charlie", student.getName());
		assertEquals(LocalDate.of(1999, 1, 1), student.getBirthday());
		assertNull(student.getFriend());
		System.out.println("Success: All setters updated the student correctly.");
	}

	@Test
	void testEqualsAndHashCode() {
		System.out.println("Running: testEqualsAndHashCode...");
		Student sameAsStudent = new Student(1, "Alice", LocalDate.of(2001, 3, 10));
		Student differentStudent = new Student(3, "Alice", LocalDate.of(2001, 3, 10));

		assertEquals(student, sameAsStudent);
		assertNotEquals(student, differentStudent);
		assertEquals(student.hashCode(), sameAsStudent.hashCode());
		System.out.println("Success: Equality and HashCode logic verified.");
	}

	@Test
	void testComparators() {
		System.out.println("Running: testComparators...");
		Student younger = new Student(4, "Zebra", LocalDate.of(2010, 1, 1));
		assertTrue(Student.compareByName.compare(student, younger) < 0);
		assertTrue(Student.compareByBirthday.compare(student, younger) < 0);
		System.out.println("Success: Name and Birthday comparators working correctly.");
	}

	@Test
	void testToString() {
		System.out.println("Running: testToString...");
		String result = student.toString();
		assertTrue(result.contains("Alice"));
		assertTrue(result.contains("Bob"));

		student.setFriend(null);
		assertTrue(student.toString().contains("no best friend"));
		System.out.println("Success: ToString output format verified.");
	}

	@Test
	void testAssignRandomUsernameWithMock() {
		System.out.println("Running: testAssignRandomUsernameWithMock (using Mockito)...");
		Random mockRandom = Mockito.mock(Random.class);
		// Mockito controls Random so the generated username is predictable.
		// The expected output is based on the current assignRandomUsername()
		// implementation.
		Mockito.when(mockRandom.nextInt(6)).thenReturn(0);
		// return index 0 ('A') for all 5 chars
		Mockito.when(mockRandom.nextInt(Mockito.anyInt())).thenReturn(0);

		student.assignRandomUsername(mockRandom);
		assertEquals("AAAAA", student.getName());
		System.out.println("Success: Mocked random username generated correctly.");
	}
}