
package com.test.objectmapper;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mohan Rao
 *
 *         This class is used to populate DfpConflictInfo Details from RA Service Response
 */
@Setter
@Getter
@EqualsAndHashCode
public class DfpConflictInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String dfpType;

    @JsonSerialize(using = LocalDateTimeISOSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeSerializer.class)
    private LocalDateTime dfpstartDateTime;

    @JsonSerialize(using = LocalDateTimeISOSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeSerializer.class)
    private LocalDateTime dfpendDateTime;

    @JsonSerialize(using = LocalDateTimeISOSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeSerializer.class)
    private LocalDateTime nextReservedayAvbldate;

}
