package com.office.portal.employee.infra.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class FetchEmployeeApplyLeavePendingStatusResponseArray implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty(value = "fetchPendingStatusResponseList")
	private List<fetchPendingStatusResponseList> pendingStatusResponses;

    // Getters and setters
    public List<fetchPendingStatusResponseList> getPendingStatusResponses() {
        return pendingStatusResponses;
    }

    public void setPendingStatusResponses(List<fetchPendingStatusResponseList> pendingStatusResponses) {
        this.pendingStatusResponses = pendingStatusResponses;
    }
}
