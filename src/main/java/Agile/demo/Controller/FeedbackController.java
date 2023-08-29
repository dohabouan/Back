package Agile.demo.Controller;

import Agile.demo.Entities.Feedback;
import Agile.demo.Service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/feedbacks")
public class FeedbackController {
    private FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    @PostMapping("")
    public Feedback create(@RequestBody() Feedback feedback) {
        return feedbackService.create(feedback);
    }
    @GetMapping(path="{id}")
    public Feedback findById(@PathVariable Integer id) {
        return feedbackService.findById(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void delete(@PathVariable Integer id) {
        feedbackService.delete(id);
    }
    @PutMapping(path="/update/{id}")
    public Feedback update(@PathVariable Integer id,@RequestBody Feedback updatedFeedback) {
        return feedbackService.update(id, updatedFeedback);
    }
    @GetMapping("/all")
    public List<Feedback> findAll() {
        return feedbackService.findAll();
    }
}
