package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.ForexClosePositionOrder;
import fun.cloudtour.mapper.ForexClosePositionOrderMapper;
import fun.cloudtour.service.ForexClosePositionOrderService;
@Service
public class ForexClosePositionOrderServiceImpl extends ServiceImpl<ForexClosePositionOrderMapper, ForexClosePositionOrder> implements ForexClosePositionOrderService{

}
