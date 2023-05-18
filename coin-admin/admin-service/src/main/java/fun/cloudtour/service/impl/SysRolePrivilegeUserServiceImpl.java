package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.mapper.SysRolePrivilegeUserMapper;
import fun.cloudtour.domain.SysRolePrivilegeUser;
import fun.cloudtour.service.SysRolePrivilegeUserService;
@Service
public class SysRolePrivilegeUserServiceImpl extends ServiceImpl<SysRolePrivilegeUserMapper, SysRolePrivilegeUser> implements SysRolePrivilegeUserService{

}
