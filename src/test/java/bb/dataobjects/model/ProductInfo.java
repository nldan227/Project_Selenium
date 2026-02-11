package bb.dataobjects.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductInfo {
    public String name;
    public BigDecimal price;
    public int quantity;

}

