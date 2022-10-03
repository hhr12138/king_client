package common.storage.king.service;

import common.entity.valhalla.annotation.SerializerTypeRepair;
import common.entity.valhalla.vo.RestResponse;
import common.storage.king.entity.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haoran hou
 * @since 2022-09-19
 */
@FeignClient(url = "${common.storage.king:127.0.0.1:8888}")
public interface LogClient{

    @PostMapping("/insertLogsStr")
    RestResponse<Integer> insertLogsStr(@RequestParam("logsStr") String logsStr);

    @PostMapping("/insertLogs")
    RestResponse<Integer> insertLogs(@RequestBody List<Log> logs);

    //物理删除X天前的日志
    @PostMapping("/realDeleteLogsGeneratedXDayAgo")
    RestResponse<Integer> realDeleteLogsGeneratedXDayAgo(@RequestParam("x") int x);

    //根据requestId查询指定时间范围内的日志, 不传时间意味着无限制
    @GetMapping("/selectLogsByRequestId/{requestId}/{startTime}/{endTime}")
    RestResponse<List<Log>> selectLogsByRequestId(@PathVariable("requestId") String requestId, @PathVariable("startTime") long startTime, @PathVariable("endTime") long endTime);

    //查询X分钟内的日志
    @GetMapping("/selectLogsGeneratedXMin/{x}")
    RestResponse<List<Log>> selectLogsGeneratedXMin(@PathVariable("x") int x);

    //根据UserId查询指定时间范围内的日志, 不传时间无限制
    @GetMapping("selectLogsByUserId/{userId}/{startTime}/{endTime}/{pageCnt}/{size}")
    RestResponse<List<Log>> selectLogsByUserId(@PathVariable("userId") Long userId,@PathVariable("startTime") long startTime,@PathVariable("endTime") long endTime,@PathVariable(value = "pageCnt",required = false) int pageCnt,@PathVariable(value = "size",required = false) int size);
}
