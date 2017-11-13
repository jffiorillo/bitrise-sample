package com.example.lib;

public class StringCalculator {


  public int sum(String valueString){
    int sum = 0;
    if (valueString != null && !valueString.isEmpty()){
    final String[] split = valueString.split(",");
    for(String a : split){
      try {
        sum += Integer.valueOf(a);
      }catch (NumberFormatException ignored){

      }
    }
    }
    return sum;
  }
}
