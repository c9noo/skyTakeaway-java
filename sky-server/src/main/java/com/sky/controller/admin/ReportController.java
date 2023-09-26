package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ReportService;
import com.sky.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @program: sky-take-out
 * @ClassName ReportService
 * @author: c9noo
 * @create: 2023-09-26 16:38
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin/report")
@Slf4j
@Api(tags = "数据统计相关接口")
public class ReportController {

    @Autowired
    private ReportService reportService;


    /**
     * 营业额统计接口
     * @param begin
     * @param end
     * @return
     */
    @GetMapping("/turnoverStatistics")
    @ApiOperation("营业额统计接口")
    public Result<TurnoverReportVO> turnoverStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end
            ){
        log.info("营业额要统计的时间范围为{}{}",begin,end);
        return Result.success(reportService.getTurnoverStatistics(begin,end));
    }

    /**
     * 用户统计接口
     * @return
     */
    @GetMapping("/userStatistics")
    @ApiOperation("用户统计接口")
    public Result<UserReportVO> userReport(
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end
    ){
        log.info("用户要统计的时间范围为{}{}",begin,end);
        return Result.success(reportService.getUserStatistics(begin,end));
    }


    /**
     * 订单统计接口
     * @return
     */
    @GetMapping("/ordersStatistics")
    @ApiOperation("订单统计接口")
    public Result<OrderReportVO> ordersStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end
    ){
        log.info("订单要统计的时间范围为{}{}",begin,end);
        return Result.success(reportService.getOrdersStatistics(begin,end));
    }

    /**
     * top统计接口
     * @return
     */
    @GetMapping("/top10")
    @ApiOperation("top10统计接口")
    public Result<SalesTop10ReportVO> top(
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end
    ){
        log.info("订单要统计的时间范围为{}{}",begin,end);
        return Result.success(reportService.getTopStatistics(begin,end));
    }

}
