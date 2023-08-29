package Agile.demo.Service;

import Agile.demo.Entities.Backlog;
import Agile.demo.Entities.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback create (Feedback feedback);
    Feedback findById(Integer id);
    void delete(Integer id);
    Feedback update( Integer id,Feedback updatedFeedback);
    List<Feedback> findAll();
}
