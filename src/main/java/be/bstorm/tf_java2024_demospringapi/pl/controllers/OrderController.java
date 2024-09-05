package be.bstorm.tf_java2024_demospringapi.pl.controllers;

import be.bstorm.tf_java2024_demospringapi.bll.services.OrderService;
import be.bstorm.tf_java2024_demospringapi.dl.entities.User;
import be.bstorm.tf_java2024_demospringapi.pl.models.order.OrderDTO;
import be.bstorm.tf_java2024_demospringapi.pl.models.order.OrderForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> createOrder(
            @Valid @RequestBody OrderForm form,
            Authentication authentication
    ){
        User currentUser = (User) authentication.getPrincipal();
        orderService.addOrder(form.toBusiness(),currentUser);
        return ResponseEntity.noContent().build();
    }
}
