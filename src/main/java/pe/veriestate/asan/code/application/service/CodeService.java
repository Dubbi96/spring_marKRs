package pe.veriestate.asan.code.application.service;

import org.springframework.data.domain.Pageable;
import pe.veriestate.asan.code.application.dto.CreateCodeRequest;
import pe.veriestate.asan.code.application.dto.ReadCodeResponse;
import pe.veriestate.asan.code.application.dto.UpdateCodeRequest;

import java.util.List;

public interface CodeService {
    public Long create(CreateCodeRequest request);
    public List<ReadCodeResponse> readPage(Pageable pageable);
    public ReadCodeResponse readById(Long codeGroupId);
    public ReadCodeResponse readByDisplayId(String codeGroupoDisplayId);
    public List<ReadCodeResponse> readByIdList(List<Long> codeGroupIdList);
    public List<ReadCodeResponse> readByDisplayIdList(List<String> codeGroupDisplayIdList);
    public Long update(String codeGroupDisplayId, UpdateCodeRequest request);
    public Boolean delete(String codeGroupDisplayId);
}
