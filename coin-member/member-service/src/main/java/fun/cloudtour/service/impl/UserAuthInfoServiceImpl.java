package fun.cloudtour.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.domain.UserAuthInfo;
import fun.cloudtour.mapper.UserAuthInfoMapper;
import fun.cloudtour.service.UserAuthInfoService;

@Service
public class UserAuthInfoServiceImpl extends ServiceImpl<UserAuthInfoMapper, UserAuthInfo> implements UserAuthInfoService {
    /**
     * 通过认证的Code 来查询用户的认证详情
     *
     * @param authCode 认证的唯一Code
     * @return
     */
    @Override
    public List<UserAuthInfo> getUserAuthInfoByCode(Long authCode) {
        return list(new LambdaQueryWrapper<UserAuthInfo>()
                .eq(UserAuthInfo::getAuthCode, authCode) // 通过认证的唯一Code 来查询用户的认证信息了
        );
    }

    /**
     * 用户未被认证,我们需要通过用户的ID 查询用户的额认证列表
     *
     * @param id
     * @return
     */
    @Override
    public List<UserAuthInfo> getUserAuthInfoByUserId(Long id) {
        List<UserAuthInfo> list = list(new LambdaQueryWrapper<UserAuthInfo>()
                .eq(UserAuthInfo::getUserId, id)
                .orderByDesc(UserAuthInfo::getCreated)
                .last("limit 3")
        );
        return list == null ? Collections.emptyList() : list; // 处理null
    }
}
