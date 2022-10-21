package common.storage.king.service;

import common.entity.valhalla.vo.RestResponse;
import common.storage.king.entity.NeedPermission;
import common.storage.king.entity.Permission;
import common.storage.king.entity.Role;
import common.storage.king.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(url = "${common.storage.king:127.0.0.1:8888}",name = "themisClient")
public interface ThemisClient {
    @PostMapping("/getNeedPermission")
    RestResponse<List<Permission>> getPermissions(@RequestBody NeedPermission needPermission);
    @PostMapping("/getUserPermission")
    RestResponse<List<Permission>> getUserPermissions(@RequestBody  User user);

    @PostMapping("/insert/needPermission")
    RestResponse<Long> insertNeedPermission(@RequestBody NeedPermission needPermission);
    @PostMapping("/insert/Role")
    RestResponse<Long> insertRole(@RequestBody Role role);
    @PostMapping("/insert/permission")
    RestResponse<Long> insertPermission(@RequestBody Permission permission);

    @GetMapping("/select/permissionByDepartment")
    RestResponse<Permission> selectPermissionByDepartment(@RequestParam Long departmentId);

    @GetMapping("/select/permissionByUser")
    RestResponse<Permission> selectPermissionByUser(@RequestParam Long userId);
    @GetMapping("/select/permissionByCompany")
    RestResponse<Permission> selectPermissionByCompany(@RequestParam Long companyId);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @return 添加成功个数
     */
    @PostMapping("/add/rolesToUser")
    RestResponse<Long> addRolesToUser(@RequestParam Long userId,@RequestParam List<Long> roleIds);

    /**
     * 给公司添加基础角色
     * @param companyId
     * @param roleIds
     * @return
     */
    @PostMapping("/add/rolesToCompany")
    RestResponse<Long> addRolesToCompany(@RequestParam Long companyId,@RequestParam List<Long> roleIds);

    /**
     * 给部门添加基础角色
     * @param departmentId
     * @param roleIds
     * @return
     */
    @PostMapping("/add/rolesToDepartment")
    RestResponse<Long> addRolesToDepartment(@RequestParam Long departmentId,@RequestParam List<Long> roleIds);
    /**
     * 给角色添加权限
     * @return 添加成功个数
     */
    @PostMapping("/add/permissionToRole")
    RestResponse<Long> addPermissionToRole(@RequestParam Long roleId,@RequestParam List<Long> permissionIds);

    /**
     * 给用户添加权限
     * @param userId
     * @param permissionIds
     * @return
     */
    @PostMapping("/add/permissionToUser")
    RestResponse<Long> addPermissionToUser(@RequestParam Long userId,@RequestParam List<Long> permissionIds);

    /**
     * 给权限需要对象添加所需权限
     * @param needPermission
     * @param permissions
     * @return
     */
    @PostMapping("/add/permissionToNeedPermission")
    RestResponse<Long> addPermissionToNeedPermission(@RequestParam Long needPermission,@RequestParam List<Long> permissions);
}
