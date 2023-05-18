package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.CoinBalance;
import fun.cloudtour.mapper.CoinBalanceMapper;
import fun.cloudtour.service.CoinBalanceService;
@Service
public class CoinBalanceServiceImpl extends ServiceImpl<CoinBalanceMapper, CoinBalance> implements CoinBalanceService{

}
