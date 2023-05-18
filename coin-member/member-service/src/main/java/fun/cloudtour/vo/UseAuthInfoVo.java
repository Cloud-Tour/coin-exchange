package fun.cloudtour.vo;

import fun.cloudtour.domain.User;
import fun.cloudtour.domain.UserAuthAuditRecord;
import fun.cloudtour.domain.UserAuthInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/18 21:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "用户认证的详细信息")
public class UseAuthInfoVo  implements Serializable {

    @ApiModelProperty(value = "用户")
    private User user ;

    @ApiModelProperty(value = "用户认证的详情列表")
    private List<UserAuthInfo> userAuthInfoList ;

    @ApiModelProperty(value = "用户审核历史")
    private List<UserAuthAuditRecord> authAuditRecordList ;

}
