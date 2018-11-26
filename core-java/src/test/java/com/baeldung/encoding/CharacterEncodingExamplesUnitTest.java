package com.baeldung.encoding;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class CharacterEncodingExamplesUnitTest {

    @Test
    public void givenTextFile_whenCalledWithEncodingASCII_thenProduceIncorrectResult() throws IOException {
        Assert.assertEquals(
          CharacterEncodingExamples.decodeText(
            "The façade pattern is a software-design pattern.", "US-ASCII"), 
            "The fa��ade pattern is a software-design pattern.");
    }

    @Test
    public void givenTextFile_whenCalledWithEncodingUTF8_thenProduceCorrectResult() throws IOException {
        Assert.assertEquals(
          CharacterEncodingExamples.decodeText(
            "The façade pattern is a software-design pattern.", "UTF-8"), 
            "The façade pattern is a software-design pattern.");
    }

    @Test
    public void givenCharacterA_whenConvertedtoBinaryWithEncodingASCII_thenProduceResult() throws IOException {
        Assert.assertEquals(
          CharacterEncodingExamples.convertToBinary("A", "US-ASCII"), 
          "01000001");
    }

    @Test
    public void givenCharacterA_whenConvertedtoBinaryWithEncodingUTF8_thenProduceResult() throws IOException {
        Assert.assertEquals(
          CharacterEncodingExamples.convertToBinary("A", "UTF-8"), 
          "01000001");
    }

    @Test
    public void givenCharacterCh_whenConvertedtoBinaryWithEncodingBig5_thenProduceResult() throws IOException {
        Assert.assertEquals(
          CharacterEncodingExamples.convertToBinary("語", "Big5"), 
          "10111011 01111001");
    }

    @Test
    public void givenCharacterCh_whenConvertedtoBinaryWithEncodingUTF8_thenProduceResult() throws IOException {
        Assert.assertEquals(
          CharacterEncodingExamples.convertToBinary("語", "UTF-8"), 
          "11101000 10101010 10011110");
    }

    @Test
    public void givenCharacterCh_whenConvertedtoBinaryWithEncodingUTF32_thenProduceResult() throws IOException {
        Assert.assertEquals(
          CharacterEncodingExamples.convertToBinary("語", "UTF-32"), 
          "00000000 00000000 10001010 10011110 ");
    }
}