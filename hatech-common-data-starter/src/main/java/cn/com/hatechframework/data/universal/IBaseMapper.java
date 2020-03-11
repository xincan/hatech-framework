package cn.com.hatechframework.data.universal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.data.universal
 * @className IBaseMapper
 * @description 基础实现MyBatisPlus BaseMapper数据访问层接口
 * @author JiangXincan
 * @create 2019/12/18 10:43
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 10:43             1.0                         基础实现MyBatisPlus BaseMapper数据访问层接口
 */
@Component
public interface IBaseMapper<T> extends BaseMapper<T> {
}
