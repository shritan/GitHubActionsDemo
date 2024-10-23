package com.test.example;

public enum CrewMemberGets {
    ALL("ALL"), SEQUENCE_DETAILS("SEQUENCE_DETAILS"), ABSENCE_DETAILS("ABSENCE_DETAILS"), RAP_DETAILS("RAP_DETAILS"), DFP_DETAILS(
            "DFP_DETAILS"), BID_STATUS("BID_STATUS"), PERSONAL_INFO("PERSONAL_INFO"), LANG_QUALS(
                    "LANG_QUALS"), SERVICE_QUALS("SERVICE_QUALS"), EQP_QUALS(
                            "EQP_QUALS"), DUTY_STATUS("DUTY_STATUS"), OBLIGATION_ACTIVITIES(
                                    "OBLIGATION_ACTIVITIES"), PROTECTED_SEQUENCES(
                                            "PROTECTED_SEQUENCES"), COCKPIT_QUALIFICATION("COCKPIT_QUALIFICATION"), SICK_TIME("SICK_TIME");

    private final String value;

    public String value() {
        return value;
    }

    CrewMemberGets(final String value) {
        this.value = value;
    }
}
