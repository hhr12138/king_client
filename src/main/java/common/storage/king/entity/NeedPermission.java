package common.storage.king.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@NoArgsConstructor
@ToString
public class NeedPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private String psm;

    /**
     * 方法签名或数据名
     */
    private String methorOrData;

    private Long companyId;

    private Long departmentId;

    private Boolean del;

    private Long gmtCreate;

    private Long gmtModified;

    public NeedPermission(String psm, String methorOrData, Long companyId, Long departmentId) {
        this.psm = psm;
        this.methorOrData = methorOrData;
        this.companyId = companyId;
        this.departmentId = departmentId;
    }
}
