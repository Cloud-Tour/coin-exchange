package fun.cloudtour.controller;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.cloudtour.domain.SysPrivilege;
import fun.cloudtour.model.R;
import fun.cloudtour.service.SysPrivilegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

/**
 * @author cloudtour
 * @version 1.0
 * @description 权限的管理
 * @date 2023/4/12 20:49
 */
@RestController
@RequestMapping("/privileges")
@Api(tags = "权限的管理")
public class SysPrivilegeController {

    @Autowired
    private SysPrivilegeService sysPrivilegeService ;


    /**
     * 权限数据的分页查询
     * @param page
     * @return
     */
    @GetMapping
    @ApiOperation(value = "分页查询权限数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页") ,
            @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
    })
    @PreAuthorize("hasAuthority('sys_privilege_query')")
    public R<Page<SysPrivilege>> findByPage(@ApiIgnore Page<SysPrivilege> page){

        // 查询时，将最近新增的、修改的数据优先展示-> 排序->lastUpdateTime
        page.addOrder(OrderItem.desc("last_update_time")) ;
        Page<SysPrivilege> sysPrivilegePage = sysPrivilegeService.page(page);
        return R.ok(sysPrivilegePage) ;
    }


    @PostMapping
    @ApiOperation(value = "新增一个权限")
    @PreAuthorize("hasAuthority('sys_privilege_create')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPrivilege" ,value = "sysPrivilege 的json数据")
    })
    public R add(@RequestBody @Validated SysPrivilege sysPrivilege){
        // 新增时，需要给新增对象填充一些属性
        String userIdStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        sysPrivilege.setCreateBy(Long.valueOf(userIdStr));
        sysPrivilege.setCreated(new Date());
        sysPrivilege.setLastUpdateTime(new Date());
        boolean save = sysPrivilegeService.save(sysPrivilege);
        if(save){
            return R.ok("新增成功") ;
        }
        return  R.fail("新增失败") ;
    }


    @PatchMapping
    @ApiOperation(value = "修改一个权限")
    @PreAuthorize("hasAuthority('sys_privilege_update')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPrivilege" ,value = "sysPrivilege 的json数据")
    })
    public R update(@RequestBody @Validated SysPrivilege sysPrivilege){
        // 修改时，也需要给新增对象填充一些属性
        String userIdStr = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        sysPrivilege.setModifyBy(Long.valueOf(userIdStr));
        sysPrivilege.setLastUpdateTime(new Date());

        boolean save = sysPrivilegeService.updateById(sysPrivilege);
        if(save){
            return R.ok("修改成功") ;
        }
        return  R.fail("修改失败") ;
    }
}
