package fun.cloudtour.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author cloudtour
 * @version 1.0
 * @description 前端的登录参数
 * @date 2023/4/21 11:14
 */
@Data
@ApiModel(value = "前端的登录参数")
public class LoginForm extends GeetestForm{

    @ApiModelProperty(value = "电话的国家区号")
    private String countryCode ;

    @ApiModelProperty(value = "用户名称")
    private String username ;

    @ApiModelProperty(value = "用户的UUID")
    private String uuid ;

    @ApiModelProperty(value = "用户密码")
    @NotBlank
    private String password ;

}
