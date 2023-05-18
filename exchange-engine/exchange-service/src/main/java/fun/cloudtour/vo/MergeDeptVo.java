package fun.cloudtour.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cloudtour
 * @version 1.0
 * @description 合并的深度
 * @date 2023/4/29 21:50
 */
@Data
@ApiModel(value = "合并的深度")
public class MergeDeptVo {

    /**
     * 合并类型
     */
    @ApiModelProperty(value = "合并类型")
    private String mergeType;

    /**
     * 合并精度
     */
    @ApiModelProperty(value = "合并精度")
    private BigDecimal value;
}

