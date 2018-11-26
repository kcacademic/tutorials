package com.baeldung.encoding;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterEncodingExamples {

    static String decodeText(String input, String encoding) throws IOException {
        return 
            new BufferedReader(
                new InputStreamReader(
                    new ByteArrayInputStream(
                        input.getBytes()), 
                    Charset.forName(encoding)))
            .readLine();
    }

    static String convertToBinary(String input, String encoding) throws UnsupportedEncodingException {
        byte[] encoded_input = Charset.forName(encoding)
            .encode(input)
            .array();  
        return
            IntStream.range(0, encoded_input.length)
            .map(i -> encoded_input[i])
            .mapToObj(e -> Integer.toBinaryString((e + 256) % 256))
            .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
            .collect(Collectors.joining(" "));
    }
}