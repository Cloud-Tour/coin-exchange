package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.ForexOpenPositionOrder;
import fun.cloudtour.mapper.ForexOpenPositionOrderMapper;
import fun.cloudtour.service.ForexOpenPositionOrderService;
@Service
public class ForexOpenPositionOrderServiceImpl extends ServiceImpl<ForexOpenPositionOrderMapper, ForexOpenPositionOrder> implements ForexOpenPositionOrderService{

}
