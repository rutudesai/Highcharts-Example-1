package com.rutu.example.graphshighchartsexample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rutu.example.graphshighchartsexample.entity.Grades;
import com.rutu.example.graphshighchartsexample.repository.GradesRepository;

@Controller
public class GraphController {
	@Autowired 
	private GradesRepository gradesRepository;
	
	
	@ResponseBody
	@RequestMapping(path="/get-data")
    /*public String getAllGrades() {
		List<Grades> gradesList=gradesRepository.findAll();
		JsonArray jsonSem=new JsonArray();
		JsonArray jsonGpa=new JsonArray();
		JsonObject json=new JsonObject();
		gradesList.forEach(data->{
			jsonSem.add(data.getSem());
			jsonGpa.add(data.getGpa());
		});
		json.add("sem",jsonSem);
		json.add("gpa",jsonGpa);
		return json.toString();
	}*/
	public ResponseEntity<?> getDataForMultipleLine(){
		Map<String, List<Grades>> mappedData=new HashMap<>();
		List<Grades> gradesList= gradesRepository.findAll();
		for(Grades data: gradesList) {
			
			if(mappedData.containsKey(data.getName())) {
				mappedData.get(data.getName()).add(data);
			}else {
				List<Grades> tempList = new ArrayList<>();
				tempList.add(data);
				mappedData.put(data.getName(), tempList);
			}	
		}
		return new ResponseEntity<>(mappedData, HttpStatus.OK);
	}
}
	
	
	
	
	
