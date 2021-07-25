package com.springinaction.tacos.web;

import com.springinaction.tacos.Order;
import com.springinaction.tacos.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // 주문서 Form > View
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    // 주문 처리
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        orderRepository.save(order);
        sessionStatus.setComplete(); // 같은 세션으로 해당 컨트롤러로 해당 메소드 호출 시 order 객체를 삭제하지 않고 저장 (setComplete - sessionStatus 해제)

        return "redirect:/"; // 작업 완료 후 WebConfig 에 정의한 /의 home > View 로 리다이렉트
    }
}
