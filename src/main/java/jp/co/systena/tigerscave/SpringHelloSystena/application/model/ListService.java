package jp.co.systena.tigerscave.SpringHelloSystena.application.model;

import java.util.ArrayList;

public class ListService {

  private ArrayList<Item> itemList = new ArrayList<Item>();
  private String[] nameList = {"apple", "orange", "pirch"};
  private int[] priceList = {100, 80, 110};

  public ListService() {
    for (int i = 0; i < 3; i++) {
      this.itemList.add(new Item(nameList[i], priceList[i]));
    }
  }

  public ArrayList<Item> getItemList() {
    return this.itemList;
  }
}
