package com.test.objectmapper;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateManualNotificationsRequest {

    private List<ManualNotifications> manualNotifications;

}
