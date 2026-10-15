package com.qa.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<T> {

  List<T> values = new ArrayList<>();

  public Box() {
  }

  public void addValuesToList(T value) {
    values.add(value);
  }

  public void printValues() {
    values.forEach(System.out::println);
  }

  public T getValue(int index) {
    return values.get(index);
  }

  public Boolean isEquals(T value1, T value2) {
    return Objects.equals(value1, value2);
  }

}
