package com.example.nameservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

    private NameMapper nameMapper;

    public  NameController(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    @GetMapping("/names")
    public ResponseEntity<List<Name>> findByNames(@RequestParam String startsWith) {
        if (StringUtils.isEmpty(startsWith)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        List<Name> names = nameMapper.findByNameStartingWith(startsWith);
        if (names.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(names);
    }
}
