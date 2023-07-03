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
    public List<ProductOrder> getProductOrdersByProductID(Long productId) {
        ProductOrder productOrderExample = new ProductOrder();
        Product product = new Product();
        product.setId(productId);
        productOrderExample.setProduct(product);
        Example<ProductOrder> example = Example.of(productOrderExample);
        return productOrderRepository.findAll(example);
    }

    @Override
    public List<ProductOrder> getProductOrdersByOrderID(Long orderId) {
        ProductOrder productOrderExample = new ProductOrder();
        Order order = new Order();
        order.setId(orderId);
        productOrderExample.setOrder(order);
        Example<ProductOrder> example = Example.of(productOrderExample);
        return productOrderRepository.findAll(example);
    }

    @Override
    public Optional<ProductOrder> getProductOrder(Long orderId, Long productId) {
        if (orderId == null || productId == null) {
            return Optional.empty();
        }
        return findProductOrder(orderId, productId);
    }

    @Override
    public ProductOrder updateProductOrder(ProductOrder updatedProductOrder, Long orderId, Long productId) {
        // find the productOrder by orderId and productId then update it
        // if not found return null
        try {
            Optional<ProductOrder> productOrder = findProductOrder(orderId, productId);
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
        // create Example of productOrder with product and order objects then use findOne
        // to get the productOrder then delete it
        Optional<ProductOrder> productOrder = findProductOrder(orderId, productId);
        productOrder.ifPresent(productOrderRepository::delete);
    }

    /**
     * Retrieves productOrder by orderId and productId
     */
    private Optional<ProductOrder> findProductOrder(Long orderId, Long productId) {
        ProductOrder productOrderExample = new ProductOrder();
        Order order = new Order();
        order.setId(orderId);
        Product product = new Product();
        product.setId(productId);
        productOrderExample.setOrder(order);
        productOrderExample.setProduct(product);
        Example<ProductOrder> example = Example.of(productOrderExample);
        return productOrderRepository.findOne(example);
    }
}
