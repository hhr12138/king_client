package common.storage.king.service;

import common.storage.king.entity.User;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haoran hou
 * @since 2022-09-19
 */
@FeignClient(url = "${common.storage.king:127.0.0.1:8888}")
public interface UserClient {

}
