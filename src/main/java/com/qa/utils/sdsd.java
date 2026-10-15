package com.qa.utils;

public class sdsd {

  public static void main(String[] args) {
    Box<Number> numberBox = new Box<>();
    numberBox.addValuesToList(100);
    numberBox.addValuesToList(200);
    numberBox.addValuesToList(300);
    numberBox.printValues();
    System.out.println(numberBox.getValue(0));
    System.out.println(numberBox.isEquals(10, 10));

    Box<String> stringBox = new Box<>();
    stringBox.addValuesToList("Apple");
    stringBox.addValuesToList("Banana");
    stringBox.addValuesToList("Cherry");
    stringBox.printValues();
    System.out.println(stringBox.getValue(0));
    System.out.println(stringBox.isEquals("Cow", "Cow"));
  }

}
