package jp.co.systena.tigerscave.SpringHelloSystena.application.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.SpringHelloSystena.application.model.Cart;
import jp.co.systena.tigerscave.SpringHelloSystena.application.model.Item;
import jp.co.systena.tigerscave.SpringHelloSystena.application.model.ListService;
import jp.co.systena.tigerscave.SpringHelloSystena.application.model.Order;

@Controller  // Viewあり。Viewを返却するアノテーション
public class ListController {

  private Cart cart;

  @Autowired
  HttpSession session;                  // セッション管理

  @RequestMapping(value="/itemlist", method = RequestMethod.GET)          // URLとのマッピング
  public ModelAndView show(ModelAndView mav) {
    // 商品一覧を取得
    ArrayList<Item> itemList = new ListService().getItemList();
    if (null != itemList && !itemList.isEmpty()) {
      mav.addObject("itemList", itemList);
    }
    // Viewのテンプレート名を設定
    mav.setViewName("itemList");
    return mav;
  }

  @RequestMapping(value="/itemlist", method = RequestMethod.POST)          // URLとのマッピング
  public ModelAndView order(@ModelAttribute Order orderForm, ModelAndView mav) {
    // 商品一覧を取得
    if (null != session.getAttribute("cart")) {
      this.cart = (Cart)session.getAttribute("cart");
    } else {
      this.cart = new Cart();
    }
    this.cart.addOrderList(orderForm);
    session.setAttribute("cart", this.cart);
    mav.addObject("cartList", this.cart);
    this.show(mav);
    return mav;
  }
}
