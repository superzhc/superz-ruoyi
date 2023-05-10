package com.ruoyi.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.data.mapper.TRsshubMapper;
import com.ruoyi.data.domain.TRsshub;
import com.ruoyi.data.service.ITRsshubService;

/**
 * rsshubService业务层处理
 * 
 * @author superz
 * @date 2023-05-10
 */
@Service
public class TRsshubServiceImpl implements ITRsshubService 
{
    @Autowired
    private TRsshubMapper tRsshubMapper;

    /**
     * 查询rsshub
     * 
     * @param id rsshub主键
     * @return rsshub
     */
    @Override
    public TRsshub selectTRsshubById(Long id)
    {
        return tRsshubMapper.selectTRsshubById(id);
    }

    /**
     * 查询rsshub列表
     * 
     * @param tRsshub rsshub
     * @return rsshub
     */
    @Override
    public List<TRsshub> selectTRsshubList(TRsshub tRsshub)
    {
        return tRsshubMapper.selectTRsshubList(tRsshub);
    }

    /**
     * 新增rsshub
     * 
     * @param tRsshub rsshub
     * @return 结果
     */
    @Override
    public int insertTRsshub(TRsshub tRsshub)
    {
        return tRsshubMapper.insertTRsshub(tRsshub);
    }

    /**
     * 修改rsshub
     * 
     * @param tRsshub rsshub
     * @return 结果
     */
    @Override
    public int updateTRsshub(TRsshub tRsshub)
    {
        return tRsshubMapper.updateTRsshub(tRsshub);
    }

    /**
     * 批量删除rsshub
     * 
     * @param ids 需要删除的rsshub主键
     * @return 结果
     */
    @Override
    public int deleteTRsshubByIds(Long[] ids)
    {
        return tRsshubMapper.deleteTRsshubByIds(ids);
    }

    /**
     * 删除rsshub信息
     * 
     * @param id rsshub主键
     * @return 结果
     */
    @Override
    public int deleteTRsshubById(Long id)
    {
        return tRsshubMapper.deleteTRsshubById(id);
    }
}
