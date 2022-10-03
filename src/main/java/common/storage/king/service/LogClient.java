package common.storage.king.service;

import common.entity.valhalla.annotation.SerializerTypeRepair;
import common.entity.valhalla.vo.RestResponse;
import common.storage.king.entity.Log;
import org.springframework.cloud.openfeign.FeignClient;

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
public interface LogService{
    RestResponse<Integer> insertLogStrs(String logsStr);
    //物理删除X天前的日志
    RestResponse<Integer> realDeleteLogsGeneratedXDayAgo(int x);
    //根据requestId查询指定时间范围内的日志, 不传时间意味着无限制
    RestResponse<List<Log>> selectLogsByRequestId(String requestId, long startTime, long endTime);
    //查询X分钟内的日志
    RestResponse<List<Log>> selectLogsGeneratedXMin(int x);
    //根据UserId查询指定时间范围内的日志, 不传时间无限制
    RestResponse<List<Log>> selectLogsByUserId(Long userId, long startTime, long endTime, int pageCnt, int size);
}
