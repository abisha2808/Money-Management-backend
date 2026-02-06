package abisha.com.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abisha.com.com.entity.Action;
import abisha.com.com.service.ActionService;

@RestController
@RequestMapping("/api/actions")
@CrossOrigin(origins = "*")
public class ActionController {
	
	 @Autowired
	    private ActionService actionService;

	   
	    @PostMapping
	    public Action createAction(@RequestBody Action action) {
	        return actionService.createAction(action);
	    }

	  
	    @GetMapping("/record/{recordId}")
	    public List<Action> getActionsByRecordId(@PathVariable String recordId) {
	        return actionService.getActionsByRecordId(recordId);
	    }

	    
	    @GetMapping
	    public List<Action> getAllActions() {
	        return actionService.getAllActions();
	    }

}
