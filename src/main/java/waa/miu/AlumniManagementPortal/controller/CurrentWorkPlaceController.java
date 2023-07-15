package waa.miu.AlumniManagementPortal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.miu.AlumniManagementPortal.entity.CurrentWorkPlace;
import waa.miu.AlumniManagementPortal.service.CurrentWorkPlaceService;

import java.util.List;

@RestController
@RequestMapping("/currentWorkPlace")
@RequiredArgsConstructor
@CrossOrigin
public class CurrentWorkPlaceController {

    private final CurrentWorkPlaceService currentWorkPlaceService;

    @GetMapping
    public List<CurrentWorkPlace> findAll(){
        return currentWorkPlaceService.findAll();
    }

    @GetMapping("/{id}")
    public CurrentWorkPlace findById(@PathVariable Long id){
        return currentWorkPlaceService.findById(id);
    }

    @PostMapping
    public CurrentWorkPlace create(@RequestBody CurrentWorkPlace currentWorkPlace){
        return currentWorkPlaceService.create(currentWorkPlace);
    }

    @PutMapping("/{id}")
    public CurrentWorkPlace update(@PathVariable Long id, @RequestBody CurrentWorkPlace currentWorkPlace) {
        return currentWorkPlaceService.update(id, currentWorkPlace);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        currentWorkPlaceService.delete(id);
    }
}
