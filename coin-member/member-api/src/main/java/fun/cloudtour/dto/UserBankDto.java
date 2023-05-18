package fun.cloudtour.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author cloudtour
 * @version 1.0
 * @description 用户银行卡的传输对象
 * @date 2023/4/27 23:39
 */
@Data
@ApiModel(value = "用户银行卡的传输对象")
public class UserBankDto {
    /**
     * 开户人
     */
    @ApiModelProperty(value="开户人")
    private String realName;

    /**
     * 开户行
     */
    @ApiModelProperty(value="开户行")
    private String bank;

    /**
     * 开户省
     */
    @ApiModelProperty(value="开户省")
    private String bankProv;

    /**
     * 开户市
     */
    @ApiModelProperty(value="开户市")
    private String bankCity;

    /**
     * 开户地址
     */
    @ApiModelProperty(value="开户地址")
    private String bankAddr;

    /**
     * 开户账号
     */
    @ApiModelProperty(value="开户账号")
    private String bankCard;

}

