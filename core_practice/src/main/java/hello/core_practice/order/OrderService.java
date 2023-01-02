package hello.core_practice.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
