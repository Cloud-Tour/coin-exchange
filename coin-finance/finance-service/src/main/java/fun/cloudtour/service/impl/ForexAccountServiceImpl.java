package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.ForexAccount;
import fun.cloudtour.mapper.ForexAccountMapper;
import fun.cloudtour.service.ForexAccountService;
@Service
public class ForexAccountServiceImpl extends ServiceImpl<ForexAccountMapper, ForexAccount> implements ForexAccountService{

}
