package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.mapper.UserFavoriteMarketMapper;
import fun.cloudtour.domain.UserFavoriteMarket;
import fun.cloudtour.service.UserFavoriteMarketService;
@Service
public class UserFavoriteMarketServiceImpl extends ServiceImpl<UserFavoriteMarketMapper, UserFavoriteMarket> implements UserFavoriteMarketService{

}
