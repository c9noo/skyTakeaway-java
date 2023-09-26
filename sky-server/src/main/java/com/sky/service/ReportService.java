package com.sky.service;

import com.sky.vo.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 * @program: sky-take-out
 * @ClassName ReportService
 * @author: c9noo
 * @create: 2023-09-26 16:41
 * @Version 1.0
 **/
public interface ReportService {

    /**
     * 营业额统计接口
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getTurnoverStatistics(LocalDate begin,LocalDate end);

    /**
     * 用户统计接口
     * @param begin
     * @param end
     * @return
     */
    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    /**
     * 订单统计接口
     * @param begin
     * @param end
     * @return
     */
    OrderReportVO getOrdersStatistics(LocalDate begin, LocalDate end);

    /**
     * 效率前十统计
     * @param begin
     * @param end
     * @return
     */
    SalesTop10ReportVO getTopStatistics(LocalDate begin, LocalDate end);

    /**
     * 导出运营数据报表
     * @param httpServletResponse
     */
    void export(HttpServletResponse httpServletResponse);
}
