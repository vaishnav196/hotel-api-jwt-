package com.HotelManagement.Controller;

import com.HotelManagement.Repository.CartRepo;
import com.HotelManagement.Repository.OrderRepo;
import com.HotelManagement.Repository.ProductRepo;
import com.HotelManagement.Repository.UserRepo;
import com.HotelManagement.model.Cart;
import com.HotelManagement.model.Orders;
import com.HotelManagement.model.Product;
import com.HotelManagement.model.User;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

@Autowired
private CartRepo cartRepo;


@Autowired
private OrderRepo orderRepo;

@Autowired
private UserRepo userRepo;

@Autowired
private ProductRepo productRepo;









//
//
@DeleteMapping("/orders/{orderId}")
    public String deleteOrderFromCart(@PathVariable("orderId") int orderId){


         Orders order=orderRepo.findById(orderId).orElse(null);

         orderRepo.delete(order);


         return "Order removed ";
}
//
//
    @GetMapping("/orders")
    public List<Orders> getallorders(){
      List<Orders> allOrders=orderRepo.findAll();
      return allOrders;

    }

//@DeleteMapping("/{cartId}/orders/{orderId}")
//    public String deleteOrderFromCart(@PathVariable("cartId") int cartId,@PathVariable("orderId") int orderId){
//         Cart cart=cartRepo.findById(cartId).orElse(null);
//
//         Orders order=orderRepo.findById(orderId).orElse(null);
//
//         cart.getOrder().remove(order);
//         orderRepo.delete(order);
//
//
//         return "Order removed ";
//}
//


    @PostMapping("/{userId}/orders/{productId}")
    public String placeOrder(@PathVariable("userId") int userId,@RequestBody Orders orders,@PathVariable("productId") int productId){

        User user=userRepo.findById(userId).orElse(null);
        userRepo.save(user);

        Product prod=productRepo.findById(productId).orElse(null);
        List<Product> product=new ArrayList<>();
        product.add(prod);

        orders.setUser(user);
//        orders.setProducts(product);
        orderRepo.save(orders);

        return "order placeed";

    }





}
