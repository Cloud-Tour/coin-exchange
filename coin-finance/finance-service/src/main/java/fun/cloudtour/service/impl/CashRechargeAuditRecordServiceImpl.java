package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.CashRechargeAuditRecord;
import fun.cloudtour.mapper.CashRechargeAuditRecordMapper;
import fun.cloudtour.service.CashRechargeAuditRecordService;
@Service
public class CashRechargeAuditRecordServiceImpl extends ServiceImpl<CashRechargeAuditRecordMapper, CashRechargeAuditRecord> implements CashRechargeAuditRecordService{

}
