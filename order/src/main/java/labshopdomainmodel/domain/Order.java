package labshopdomainmodel.domain;

import labshopdomainmodel.domain.OrderPlaced;
import labshopdomainmodel.domain.OrderCancelled;
import labshopdomainmodel.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String productId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String customerId;
    
    
    
    @Embedded
    @AttributeOverride(name="amount", column= @Column(name="moneyAmount", nullable=true))

    private Money amount;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String address;
    
    
    
    @ElementCollection
    
    private List<OrderItem> orderItems;

    @PostPersist
    public void onPostPersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
        // Get request from Inventory
        //labshopdomainmodel.external.Inventory inventory =
        //    Application.applicationContext.getBean(labshopdomainmodel.external.InventoryService.class)
        //    .getInventory(/** mapping value needed */);

    }
    @PreRemove
    public void onPreRemove(){


        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
