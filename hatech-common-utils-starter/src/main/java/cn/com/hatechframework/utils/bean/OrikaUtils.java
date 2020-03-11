package cn.com.hatechframework.utils.bean;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.utils.bean
 * @className OrikaUtils
 * @description 实体类转换工具类
 * @author WangMingShuai
 * @create 2019/12/19 18:27
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/19 18:27             1.0                         实体类转换工具类
 */
public class OrikaUtils {

    /**
     * 默认字段工厂
     */
    private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    /**
     * 默认字段实例
     */
    private static final MapperFacade MAPPER_FACADE = MAPPER_FACTORY.getMapperFacade();

    /**
     * 默认字段实例集合
     */
    private static final Map<String, MapperFacade> CACHE_MAPPER_FACADE_MAP = new ConcurrentHashMap<>();


    private OrikaUtils(){}

    /**
     * 映射实体（默认字段）
     *
     * @param toClass 映射类对象
     * @param data    数据（对象）
     * @return 映射类对象
     */
    public static  <E, T> E map(T data, Class<E> toClass) {
        return MAPPER_FACADE.map(data, toClass);
    }

    /**
     * 映射实体（默认字段）
     *
     * @param source   源映射类对象
     * @param target   目标映射类对象
     * @return 映射类对象
     */
    public static <S, D> void map(S source, D target) {
        MAPPER_FACADE.map(source, target);
    }

    /**
     * 映射实体（自定义配置）
     *
     * @param toClass   映射类对象
     * @param data      数据（对象）
     * @param configMap 自定义配置
     * @return 映射类对象
     */
    public static <E, T> E map(T data, Map<String, String> configMap, Class<E> toClass) {
        MapperFacade mapperFacade = getMapperFacade(data.getClass(), configMap, toClass);
        return mapperFacade.map(data, toClass);
    }

    /**
     * 映射集合（默认字段）
     *
     * @param toClass 映射类对象
     * @param data    数据（集合）
     * @return 映射类对象
     */
    public static  <E, T> List<E> mapAsList(Collection<T> data, Class<E> toClass) {
        return MAPPER_FACADE.mapAsList(data, toClass);
    }


    /**
     * 映射集合（自定义配置）
     *
     * @param toClass   映射类
     * @param data      数据（集合）
     * @param configMap 自定义配置
     * @return 映射类对象
     */
    public static  <E, T> List<E> mapAsList(Collection<T> data, Map<String, String> configMap,Class<E> toClass) {
        T t = data.stream().findFirst().orElseThrow(() -> new RuntimeException("映射集合，数据集合为空"));
        MapperFacade mapperFacade = getMapperFacade(t.getClass(), configMap, toClass);
        return mapperFacade.mapAsList(data, toClass);
    }

    /**
     * 获取自定义映射
     *
     * @param toClass   映射类
     * @param dataClass 数据映射类
     * @param configMap 自定义配置
     * @return 映射类对象
     */
    private static  <E, T> MapperFacade getMapperFacade(Class<T> dataClass, Map<String, String> configMap, Class<E> toClass) {
        String mapKey = dataClass.getCanonicalName() + "_" + toClass.getCanonicalName();
        MapperFacade mapperFacade = CACHE_MAPPER_FACADE_MAP.get(mapKey);
        if (Objects.isNull(mapperFacade)) {
            MapperFactory factory = new DefaultMapperFactory.Builder().build();
            ClassMapBuilder<T, E> classMapBuilder = factory.classMap(dataClass, toClass);
            configMap.forEach(classMapBuilder::field);
            classMapBuilder.byDefault().register();
            mapperFacade = factory.getMapperFacade();
            CACHE_MAPPER_FACADE_MAP.put(mapKey, mapperFacade);
        }
        return mapperFacade;
    }

    /**
     * @description 注册class类映射
     * @param dataClass  被转换class类
     * @param toClass  转换成class类
     * @author YeMeng
     * @date 2019/12/26 19:55
     * @return void
     */
    public static <E, T> void registerClassMap(Class<T> dataClass, Class<E> toClass) {
        MAPPER_FACTORY.registerClassMap(MAPPER_FACTORY
                        .classMap(dataClass, toClass)
                        .byDefault()
                        .toClassMap());
    }


}
