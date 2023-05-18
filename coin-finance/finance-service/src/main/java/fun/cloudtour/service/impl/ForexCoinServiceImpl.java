package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.ForexCoin;
import fun.cloudtour.mapper.ForexCoinMapper;
import fun.cloudtour.service.ForexCoinService;
@Service
public class ForexCoinServiceImpl extends ServiceImpl<ForexCoinMapper, ForexCoin> implements ForexCoinService{

}
