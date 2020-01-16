package com.anubhav.mgtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anubhav.mgtc.entity.Speech;
import com.anubhav.mgtc.service.SpeechService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/speeches")
public class SpeechController {
	@Autowired SpeechService speechService;
	
	@RequestMapping(path="/addOrUpdate", method=RequestMethod.POST)
	public @ResponseBody JsonNode addSpeech(@RequestBody List<Speech> speech) {
		return speechService.addOrupdateSpeech(speech);
	}

	@RequestMapping(path="",method=RequestMethod.GET)
	public @ResponseBody JsonNode getSpeechByMeetingId(@RequestParam("meetingId")  String id) {
		return speechService.getSpeechByMeetingId(id);
	}


}
