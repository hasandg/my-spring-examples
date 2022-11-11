package com.hasandag;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "My Pet API Doc")
public class PetController {

    private List<Pet>  petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        petList.add(new Pet(1, "Test Pet", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "New pet adding method")
    public ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "animal") Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Pet listing method")
    public ResponseEntity<List<Pet>> listAll() {
        return ResponseEntity.ok(petList);
    }
}
