package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.mapper.ForexAccountDetailMapper;
import fun.cloudtour.domain.ForexAccountDetail;
import fun.cloudtour.service.ForexAccountDetailService;
@Service
public class ForexAccountDetailServiceImpl extends ServiceImpl<ForexAccountDetailMapper, ForexAccountDetail> implements ForexAccountDetailService{

}
