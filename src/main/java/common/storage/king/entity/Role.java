package common.storage.king.entity;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long companyId;

    private Long departmentId;

    private String roleName;

}
