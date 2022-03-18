package labs.entity;


import labs.vo.OrderStatus;
import labs.vo.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/** Create class Order that implements
 * id, status:OrderStatus, List<OrderLine> orderLines, creationDate, totalPrice, paymentMethod,
 * deliveryDueDate, user
 *
 * Implements constructors: default, by status, by id, by array of lines (use ...)
 * getters, setters, toString, isActive
 */
public class Order {


    private static int id = 10000;
    private OrderStatus status;
    private List<OrderLine> orderLines;
    private LocalDate creationDate, deliveryDate;
    private BigDecimal totalPrice;
    private User user;
    private PaymentMethod paymentMethod;


    public Order(){
        id++;
        status =  OrderStatus.DRAFT;
        orderLines = new ArrayList<OrderLine>();
        creationDate = LocalDate.now();
        deliveryDate = LocalDate.MIN;
        totalPrice = BigDecimal.ZERO;
        user = new User();
        paymentMethod = PaymentMethod.CASH_ON_DELIVERY;
    }

    public Order(OrderStatus status){
        id++;
        this.status =  status;
        orderLines = new ArrayList<OrderLine>();
        creationDate = LocalDate.now();
        deliveryDate = LocalDate.MIN;
        totalPrice = BigDecimal.ZERO;
        user = new User();
        paymentMethod = PaymentMethod.CASH_ON_DELIVERY;
    }
    public Order(int id){
        this.id = id;
        status =  OrderStatus.DRAFT;
        orderLines = new ArrayList<OrderLine>();
        creationDate = LocalDate.now();
        deliveryDate = LocalDate.MIN;
        totalPrice = BigDecimal.ZERO;
        user = new User();
        paymentMethod = PaymentMethod.CASH_ON_DELIVERY;
    }

    public Order(OrderLine... orderLines){
        id++;
        status =  OrderStatus.DRAFT;
        this.orderLines = Arrays.stream(orderLines).toList();
        creationDate = LocalDate.now();
        deliveryDate = LocalDate.MIN;
        totalPrice = BigDecimal.ZERO;
        user = new User();
        paymentMethod = PaymentMethod.CASH_ON_DELIVERY;
    }

    public boolean isActive(){
        return deliveryDate.isAfter(LocalDate.now());
    }

}
