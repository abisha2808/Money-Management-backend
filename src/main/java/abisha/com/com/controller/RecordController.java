package abisha.com.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abisha.com.com.entity.MoneyRecord;
import abisha.com.com.service.RecordService;

@RestController
@RequestMapping("/api/records")
@CrossOrigin(origins = "http://localhost:5173")
public class RecordController {


	    @Autowired
	    private RecordService recordService;

	    @PostMapping
	    public MoneyRecord create(@RequestBody MoneyRecord record) {
	        return recordService.createRecord(record);
	    }

	    @GetMapping
	    public List<MoneyRecord> getAll() {
	        return recordService.getAllRecords();
	    }

	    @GetMapping("/user/{createdBy}")
	    public List<MoneyRecord> getByUser(@PathVariable String createdBy) {
	        return recordService.getRecordsByUser(createdBy);
	    }
         
	    @PutMapping("/edit/{id}")
	    public MoneyRecord updateRecord(@PathVariable String id, @RequestBody MoneyRecord record) {
	        return recordService.updateRecord(id, record);
	    }
	   
	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable String id) {
	        recordService.deleteRecord(id);
	        return "Record deleted successfully";
	    }
	}



