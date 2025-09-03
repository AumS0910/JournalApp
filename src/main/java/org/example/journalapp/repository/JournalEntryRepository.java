package org.example.journalapp.repository;

import org.bson.types.ObjectId;
import org.example.journalapp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
}
