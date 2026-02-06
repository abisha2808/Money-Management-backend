package abisha.com.com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abisha.com.com.entity.Action;
import abisha.com.com.repository.ActionRepository;

@Service
public class ActionService {
	
	@Autowired
    private ActionRepository actionRepository;

    
    public Action createAction(Action action) {
        action.setActionDate(LocalDateTime.now());
        return actionRepository.save(action);
    }

    
    public List<Action> getActionsByRecordId(String recordId) {
        return actionRepository.findByRecordId(recordId);
    }

    
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

}
