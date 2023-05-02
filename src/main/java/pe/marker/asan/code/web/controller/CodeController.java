package pe.marker.asan.code.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.marker.asan.code.application.dto.CreateCodeRequest;
import pe.marker.asan.code.application.dto.ReadCodeResponse;
import pe.marker.asan.code.application.dto.UpdateCodeRequest;
import pe.marker.asan.code.application.service.CodeService;

import java.util.List;

@RestController
@RequestMapping("/code")
@RequiredArgsConstructor
public class CodeController {
    private final CodeService codeService;

    @PostMapping
    public Long create(@RequestBody CreateCodeRequest createCodeRequest) {
        return codeService.create(createCodeRequest);
    }

    @GetMapping
    public List<ReadCodeResponse> readPage(Pageable page) {
        return codeService.readPage(page);
    }

    @GetMapping("/{codeGroupDisplayId}")
    public ReadCodeResponse readByDisplayId(@PathVariable("codeGroupDisplayId") String codeGroupDisplayId) {
        return codeService.readByDisplayId(codeGroupDisplayId);
    }

    @GetMapping("/his/{codeGroupId}")
    public ReadCodeResponse readById(@PathVariable("codeGroupId") Long codeGroupId) {
        return codeService.readById(codeGroupId);
    }

    @PutMapping("/{codeGroupDisplayId}")
    public Long updateByDisplayId(@RequestBody UpdateCodeRequest updateCodeRequest, @PathVariable("codeGroupDisplayId") String codeGroupDisplayId) {
        return codeService.update(codeGroupDisplayId, updateCodeRequest);
    }

    @DeleteMapping("/{codeGroupDisplayId}")
    public Boolean deleteByDisplayId(@PathVariable("codeGroupDisplayId") String codeGroupDisplayId) {
        return codeService.delete(codeGroupDisplayId);
    }
}
