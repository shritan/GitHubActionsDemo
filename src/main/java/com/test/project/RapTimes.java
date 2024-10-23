package com.test.project;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RapTimes implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer rapTimesId;

    private Integer rapHours;

    private Integer rapMinutes;

    private Integer rapDuration;

    private Integer sortOrder;

    private Integer activeInd;

}
