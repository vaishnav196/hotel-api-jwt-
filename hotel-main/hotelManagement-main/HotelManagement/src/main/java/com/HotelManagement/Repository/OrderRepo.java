package com.HotelManagement.Repository;

import com.HotelManagement.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {


}
