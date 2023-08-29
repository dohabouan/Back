package Agile.demo.Service;


import Agile.demo.Entities.Release;
import Agile.demo.Repository.ReleaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService{
    private ReleaseRepository releaseRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Override
    public Release create(Release release) {
        return releaseRepository.save(release);
    }

    @Override
    public Release findById(Integer id) {
        return releaseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Release not found"));
    }

    @Override
    public void delete(Integer id) {
        Release release=releaseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Release not found"));
        releaseRepository.delete(release);

    }

    @Override
    public Release update(Integer id, Release updatedRelease) {
        Release release1=releaseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Release not found"));
        release1.setId(updatedRelease.getId());
        release1.setDate(updatedRelease.getDate());
        release1.setNotes(updatedRelease.getNotes());
        release1.setSprint(updatedRelease.getSprint());
        release1.setFeedbacks(updatedRelease.getFeedbacks());
        return releaseRepository.save(release1);
    }

    @Override
    public List<Release> findAll() {
        return releaseRepository.findAll();
    }
}
