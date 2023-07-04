package edu.bzu.ordermanagement.service.impl;

import edu.bzu.ordermanagement.entity.Order;
import edu.bzu.ordermanagement.entity.Product;
import edu.bzu.ordermanagement.entity.ProductOrder;
import edu.bzu.ordermanagement.repository.ProductOrderRepository;
import edu.bzu.ordermanagement.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private ProductOrderRepository productOrderRepository;

    @Autowired
    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }


    @Override
    public ProductOrder createProductOrder(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public List<ProductOrder> getProductOrders() {
        return productOrderRepository.findAll();
    }

    @Override
    public List<ProductOrder> getProductOrdersByProductID(Long productId) {

        return productOrderRepository.findByProductId(productId);
    }

    @Override
    public List<ProductOrder> getProductOrdersByOrderID(Long orderId) {
        return productOrderRepository.findByOrderId(orderId);
    }

    @Override
    public Optional<ProductOrder> getProductOrder(Long orderId, Long productId) {
        return productOrderRepository.findByOrderIdAndProductId(orderId, productId);
    }

    @Override
    public ProductOrder updateProductOrder(ProductOrder updatedProductOrder, Long orderId, Long productId) {
        // find the productOrder by orderId and productId then update it
        // if not found return null
        try {
            Optional<ProductOrder> productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId);
            if (productOrder.isPresent()) {
                productOrder.get().setQuantity(updatedProductOrder.getQuantity());
                productOrder.get().setPrice(updatedProductOrder.getPrice());
                return productOrderRepository.save(productOrder.get());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public void deleteProductOrder(Long orderId, Long productId) {
        // find the productOrder by orderId and productId then delete it
        // if not found return null
        try {
            Optional<ProductOrder> productOrder = productOrderRepository.findByOrderIdAndProductId(orderId, productId);
            if (productOrder.isPresent()) {
                productOrderRepository.delete(productOrder.get());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
