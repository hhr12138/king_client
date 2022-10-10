package common.storage.king.service;

import common.entity.valhalla.vo.RestResponse;
import common.storage.king.entity.Permission;
import common.storage.king.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haoran hou
 * @since 2022-09-19
 */
@FeignClient(url = "${common.storage.king:127.0.0.1:8888}",name = "userClient")
public interface UserClient {
    @GetMapping("/getUserPermission")
    RestResponse<List<Permission>> getUserPermissions(@RequestBody User user);
}
