package com.example.lib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

  private StringCalculator stringCalculator;

  @Before
  public void setUp() throws Exception {
    stringCalculator = new StringCalculator();
  }

  @Test
  public void shouldReturn0WhenEmptyString() throws Exception {
    final int sum = stringCalculator.sum("");

    assertEquals(0, sum);
  }

  @Test
  public void shouldReturnNumberPassedAsParameter() throws Exception {
    final String value = "1";
    final int sum = stringCalculator.sum(value);

    assertEquals(1,sum);
  }

  @Test
  public void shouldSumProvidedValues() throws Exception {
    final String valueString = "1,2,3";
    final int sum = stringCalculator.sum(valueString);

    assertEquals(6,sum);
  }
}