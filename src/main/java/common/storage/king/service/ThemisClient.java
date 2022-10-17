package common.storage.king.service;

import common.entity.valhalla.vo.RestResponse;
import common.storage.king.entity.NeedPermission;
import common.storage.king.entity.Permission;
import common.storage.king.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(url = "${common.storage.king:127.0.0.1:8888}",name = "needPermissionClient")
public interface NeedPermissionClient {
    @PostMapping("/getNeedPermission")
    RestResponse<List<Permission>> getPermissions(@RequestBody NeedPermission needPermission);
    @PostMapping("/getUserPermission")
    RestResponse<List<Permission>> getUserPermissions(@RequestBody  User user);
}
