package cn.com.hatechframework.data.universal;

import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.data.universal
 * @className IBaseService
 * @description MyBatisPlus基础接口层
 * @author JiangXincan
 * @create 2019/12/18 10:41
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 10:41             1.0                         MyBatisPlus基础接口层
 */
public interface IBaseService<T> {

    /**
     * 添加对象信息
     * @param model     将要添加的对象数据
     * @Param <T>       数据类型
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.lang.Integer
     */
    Integer insert(T model);

    /**
     * 根据ID删除对象信息
     * @param id 将要删除的数据ID
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.lang.Integer
     */
    Integer deleteById(String id);

    /**
     * 更新对象信息
     * @param model     将要更新的对象数据
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return int
     */
    int update(T model);

    /**
     * 根据ID查询对象信息
     * @param id 将要查询的数据ID
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return T
     */
    T selectById(String id);

    /**
     *
     * 根据一批数据ID删除对应的数据信息
     *  <font>扩展函数</font>
     *  eg：传入的ids -> “1,2,3,4”
     * @param ids 将要删除的数据ID
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.lang.Integer
     */
    Integer deleteByIds(String ids);

    /**
     *
     * 根据一批数据ID查询对应的数据信息
     *  <font>扩展函数</font>
     *  eg：传入的ids -> “1,2,3,4”
     * @param ids 将要查询的数据ID
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.util.List<T>
     */
    List<T> selectListByIds(String ids);

    /**
     *
     * 查询所有对象信息
     * <font>扩展函数</font>
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.util.List<T>
     */
    List<T> selectAll();

    /**
     * 根据实体类查询对象信息
     * <font>扩展函数</font>
     * @param record 实体类
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.util.List<T>
     */
    List<T> select(T record);

    /**
     * 根据实体类查询对象信息
     * <font>扩展函数</font>
     * @param record   数据类型
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return <T>
     */
    T selectOne(T record);

    /**
     * 根据集合对象，批量插入数据
     * @author JiangXincan
     * @param record   数据集合
     * @param size      集合长度
     * @date 2019/12/18 10:55
     * @return <T>
     */
    boolean saveBatch(List<T> record, Integer size);

    /**
     * 根据集合对象，批量修改数据
     * 必须包含ID
     * @param record   数据集合
     * @param size      集合长度
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return <T>
     */
    boolean updateBatchById(List<T> record, Integer size);
}
