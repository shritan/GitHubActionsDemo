package com.test.gson;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.annotations.SerializedName;
import com.test.objectmapper.LocalDateDeserializer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BallotRequestJSONData implements Serializable {

    private static final long serialVersionUID = 5271243285531804863L;

    private Integer ballotRequestId;

    // flag to hold Pilots decision if SEQ MOD is allowed
    private Integer allowSeqModificationInd;

    // Column to hold host details from where ballot request is updated
    private String serverName;

    private String ballotType;

    private String requestStatus;

    private Integer standingInd;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

    private String requestDetails;

    private Integer requestOrder;

    private Integer activeInd;

    private Integer updatedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate updatedDate;

    private Integer sequenceNumber;

    private String position;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate originationDate;

    @SerializedName(value = "unmatchedReason", alternate = { "unMatch_Reason" })
    private String unmatchedReason;

    private Boolean premiumRequest;

    private Boolean conflictIndicator;

    private Boolean greaterConflictIndicator;

    private String startDateFrom;

    private String startDateTo;

    private String endDateFrom;

    private String endDateTo;

    private Integer minLegsPerDP;

    private Integer minLegsPerSeq;

}
