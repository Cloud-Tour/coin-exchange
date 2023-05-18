package fun.cloudtour.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author cloudtour
 * @version 1.0
 * @description 银行卡的参数
 * @date 2023/4/27 21:12
 */

@Data
@ApiModel(value = "银行卡的参数")
public class AdminBankDto {

    @ApiModelProperty(value = "开户行的人名称")
    private String name ;

    @ApiModelProperty(value = "开户行的银行名称")
    private String bankName ;

    @ApiModelProperty(value = "开户行的银行卡号")
    private String bankCard ;
}