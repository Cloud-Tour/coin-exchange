package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.mapper.CoinServerMapper;
import fun.cloudtour.domain.CoinServer;
import fun.cloudtour.service.CoinServerService;
@Service
public class CoinServerServiceImpl extends ServiceImpl<CoinServerMapper, CoinServer> implements CoinServerService{

}
