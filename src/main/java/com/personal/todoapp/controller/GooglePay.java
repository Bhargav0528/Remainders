package com.personal.todoapp.controller;

public class GooglePay {

  private GooglePay () {}

  public static GooglePay googlePay = null;

  //Helloworld1, Helloworld2


  public static synchronized GooglePay getInstance() {
    if (googlePay != null) {
      googlePay = new GooglePay();
    }
    return googlePay;
  }


}
