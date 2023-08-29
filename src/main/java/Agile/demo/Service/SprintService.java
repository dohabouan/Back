package Agile.demo.Service;

import Agile.demo.Entities.Sprint;

import java.util.List;

public interface SprintService {
    Sprint create(Sprint sprint);
    Sprint findById(Integer id);
    void delete(Integer id);
    Sprint update(Integer id,Sprint updatedSprint);
    List<Sprint> findAll();
}
