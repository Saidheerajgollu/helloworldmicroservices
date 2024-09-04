package com.world.world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class worldcontroller {
    @GetMapping("/world")
    public String worldcontroller() {
        return "world" ;
    }
    

}
