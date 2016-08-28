package org.gradle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PersonTest {
	@Test
	public void canConstructAPersonWithAName() {
		String expect = "Larry";
		Person person = new Person(expect);
		assertThat(person.getName(), is(expect));
	}
}
