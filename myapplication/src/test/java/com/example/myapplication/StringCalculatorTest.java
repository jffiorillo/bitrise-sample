package com.example.myapplication;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

  @Rule public ExpectedException expectedException = ExpectedException.none();

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

    assertEquals(1, sum);
  }

  @Test
  public void shouldSumProvidedValues() throws Exception {
    final String anyNumberOfArguments = "1,2,3";

    final int sum = stringCalculator.sum(anyNumberOfArguments);

    assertEquals(6, sum);
  }

  @Test
  public void shouldSumNewLinesAsCommas() throws Exception {
    final String anyNumberOfArguments = "1\n2,3";

    final int sum = stringCalculator.sum(anyNumberOfArguments);

    assertEquals(6, sum);
  }

  @Test(expected = NegativeNumberException.class)
  public void shouldThrowExceptionWhenNegativeNumberProvided() throws Exception {
    final String anyArgumentWithNegativeNumbers = "-1";

    stringCalculator.sum(anyArgumentWithNegativeNumbers);
  }

  @Test(expected = NegativeNumberException.class)
  public void shouldThrowExceptionWithMessageWhenNegativeNumberProvided() throws Exception {
    final String anyArgumentWithNegativeNumbers = "-1,2,3,-4";

    stringCalculator.sum(anyArgumentWithNegativeNumbers);

    expectedException.expect(NegativeNumberException.class);
    expectedException.expectMessage("-1,-4");
  }
}