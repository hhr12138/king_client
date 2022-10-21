package common.storage.king.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author haoran hou
 * @since 2022-10-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long companyId;

    private Long departmentId;

    private String permission;

    private Boolean del;

    private Long gmtCreate;

    private Long gmtModified;


}
