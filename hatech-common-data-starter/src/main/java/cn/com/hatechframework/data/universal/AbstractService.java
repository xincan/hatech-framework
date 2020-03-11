package cn.com.hatechframework.data.universal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.data.universal
 * @className AbstractService
 * @description 通用MyBatis-Plus Mapper插件的抽象接口实现类
 * @author JiangXincan
 * @create 2019/12/18 10:37
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 10:37             1.0                         通用MyBatis-Plus Mapper插件的抽象接口实现类
 */
public abstract class AbstractService<T> implements IBaseService<T> {

    @Autowired
    protected IBaseMapper<T> baseMapper;

    protected Class<T> currentModelClass() {
        return (Class<T>) ReflectionKit.getSuperClassGenericType(this.getClass(), 1);
    }

    protected String sqlStatement(SqlMethod sqlMethod) {
        return SqlHelper.table(this.currentModelClass()).getSqlStatement(sqlMethod.getMethod());
    }

    protected SqlSession sqlSessionBatch() {
        return SqlHelper.sqlSessionBatch(this.currentModelClass());
    }


    /**
     * @param model 将要添加的对象数据
     *  添加对象信息
     * @Param <T>       数据类型
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.lang.Integer
     */
    @SuppressWarnings("unchecked")
    @Override
    public Integer insert(T model) {
        return baseMapper.insert(model);
    }

    /**
     * @param id 将要删除的数据ID
     *  根据ID删除对象信息
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.lang.Integer
     */
    @SuppressWarnings("unchecked")
    @Override
    public Integer deleteById(String id) {
        return baseMapper.deleteById(id);
    }

    /**
     * @param model 将要更新的对象数据
     *  更新对象信息
     * @Param <T>       数据类型
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return int
     */
    @SuppressWarnings("unchecked")
    @Override
    public int update(T model) {
        return baseMapper.updateById(model);
    }

    /**
     * @param id 将要查询的数据ID
     *  根据ID查询对象信息
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return T
     */
    @SuppressWarnings("unchecked")
    @Override
    public T selectById(String id) {
        return baseMapper.selectById(id);
    }

    /**
     * @param ids 将要删除的数据ID
     *  根据一批数据ID删除对应的数据信息
     * <font>扩展函数</font>
     * eg：传入的ids -> “1,2,3,4”
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.lang.Integer
     */
    @SuppressWarnings("unchecked")
    @Override
    public Integer deleteByIds(String ids) {
        Collection list = Arrays.asList(ids.split(","));
        return baseMapper.deleteBatchIds(list);
    }

    /**
     * @param ids 将要查询的数据ID
     *  根据一批数据ID查询对应的数据信息
     * <font>扩展函数</font>
     * eg：传入的ids -> “1,2,3,4”
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.util.List<T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> selectListByIds(String ids) {
        ids = "'" + ids.replace(",", "','") + "'";
        Collection<? extends Serializable> list = Arrays.asList(ids.split(","));
        return baseMapper.selectBatchIds(list);
    }

    /**
     *  查询所有对象信息
     * <font>扩展函数</font>
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.util.List<T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> selectAll() {
        return baseMapper.selectList(null);
    }

    /**
     * @param model 将要更新的对象数据
     *  根据实体类查询对象信息
     * <font>扩展函数</font>
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return java.util.List<T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> select(T model) {
        QueryWrapper<T> wrapper = new QueryWrapper<>(model);
        return baseMapper.selectList(wrapper);
    }

    /**
     * @param model 将要更新的对象数据
     *  根据实体类查询对象信息
     * <font>扩展函数</font>
     * @author JiangXincan
     * @date 2019/12/18 10:55
     * @return <T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public T selectOne(T model) {
        QueryWrapper<T> wrapper = new QueryWrapper<>(model);
        return baseMapper.selectOne(wrapper);
    }

    /**
     *     根据对象集合，批量添加数据
     * @param record    对象集合
     * @param size      批量插入数据条数
     * @author JiangXincan
     * @date 2020/1/21 17:26
     * @return boolean
     */
    @Override
    public boolean saveBatch(List<T> record, Integer size) {
        String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
        try (SqlSession batchSqlSession = sqlSessionBatch()) {
            int i = 0;
            for (T entity : record) {
                batchSqlSession.insert(sqlStatement, entity);
                if (i >= 1 && i % size == 0) {
                    batchSqlSession.flushStatements();
                }
                i++;
            }
            batchSqlSession.flushStatements();
        }
        return true;
    }

    /**
     *     根据对象集合，批量修改数据
     * @param record    对象集合
     * @param size      批量修改数据条数
     * @author JiangXincan
     * @date 2020/1/21 17:29
     * @return boolean
     */
    @Override
    public boolean updateBatchById(List<T> record, Integer size) {
        Assert.notEmpty(record, "error: entityList must not be empty");
        String sqlStatement = sqlStatement(SqlMethod.UPDATE_BY_ID);
        try (SqlSession batchSqlSession = sqlSessionBatch()) {
            int i = 0;
            for (T entity : record) {
                MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
                param.put(Constants.ENTITY, entity);
                batchSqlSession.update(sqlStatement, param);
                if (i >= 1 && i % size == 0) {
                    batchSqlSession.flushStatements();
                }
                i++;
            }
            batchSqlSession.flushStatements();
        }
        return true;
    }
}
