package common.storage.king.entity;

import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author haoran hou
 * @since 2022-09-19
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String requestId;

    private String PSM;

    private String level;

    private String context;

    private Boolean del;

    private Long gmtCreate;

    private Long gmtModified;

    public Log(Long userId, String requestId, String PSM, String level, String context) {
        this.userId = userId;
        this.requestId = requestId;
        this.PSM = PSM;
        this.level = level;
        this.context = context;
    }
}
