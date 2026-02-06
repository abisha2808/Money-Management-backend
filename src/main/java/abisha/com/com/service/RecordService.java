package abisha.com.com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abisha.com.com.repository.RecordRepository;

import abisha.com.com.entity.MoneyRecord;

@Service
public class RecordService {
         
	@Autowired
    private RecordRepository recordRepository;

    // CREATE
    public MoneyRecord createRecord(MoneyRecord record) {
        record.setCreatedAt(LocalDateTime.now());
        record.setUpdatedAt(LocalDateTime.now());
        return recordRepository.save(record);
    }

    // GET ALL
    public List<MoneyRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    // GET BY USER
    public List<MoneyRecord> getRecordsByUser(String createdBy) {
        return recordRepository.findByCreatedBy(createdBy);
    }

    public MoneyRecord updateRecord(String id, MoneyRecord updated) {
        MoneyRecord existing = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        existing.setType(updated.getType());
        existing.setDescription(updated.getDescription());
        existing.setCategory(updated.getCategory());
        existing.setDivision(updated.getDivision());
        existing.setAmount(updated.getAmount());
        existing.setUpdatedAt(LocalDateTime.now());
        return recordRepository.save(existing);
    }

    // DELETE
    public void deleteRecord(String id) {
        recordRepository.deleteById(id);
    }
}
