package lk.ijse.aad.gdse68.notetaker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/note/health")
public class HealthTestController {
    @GetMapping
    public String healthCheck(){
        return "note taker is running";
    }
}
