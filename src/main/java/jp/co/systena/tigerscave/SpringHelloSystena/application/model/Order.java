package jp.co.systena.tigerscave.SpringHelloSystena.application.model;

public class Order {
  private Item item;
  private int num;

  public Order(Item item, int num) {
    this.item = item;
    this.num = num;
  }
  public void setItem(Item item) {
    this.item = item;
  }

  public Item getItem() {
    return this.item;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getNum() {
    return this.num;
  }
}
