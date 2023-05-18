package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.UserCoinFreeze;
import fun.cloudtour.mapper.UserCoinFreezeMapper;
import fun.cloudtour.service.UserCoinFreezeService;
@Service
public class UserCoinFreezeServiceImpl extends ServiceImpl<UserCoinFreezeMapper, UserCoinFreeze> implements UserCoinFreezeService{

}
