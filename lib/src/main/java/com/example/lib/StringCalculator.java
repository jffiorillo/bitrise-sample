package com.example.lib;

public class StringCalculator {

  public static final String separators = "[,\\n]";

  public int sum(String valueString) {
    int sum = 0;
    if (valueString != null && !valueString.isEmpty()) {
      final String[] split = valueString.split(separators);
      for (String a : split) {
        try {
          sum += Integer.valueOf(a);
        } catch (NumberFormatException ignored) {

        }
      }
    }
    return sum;
  }
}
