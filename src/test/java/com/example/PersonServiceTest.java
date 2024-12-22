package com.example;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonServiceTest {
    @Test
    public void testFilterByAddress() {
        List<Person> peopleLivingIn123RueA = PersonService.filterByAddress("123 Rue A");
        // Liste attendue des personnes vivant à "123 Rue A"
        List<Person> expectedPersonsLivingIn123RueA = Arrays.asList(
                Person.builder().firstName("Alice").familyName("Doe")
                        .birthDate(LocalDate.of(1990, 5, 12))
                        .address("123 Rue A").build(),
                Person.builder().firstName("Charlie").familyName("Brown")
                        .birthDate(LocalDate.of(1985, 3, 9))
                        .address("123 Rue A").build());

        // Vérification avec AssertJ
        assertThat(peopleLivingIn123RueA).containsExactlyInAnyOrderElementsOf(expectedPersonsLivingIn123RueA);
    }
}
