package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.CoinWithdrawAuditRecord;
import fun.cloudtour.mapper.CoinWithdrawAuditRecordMapper;
import fun.cloudtour.service.CoinWithdrawAuditRecordService;
@Service
public class CoinWithdrawAuditRecordServiceImpl extends ServiceImpl<CoinWithdrawAuditRecordMapper, CoinWithdrawAuditRecord> implements CoinWithdrawAuditRecordService{

}
