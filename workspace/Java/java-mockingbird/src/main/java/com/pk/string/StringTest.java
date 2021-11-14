package com.pk.string;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTest {
    public static void main(String[] args) {
        String s="aabcd";
        Map<String, Long> collect = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println(collect);

        List<String> list = Arrays.stream(s.split("")).collect(Collectors.toList());
        System.out.println(String.join("-", list));

        String[] split = s.split("");
        System.out.println(String.join(",", split));

        byte[] bytes = s.getBytes(StandardCharsets.ISO_8859_1);
        System.out.println(new String(bytes,StandardCharsets.UTF_8));

    }
}
