package Agile.demo.Service;

import Agile.demo.Entities.Backlog;

import Agile.demo.Entities.Release;


import java.util.List;

public interface ReleaseService {
    Release create (Release release);
    Release findById(Integer id);
    void delete(Integer id);
    Release update( Integer id,Release updatedRelease);
    List<Release> findAll();
}
