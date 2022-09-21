package labshopdomainmodel.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Embeddable
@Data
public class OrderItem {

    
    
    
    private String productId;
    
    
    
    private Integer qty;
    
    
    @Embedded
    private Money amount;



}

