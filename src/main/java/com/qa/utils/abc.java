package com.qa.utils;

public class abc {

  private String name = "abc";

  class inner {

    private String nameInner = "inner";

    public String getNameInner() {
      return nameInner;
    }

  }

  public static void main(String[] args) {
    // Accessing the inner class without creating an instance of the outer class
//    abc outer = new abc();
//    inner in = new inner();
//    System.out.println(outer.name);
//    System.out.println(in.getNameInner());
    abc abc = new abc();
    inner in = abc.new inner();
    System.out.println(in.getNameInner());
  }

}
