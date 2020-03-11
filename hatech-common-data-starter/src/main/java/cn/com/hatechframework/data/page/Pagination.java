package cn.com.hatechframework.data.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.data.page
 * @className Pagination
 * @description 分页信息类
 * @author JiangXincan
 * @create 2019/12/18 13:12
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 13:12             1.0                         分页信息类
 */
public class Pagination{


    private static final String PARAMS_PAGE = "page";
    private static final String PARAMS_LIMIT = "limit";

    private Pagination() { }

    /**
     * @description 分页信息
     * @param map   包含page，limit属性信息
     * @author JiangXincan
     * @date 2019/12/18 13:14
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page
     */
    public static Page page(Map<String, Object> map){
        long page = 0;
        long limit = 0;
        if(map.containsKey(PARAMS_PAGE) && map.containsKey(PARAMS_LIMIT)){
            page = Integer.parseInt(map.get(PARAMS_PAGE).toString());
            limit = Integer.parseInt(map.get(PARAMS_LIMIT).toString());

        }
        return new Page(page, limit);
    }

    /**
     * @description 分页信息
     * @param page   包含page，limit属性信息
     * @author JiangXincan
     * @date 2019/12/18 13:14
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page
     */
    public static <T extends PaginationQuery> Page page(T page){
        return new Page(page.getPage(), page.getLimit());
    }

    /**
     * @description 分页信息
     * @param page   当前页
     * @param limit  每页显示条数
     * @author JiangXincan
     * @date 2019/12/18 13:14
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page
     */
    public static Page page(Integer page, Integer limit){
        return new Page(page, limit);
    }

}
