package be.bstorm.tf_java2024_demospringapi.pl.controllers;

import be.bstorm.tf_java2024_demospringapi.bll.services.OrderService;
import be.bstorm.tf_java2024_demospringapi.pl.models.order.OrderForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderForm form){

        orderService.addOrder(form.toBusiness());
        return ResponseEntity.noContent().build();
    }
}
