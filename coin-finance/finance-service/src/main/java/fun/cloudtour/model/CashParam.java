package fun.cloudtour.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author cloudtour
 * @version 1.0
 * @description 现金充值参数
 * @date 2023/4/27 21:00
 */
@Data
@ApiModel(value = "现金充值参数")
public class CashParam {

    @ApiModelProperty(value = "币种的ID")
    @NotNull
    private Long coinId ;

    @ApiModelProperty(value = "购买的数量")
    @NotNull
    private BigDecimal num ;

    @ApiModelProperty(value = "实际金额")
    @NotNull
    private BigDecimal mum ;
}

