package com.vodafone.garageassessment.service;

import com.vodafone.garageassessment.Request.RequestPark;
import com.vodafone.garageassessment.Response.ResponsePark;

import java.util.ArrayList;

public interface IGarageService {
    ResponsePark createPark(RequestPark request);
    String leavePark(String ticketId);
    ArrayList<ResponsePark> getStatus();
    void testForLogs();
}
