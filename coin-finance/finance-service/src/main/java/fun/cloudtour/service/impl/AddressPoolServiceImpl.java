package fun.cloudtour.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.cloudtour.mapper.AddressPoolMapper;
import fun.cloudtour.domain.AddressPool;
import fun.cloudtour.service.AddressPoolService;
@Service
public class AddressPoolServiceImpl extends ServiceImpl<AddressPoolMapper, AddressPool> implements AddressPoolService{

}
