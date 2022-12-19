package com.vodafone.garageassessment.api;

import com.vodafone.garageassessment.Request.RequestPark;
import com.vodafone.garageassessment.Response.ResponsePark;
import com.vodafone.garageassessment.service.IGarageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("garage")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GarageController {
    IGarageService garageService;

    @PostMapping("/park")
    public ResponseEntity<ResponsePark> createPark(@RequestBody RequestPark request){
        return ResponseEntity.ok(garageService.createPark(request));
    }
    @DeleteMapping("/{ticketId}")
    public ResponseEntity<String> leavePark(@PathVariable String ticketId){
        return ResponseEntity.ok(garageService.leavePark(ticketId));
    }
    @GetMapping("/status")
    public ResponseEntity<ArrayList<ResponsePark>> getStatus(){
        return ResponseEntity.ok(garageService.getStatus());
    }

    @GetMapping("/test")
    public ResponseEntity<Void> testForLogs(){
        garageService.testForLogs();
        return new ResponseEntity(HttpStatus.OK);
    }

}
