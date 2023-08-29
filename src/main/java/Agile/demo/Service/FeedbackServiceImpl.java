package Agile.demo.Service;

import Agile.demo.Entities.Feedback;
import Agile.demo.Repository.FeedbackRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    private FeedbackRepository feedbackRepository;
    private Feedback u;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback findById(Integer id) {
        return feedbackRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Feedback not found"));
    }

    @Override
    public void delete(Integer id) {
        Feedback feedback=feedbackRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Feedback not found"));
        feedbackRepository.delete(feedback);

    }

    @Override
    public Feedback update(Integer id, Feedback updatedFeedback) {
        Feedback feedback1=feedbackRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Feedback not found"));
        feedback1.setId(updatedFeedback.getId());
        feedback1.setDate(updatedFeedback.getDate());
        feedback1.setDescription(updatedFeedback.getDescription());
        feedback1.setAuthor(updatedFeedback.getAuthor());
        feedback1.setReleases(updatedFeedback.getReleases());
        return feedbackRepository.save(feedback1);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }
}
