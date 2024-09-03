package be.bstorm.tf_java2024_demospringapi.pl.controllers;

import be.bstorm.tf_java2024_demospringapi.bll.services.OrderService;
import be.bstorm.tf_java2024_demospringapi.pl.models.order.OrderDTO;
import be.bstorm.tf_java2024_demospringapi.pl.models.order.OrderForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(OrderDTO.fromBusiness(orderService.getOrder(id)));
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderForm form){

        orderService.addOrder(form.toBusiness());
        return ResponseEntity.noContent().build();
    }
}
