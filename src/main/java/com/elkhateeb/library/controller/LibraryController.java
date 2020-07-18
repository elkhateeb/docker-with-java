package com.elkhateeb.library.controller;
import com.elkhateeb.library.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/books")
@ResponseBody
public class LibraryController {
    private final RestService restService;

    @Autowired
    public LibraryController(RestService restService) {
        this.restService = restService;
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllBooks(){
        return ResponseEntity.ok(restService.getBooks());
    }


    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBookById(@PathVariable(value = "id") String id){
        Long Id = Long.parseLong(id);
        return ResponseEntity.ok(restService.getBookById(Id));
    }

}