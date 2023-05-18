package fun.cloudtour.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author cloudtour
 * @version 1.0
 * @description 重置交易密码
 * @date 2023/4/23 22:21
 */
@Data
@ApiModel(value = "重置交易密码")
public class UnsetPayPasswordParam {

    @ApiModelProperty(value = "新的交易密码")
    @NotBlank
    private String payPassword ;

    @ApiModelProperty(value = "手机的验证码")
    @NotBlank
    private String validateCode ;
}
