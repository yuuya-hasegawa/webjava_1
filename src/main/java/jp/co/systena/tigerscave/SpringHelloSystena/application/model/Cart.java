package jp.co.systena.tigerscave.SpringHelloSystena.application.model;

import java.util.ArrayList;

public class Cart {
  private ArrayList<Order> orderList;

  public Cart() {
    this.orderList = new ArrayList<Order>();
  }
  public void addOrderList(Order order) {
    this.orderList.add(order);
  }

  public ArrayList<Order> getOrderList() {
    return this.orderList;
  }

  public int sumPrice() {
    int sum = 0;
    for (int i = 0; i < this.orderList.size(); i++) {
      Order order = this.orderList.get(i);
      int num = order.getNum();
      int price = order.getItem().getPrice();
      sum += num * price;
    }
    return sum;
  }
}
