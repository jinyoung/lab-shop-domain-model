package labshopdomainmodel.domain;

import labshopdomainmodel.domain.*;
import labshopdomainmodel.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private String customerId;
    private String status;
    private String address;
    private Money amount;
    private List<OrderItem> orderItems;

    public OrderPlaced(Order aggregate){
        super(aggregate);
    }
    public OrderPlaced(){
        super();
    }
}
