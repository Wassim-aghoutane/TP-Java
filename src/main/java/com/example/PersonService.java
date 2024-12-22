package com.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public static List<Person> filterByAddress(String address) {
        List<Person> mockPersonsDatabase = Arrays.asList(
                Person.builder().firstName("Alice").familyName("Doe").birthDate(LocalDate.of(1990, 5, 12))
                        .address("123 Rue A").build(),
                Person.builder().firstName("Bob").familyName("Smith").birthDate(LocalDate.of(2005, 10, 15))
                        .address("456 Rue B").build(),
                Person.builder().firstName("Charlie").familyName("Brown").birthDate(LocalDate.of(1985, 3, 9))
                        .address("123 Rue A").build()
        );

        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);

        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }

}