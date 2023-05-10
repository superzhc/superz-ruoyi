package com.ruoyi.data.service;

import java.util.List;
import com.ruoyi.data.domain.TRsshub;

/**
 * rsshubService接口
 * 
 * @author superz
 * @date 2023-05-10
 */
public interface ITRsshubService 
{
    /**
     * 查询rsshub
     * 
     * @param id rsshub主键
     * @return rsshub
     */
    public TRsshub selectTRsshubById(Long id);

    /**
     * 查询rsshub列表
     * 
     * @param tRsshub rsshub
     * @return rsshub集合
     */
    public List<TRsshub> selectTRsshubList(TRsshub tRsshub);

    /**
     * 新增rsshub
     * 
     * @param tRsshub rsshub
     * @return 结果
     */
    public int insertTRsshub(TRsshub tRsshub);

    /**
     * 修改rsshub
     * 
     * @param tRsshub rsshub
     * @return 结果
     */
    public int updateTRsshub(TRsshub tRsshub);

    /**
     * 批量删除rsshub
     * 
     * @param ids 需要删除的rsshub主键集合
     * @return 结果
     */
    public int deleteTRsshubByIds(Long[] ids);

    /**
     * 删除rsshub信息
     * 
     * @param id rsshub主键
     * @return 结果
     */
    public int deleteTRsshubById(Long id);
}
