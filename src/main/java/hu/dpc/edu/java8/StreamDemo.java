package hu.dpc.edu.java8;

import hu.dpc.edu.User;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by vrg on 13/10/16.
 */
public class StreamDemo {
    public static void main(String[] args) {
        final List<User> users = Arrays.asList(
                User.builder()
                        .username("user1")
                        .firstName("Bela")
                        .lastName("Kovacs")
                        .build(),
                User.builder()
                        .username("user2")
                        .firstName("Ferenc")
                        .lastName("Nagy")
                        .build(),
                User.builder()
                        .username("user2")
                        .firstName("Ferenc")
                        .lastName("Kiss")
                        .addEmail("nagy@acme.com")
                        .build(),
                User.builder()
                        .username("user12")
                        .firstName("Bela")
                        .lastName("Nagy")
                        .build()
        );

        //users.forEach(user -> System.out.println(user.getFirstName()));

        String string =  users.stream()
//                .filter(user -> "Nagy".equals(user.getLastName()))
                .filter(user -> "Bela".equals(user.getFirstName()))
                .map(user -> user.getLastName() + " " + user.getFirstName())
                .collect(Collectors.joining("\",\"","\"","\""));

        final StringJoiner joiner = new StringJoiner("\",\"", "\"", "\"");
        joiner.add("XXX");
        joiner.add("YYYY");
        joiner.add("ZZZ");
        System.out.println(joiner.toString());


        System.out.println(string);

    }
}
