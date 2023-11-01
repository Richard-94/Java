package com.tesifacile.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tesifacile.project.model.RicieveMessage;
import com.tesifacile.project.service.TesiService;


@RestController
@RequestMapping("/api/tesi")
public class TesiController {

    @Autowired
    TesiService tesiServ;

    @GetMapping("/all/messages")
	@CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<List<RicieveMessage>> getMessages() {
        List<RicieveMessage> messages = tesiServ.getAllMessages();
        ResponseEntity<List<RicieveMessage>> mess = new ResponseEntity<>(messages, HttpStatus.OK);
        return mess;
    }
    
    @PostMapping("/all/create")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<?> createWorker(@RequestBody RicieveMessage recieveMe){
    	RicieveMessage ws = tesiServ.saveMessage(recieveMe);
		return new ResponseEntity<RicieveMessage>(ws, HttpStatus.CREATED);

	}
    
    
//    @GetMapping("/all/getallmessages")
//    public ResponseEntity<List<RicieveMessage>> getAllMessages(){
//		List<RicieveMessage> users = tesiServ.messagesToShow();
//		ResponseEntity<List<RicieveMessage>>u = new ResponseEntity <List<RicieveMessage>>(users, HttpStatus.OK);
//		return u;
//	}
}
