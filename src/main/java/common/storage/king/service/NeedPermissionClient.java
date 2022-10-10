package common.storage.king.service;

import common.entity.valhalla.vo.RestResponse;
import common.storage.king.entity.NeedPermission;
import common.storage.king.entity.Permission;
import common.storage.king.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface NeedPermissionClient {
    @GetMapping("/getNeedPermission")
    RestResponse<List<Permission>> getPermissions(@RequestBody NeedPermission needPermission);
    @GetMapping("/getUserPermission")
    RestResponse<List<Permission>> getUserPermissions(@RequestBody  User user);
}
