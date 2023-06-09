package fun.cloudtour.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.cloudtour.domain.SysMenu;

import java.util.List;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 通过用户的id 查询用户的菜单数据
     * @param userId
     * @return
     */
    List<SysMenu> selectMenusByUserId(Long userId);
}