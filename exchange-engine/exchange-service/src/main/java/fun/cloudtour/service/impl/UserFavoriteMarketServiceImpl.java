package fun.cloudtour.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.mapper.UserFavoriteMarketMapper;
import fun.cloudtour.domain.UserFavoriteMarket;
import fun.cloudtour.service.UserFavoriteMarketService;
@Service
public class UserFavoriteMarketServiceImpl extends ServiceImpl<UserFavoriteMarketMapper, UserFavoriteMarket> implements UserFavoriteMarketService{
    /**
     * 用户取消收藏
     *
     * @param marketId // 交易市场的id
     * @param userId // 用户的Id
     * @return
     */
    @Override
    public boolean deleteUserFavoriteMarket(Long marketId, Long userId) {
        return remove(new LambdaQueryWrapper<UserFavoriteMarket>()
                .eq(UserFavoriteMarket::getMarketId, marketId)
                .eq(UserFavoriteMarket::getUserId, userId)
        );
    }
}
