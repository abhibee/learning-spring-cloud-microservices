package com.techzaar.microservices.limitsservice.limits;

public class LimitConfig {

  private int maximum;
  private int minimum;

  protected LimitConfig() {}

  public int getMaximum() {
    return maximum;
  }

  public void setMaximum(int maximum) {
    this.maximum = maximum;
  }

  public int getMinimum() {
    return minimum;
  }

  public void setMinimum(int minimum) {
    this.minimum = minimum;
  }

  public LimitConfig(int maximum, int minimum) {
    super();
    this.maximum = maximum;
    this.minimum = minimum;
  }

}
