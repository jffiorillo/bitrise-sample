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
    final String anyEmptyArgument = "";

    final int sum = stringCalculator.sum(anyEmptyArgument);

    assertEquals(0, sum);
  }

  @Test
  public void shouldReturnNumberPassedAsParameter() throws Exception {
    final String anyNumberOfArguments = "1";

    final int sum = stringCalculator.sum(anyNumberOfArguments);

    assertEquals(1,sum);
  }

  @Test
  public void shouldSumProvidedValues() throws Exception {
    final String anyNumberOfArguments = "1,2,3";

    final int sum = stringCalculator.sum(anyNumberOfArguments);

    assertEquals(6,sum);
  }

  @Test
  public void shouldSumNewLinesAsCommas() throws Exception {
    final String anyNumberOfArguments = "1\n2,3";

    final int sum = stringCalculator.sum(anyNumberOfArguments);

    assertEquals(6,sum);
  }
}