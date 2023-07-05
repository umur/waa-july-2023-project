package waa.miu.AlumniManagementPortal.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.Tag;
import waa.miu.AlumniManagementPortal.repository.TagRepo;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{

    public TagRepo tagRepo;

    @Autowired
    public TagServiceImpl(TagRepo tagRepo){
        this.tagRepo=tagRepo;

    }

    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }

    public Tag createTag(Tag tag) {
        return tagRepo.save(tag);
    }

    public Tag getTagById(Long id) {
        return tagRepo.findById(id).orElse(null);
    }

    public void deleteTag(Long id) {
        tagRepo.deleteById(id);
    }

    public Tag updateTag(Tag tag) {
        if (!tagRepo.existsById(tag.getId())) {
            throw new EntityNotFoundException("Tag not found with id: " + tag.getId());
        }
        return tagRepo.save(tag);
    }
}
