package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

class StringCalculator {

  private static final String separators = "[,\\n]";

  int sum(String valueString) {
    int sum = 0;
    final List<Integer> negativeNumbers = extractNegativeNumbers(valueString);
    if (negativeNumbers != null && !negativeNumbers.isEmpty()) {
      throwExceptionWithNegativeNumbers(negativeNumbers);
    }

    if (valueString != null && !valueString.isEmpty()) {
      final String[] split = valueString.split(separators);
      for (String a : split) {
        try {
          final Integer integer = Integer.valueOf(a);
          sum += integer;
        } catch (NumberFormatException ignored) {

        }
      }
    }
    return sum;
  }

  private void throwExceptionWithNegativeNumbers(List<Integer> values) throws NegativeNumberException {
    StringBuilder stringBuilder = new StringBuilder();
    for (Integer element : values) {
      stringBuilder.append(element).append(",");
    }
    throw new NegativeNumberException(stringBuilder.toString());
  }

  private List<Integer> extractNegativeNumbers(String value) {
    List<Integer> values = new ArrayList<>();
    for (String arg : value.split(separators)) {
      try {
        final Integer element = Integer.valueOf(arg);
        if (element < 0) {
          values.add(element);
        }
      } catch (NumberFormatException ignored) {
      }
    }
    return values;
  }
}
