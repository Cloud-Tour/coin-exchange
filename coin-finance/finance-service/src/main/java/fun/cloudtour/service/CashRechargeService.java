package fun.cloudtour.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.cloudtour.domain.CashRecharge;
import com.baomidou.mybatisplus.extension.service.IService;
import fun.cloudtour.domain.CashRechargeAuditRecord;
import fun.cloudtour.model.CashParam;
import fun.cloudtour.vo.CashTradeVo;

public interface CashRechargeService extends IService<CashRecharge> {

    /**
     * 条件分页查询
     *
     * @param page      分页参数
     * @param coinId    币种的ID
     * @param userId    用户的Id
     * @param userName  用户的名称
     * @param mobile    用户的手机号
     * @param status    审核的状态
     * @param numMin    充值数量的最小值
     * @param numMax    充值数量的最大值
     * @param startTime 充值的开始时间
     * @param endTime   充值数量的结束时间
     * @return
     */
    Page<CashRecharge> findByPage(Page<CashRecharge> page, Long coinId, Long userId, String userName, String mobile,
                                  Byte status, String numMin, String numMax, String startTime, String endTime);

    /**
     * 现金的充值审核
     *
     * @param userId                  审核人
     * @param cashRechargeAuditRecord 审核的数据
     * @return 是否审核成功
     */
    boolean cashRechargeAudit(Long userId, CashRechargeAuditRecord cashRechargeAuditRecord);

    /**
     * 查询当前用户的充值的数据
     *
     * @param page   分页对象
     * @param userId 用户的Id
     * @param status 订单的状态
     * @return
     */

    Page<CashRecharge> findUserCashRecharge(Page<CashRecharge> page, Long userId, Byte status);


    /**
     * 进行一个GCN/充值/购买
     *
     * @param userId    用户的id
     * @param cashParam 现金参数
     * @return
     */
    CashTradeVo buy(Long userId, CashParam cashParam);

}
