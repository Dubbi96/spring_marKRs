package pe.veriestate.asan.code.application.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.veriestate.asan.code.application.dto.CreateCodeRequest;
import pe.veriestate.asan.code.application.dto.ReadCodeResponse;
import pe.veriestate.asan.code.application.dto.UpdateCodeRequest;

import java.util.List;
@Service
public class Codeserviceddee implements CodeService{
    @Override
    public Long create(CreateCodeRequest request) {
        return null;
    }

    @Override
    public List<ReadCodeResponse> readPage(Pageable pageable) {
        return null;
    }

    @Override
    public ReadCodeResponse readById(Long codeGroupId) {
        return null;
    }

    @Override
    public ReadCodeResponse readByDisplayId(String codeGroupoDisplayId) {
        return null;
    }

    @Override
    public List<ReadCodeResponse> readByIdList(List<Long> codeGroupIdList) {
        return null;
    }

    @Override
    public List<ReadCodeResponse> readByDisplayIdList(List<String> codeGroupDisplayIdList) {
        return null;
    }

    @Override
    public Long update(String codeGroupDisplayId, UpdateCodeRequest request) {
        return null;
    }

    @Override
    public Boolean delete(String codeGroupDisplayId) {
        return null;
    }
}
