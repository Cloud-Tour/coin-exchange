package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.CashWithdrawAuditRecord;
import fun.cloudtour.mapper.CashWithdrawAuditRecordMapper;
import fun.cloudtour.service.CashWithdrawAuditRecordService;
@Service
public class CashWithdrawAuditRecordServiceImpl extends ServiceImpl<CashWithdrawAuditRecordMapper, CashWithdrawAuditRecord> implements CashWithdrawAuditRecordService{

}
