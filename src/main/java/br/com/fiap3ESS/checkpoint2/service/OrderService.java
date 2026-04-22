package br.com.fiap3ESS.checkpoint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.fiap3ESS.checkpoint2.model.OrderModel;
import br.com.fiap3ESS.checkpoint2.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    private String messageError = "Pedido não encontrado com o ID: ";

    public OrderModel createOrder(OrderModel order){
        return orderRepository.save(order);
    }

    public List<OrderModel> readAllOrders(){
        return orderRepository.findAll();
    }

    public OrderModel readOrderById(Long id){
        return orderRepository.findById(id)
        .orElseThrow(() -> 
        new EntityNotFoundException(messageError + id)
    );
    }

    public OrderModel updateOrder(Long id, OrderModel order){
        return orderRepository.findById(id)
            .map(existingOrder -> {
                existingOrder.setClientName(order.getClientName());
                existingOrder.setTotalValue(order.getTotalValue());
                return orderRepository.save(existingOrder);
            })
            .orElseThrow(() -> 
                new EntityNotFoundException(messageError + id)
            );
    }

    public void deleteOrderById(Long id){
        try{
            orderRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new EntityNotFoundException(messageError + id);
        }
            
        }
}
