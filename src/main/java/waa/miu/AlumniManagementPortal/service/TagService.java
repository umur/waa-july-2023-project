package waa.miu.AlumniManagementPortal.service;

import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.Tag;

import java.util.List;

@Service
public interface TagService {
    public List<Tag> getAllTags();
    public void deleteTag(Long id);
    public Tag getTagById(Long id);
    public Tag updateTag(Tag tag) ;
    public Tag createTag(Tag tag);

}
