package com.zhunzhong.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhunzhong.demo.pojo.entity.TConfig;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhunzhong
 * @since 2022-06-17
 */
@Mapper
public interface TConfigMapper extends BaseMapper<TConfig> {

}
