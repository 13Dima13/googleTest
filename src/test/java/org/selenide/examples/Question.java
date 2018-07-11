package org.selenide.examples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Question {
  @Test
  public void Question () {

    Integer a = 128;
    Integer b = 128;

    boolean result = a == b;
    System.out.println(result); // false

    Integer a2 = 127;
    Integer b2 = 127;

    boolean result2 = a2 == b2;
    System.out.println(result2); //true

    String a3 = "123";
    String b3 = "123";

    boolean result3 = a3 == b3;
    System.out.println(result3); //true

    String a4 = new String("123");
    String b4 = new String("123");

    boolean result4 = a4 == b4;
    System.out.println(result4); //false
  }


}
