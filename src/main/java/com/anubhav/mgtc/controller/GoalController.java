package com.anubhav.mgtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anubhav.mgtc.entity.Goal;
import com.anubhav.mgtc.service.GoalService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/goals")
public class GoalController {
	
	@Autowired GoalService goalService;
	@RequestMapping(path="/addOrUpdate", method=RequestMethod.POST)
	public @ResponseBody JsonNode addGoal(@RequestBody List<Goal> goals) {
		return goalService.addorUpdateGoal(goals);
	}

	@RequestMapping(path="", method=RequestMethod.GET)
	public @ResponseBody JsonNode getGoalByMeetingId(@RequestParam("meetingId") String id) {
		return goalService.getGoalByMeetingId(id);
	}

}
