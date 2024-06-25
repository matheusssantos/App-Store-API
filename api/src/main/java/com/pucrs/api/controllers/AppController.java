package com.pucrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.api.models.App;
import com.pucrs.api.services.AppService;

@RestController
@RequestMapping("/apps")
public class AppController {
  
  @Autowired
  private AppService appService;

  @GetMapping("")
  public ResponseEntity<List<App>> findAll() {
    List<App> apps = this.appService.todos();
    return ResponseEntity.ok(apps);
  }
}
