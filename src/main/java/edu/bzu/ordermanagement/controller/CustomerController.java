package edu.bzu.ordermanagement.controller;

import edu.bzu.ordermanagement.entity.Customer;
import edu.bzu.ordermanagement.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Create a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created the customer",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.create(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the customers",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))})})
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @Operation(summary = "Get a customer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the customer",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@Parameter(description = "id of the customer to be searched") @PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Update an existing customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the customer",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content)})
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @Parameter(description = "id of the customer to be updated") @PathVariable Long id) {
        Customer updatedCustomer = customerService.update(customer, id);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deleted the customer",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content)})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@Parameter(description = "id of the customer to be deleted") @PathVariable Long id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // the action has been enacted and no further information is to be supplied.
    }
}