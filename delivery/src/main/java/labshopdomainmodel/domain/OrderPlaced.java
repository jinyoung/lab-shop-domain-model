package labshopdomainmodel.domain;

import labshopdomainmodel.domain.*;
import labshopdomainmodel.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private String customerId;
    private String status;
    private String address;
    private Object amount;
    private Object orderItems;
}


