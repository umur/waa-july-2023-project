package waa.miu.AlumniManagementPortal.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import waa.miu.AlumniManagementPortal.entity.Tag;
import waa.miu.AlumniManagementPortal.repository.TagRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{

    private final TagRepo tagRepo;

    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }

    public Tag createTag(Tag tag) {
        return tagRepo.save(tag);
    }

    public Tag getTagById(Long id) {
        return tagRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag with id "+id+" not found"));
    }

    public void deleteTag(Long id) {
        tagRepo.deleteById(id);
    }

    public Tag updateTag(Tag tag) {
        if (!tagRepo.existsById(tag.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag with id "+tag.getId()+" not found");
        }
        return tagRepo.save(tag);
    }
}
