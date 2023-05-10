package com.ruoyi.data.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.data.domain.TRsshub;
import com.ruoyi.data.service.ITRsshubService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * rsshubController
 * 
 * @author superz
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/data/rsshub")
public class TRsshubController extends BaseController
{
    @Autowired
    private ITRsshubService tRsshubService;

    /**
     * 查询rsshub列表
     */
    @PreAuthorize("@ss.hasPermi('data:rsshub:list')")
    @GetMapping("/list")
    public TableDataInfo list(TRsshub tRsshub)
    {
        startPage();
        List<TRsshub> list = tRsshubService.selectTRsshubList(tRsshub);
        return getDataTable(list);
    }

    /**
     * 导出rsshub列表
     */
    @PreAuthorize("@ss.hasPermi('data:rsshub:export')")
    @Log(title = "rsshub", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TRsshub tRsshub)
    {
        List<TRsshub> list = tRsshubService.selectTRsshubList(tRsshub);
        ExcelUtil<TRsshub> util = new ExcelUtil<TRsshub>(TRsshub.class);
        util.exportExcel(response, list, "rsshub数据");
    }

    /**
     * 获取rsshub详细信息
     */
    @PreAuthorize("@ss.hasPermi('data:rsshub:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tRsshubService.selectTRsshubById(id));
    }

    /**
     * 新增rsshub
     */
    @PreAuthorize("@ss.hasPermi('data:rsshub:add')")
    @Log(title = "rsshub", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TRsshub tRsshub)
    {
        return toAjax(tRsshubService.insertTRsshub(tRsshub));
    }

    /**
     * 修改rsshub
     */
    @PreAuthorize("@ss.hasPermi('data:rsshub:edit')")
    @Log(title = "rsshub", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TRsshub tRsshub)
    {
        return toAjax(tRsshubService.updateTRsshub(tRsshub));
    }

    /**
     * 删除rsshub
     */
    @PreAuthorize("@ss.hasPermi('data:rsshub:remove')")
    @Log(title = "rsshub", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tRsshubService.deleteTRsshubByIds(ids));
    }
}
