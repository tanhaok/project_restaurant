package com.hcmute.controller.user;

import com.hcmute.dao.CartDao;
import com.hcmute.dao.ProductDao;
import com.hcmute.model.AccountModel;
import com.hcmute.model.CartModel;
import com.hcmute.model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    public CartDao cartDao = new CartDao();
    public ProductDao productDao = new ProductDao();

    private int existProduct(int product_id, List<CartModel> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProductId() == product_id) {
                return i;
            }

        }
        return -1;
    }

    @RequestMapping("/add/{product_id}")
    public ModelAndView Add(HttpSession session, @PathVariable int product_id) {
        ModelAndView mav = new ModelAndView("redirect:/view-product/" + product_id);
        AccountModel account = (AccountModel) session.getAttribute("account"); // TODO thiếu customer id
        ProductModel product = productDao.getProductById(product_id);
        CartModel itemCart = new CartModel();
        itemCart.setProductId(product.getId());
        itemCart.setProductAmount(1);
        itemCart.setCusId(3); //TODO thiếu customer id
        itemCart.setImg(product.getImg());
        itemCart.setProduct_name(product.getName());
        itemCart.setProduct_price(product.getPrice());
        itemCart.setState(0);
        if (cartDao.existCart(3)) //TODO thiếu customer id
        {
            List<CartModel> cart = cartDao.selectCart(3); // TODO thiếu customer id
            int i = existProduct(product_id, cart);
            if (i != -1) {
                cart.get(i).setProductAmount(cart.get(i).getProductAmount() + 1);
                cartDao.updateCart(cart.get(i));
            } else {
                int cart_id = cartDao.getIdCart(3);//TODO thiếu customer id
                itemCart.setId(cart_id);
                cartDao.insertCart(itemCart);
            }
        }
        else{
            cartDao.createCart(itemCart);
            int cart_id = cartDao.getIdCart(3);//TODO thiếu customer id
            itemCart.setId(cart_id);
            cartDao.insertCart(itemCart);
        }
        return mav;
    }

    @RequestMapping("/view/{customer_id}")
    public ModelAndView Index(@PathVariable int customer_id) {
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("cart", cartDao.selectCart(customer_id));
        return mav;
    }

}
