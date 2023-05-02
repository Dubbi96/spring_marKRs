/*
package pe.marker.asan.code.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pe.marker.asan.code.application.dto.CreateCodeRequest;
import pe.marker.asan.code.application.dto.ReadCodeResponse;
import pe.marker.asan.code.application.dto.UpdateCodeRequest;
import pe.marker.asan.code.domain.entity.CodeGroupJpaEntity;
import pe.marker.asan.code.domain.entity.CodeJpaEntity;
import pe.marker.asan.code.domain.repository.CodeGroupJpaRepository;
import pe.marker.asan.code.domain.repository.CodeGroupQueryRepository;
import pe.marker.asan.code.domain.repository.CodeJpaRepository;
import pe.marker.asan.code.domain.repository.CodeQueryRepository;
import java.util.Comparator;
import java.util.List;

import static pe.marker.asan.code.application.dto.ReadCodeResponse.*;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CodeServiceImpl implements CodeService {

    private final CodeJpaRepository codeJpaRepository;
    private final CodeQueryRepository codeQueryRepository;
    private final CodeGroupJpaRepository codeGroupJpaRepository;
    private final CodeGroupQueryRepository codeGroupQueryRepository;

    @Override
    @Transactional(readOnly = false)
    public Long create(CreateCodeRequest request) {
        Assert.isNull(
            codeGroupQueryRepository.findByDisplayId(request.codeGroup.displayId),
            "Duplicated DISPLAY_ID of the code group"
        );
        CodeGroupJpaEntity codeGroup = CodeGroupJpaEntity.of(
            request.codeGroup.displayId,
            request.codeGroup.name,
            request.codeGroup.description
        );
        codeGroup = codeGroupJpaRepository.save(codeGroup);

        for(int index = 0; index < request.codeList.size(); index ++) {
            CreateCodeRequest.CreateCode requestCode = request.codeList.get(index);
            Assert.isNull(
                codeQueryRepository.findByDisplayId(requestCode.displayId),
                "Duplicated DISPLAY_ID of the code"
            );
            CodeJpaEntity code = CodeJpaEntity.of(
                codeGroup,
                index,
                requestCode.displayId,
                requestCode.name,
                requestCode.description
            );
            code = codeJpaRepository.save(code);
        }
        
        return codeGroup.getId();
    }

    @Override
    public List<ReadCodeResponse> readPage(Pageable page) {
        return codeGroupQueryRepository.findPage(page).stream()
            .map(codeGroup -> {
                ReadCodeResponse response = new ReadCodeResponse();
    
                response.codeGroup = new ReadCodeGroup();
                response.codeGroup.id = codeGroup.getId();
                response.codeGroup.displayId = codeGroup.getDisplayId();
                response.codeGroup.name = codeGroup.getName();
                response.codeGroup.description = codeGroup.getDescription();
    
                response.codeList = codeQueryRepository.findAllByCodeGroup(codeGroup).stream()
                    .sorted(Comparator.comparing(CodeJpaEntity::getPosition))
                    .map(code -> {
                        ReadCode codeResponse = new ReadCode();
                        codeResponse.id = code.getId();
                        codeResponse.displayId = code.getDisplayId();
                        codeResponse.name = code.getName();
                        codeResponse.description = code.getDescription();
    
                        return codeResponse;
                    }).toList();
                
                return response;
            }).toList();
    }

    @Override
    public ReadCodeResponse readById(Long codeGroupId) {
        CodeGroupJpaEntity codeGroup = codeGroupJpaRepository.findById(codeGroupId)
            .orElseThrow(() -> new IllegalArgumentException("Not found"));
        List<CodeJpaEntity> codeList = codeQueryRepository.findAllByCodeGroup(codeGroup);

        ReadCodeResponse response = new ReadCodeResponse();

        response.codeGroup = new ReadCodeGroup();
        response.codeGroup.id = codeGroup.getId();
        response.codeGroup.displayId = codeGroup.getDisplayId();
        response.codeGroup.name = codeGroup.getName();
        response.codeGroup.description = codeGroup.getDescription();
        
        response.codeList = codeList.stream()
            .map(code -> {
                ReadCode codeResponse = new ReadCode();
                codeResponse.id = code.getId();
                codeResponse.displayId = code.getDisplayId();
                codeResponse.name = code.getName();
                codeResponse.description = code.getDescription();

                return codeResponse;
            }).toList();

        return response;
    }

    @Override
    public ReadCodeResponse readByDisplayId(String codeGroupDisplayId) {
        CodeGroupJpaEntity codeGroup = codeGroupQueryRepository.findByDisplayId(codeGroupDisplayId);
        Assert.notNull(codeGroup, "Code group with DISPLAY_ID not found");

        List<CodeJpaEntity> codeList = codeQueryRepository.findAllByCodeGroup(codeGroup);

        ReadCodeResponse response = new ReadCodeResponse();
        response.codeGroup = new ReadCodeGroup();
        response.codeGroup.id = codeGroup.getId();
        response.codeGroup.displayId = codeGroup.getDisplayId();
        response.codeGroup.name = codeGroup.getName();
        response.codeGroup.description = codeGroup.getDescription();

        response.codeList = codeList.stream()
            .map(code -> {
                ReadCode codeResponse = new ReadCode();
                codeResponse.id = code.getId();
                codeResponse.displayId = code.getDisplayId();
                codeResponse.name = code.getName();
                codeResponse.description = code.getDescription();

                return codeResponse;
            }).toList();

        return response;
    }

    @Override
    public List<ReadCodeResponse> readByIdList(List<Long> groupIdList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByIdList'");
    }

    @Override
    public List<ReadCodeResponse> readByDisplayIdList(List<String> groupDisplayIdList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readByDisplayIdList'");
    }

    @Override
    @Transactional(readOnly = false)
    public Long update(String codeGroupDisplayId, UpdateCodeRequest request) {
        this.delete(codeGroupDisplayId);

        CreateCodeRequest convertedRequest = new CreateCodeRequest();
        convertedRequest.codeGroup = new CreateCodeRequest.CreateCodeGroup();
        convertedRequest.codeGroup.displayId = codeGroupDisplayId;
        convertedRequest.codeGroup.name = request.codeGroup.name;
        convertedRequest.codeGroup.description = request.codeGroup.description;
        convertedRequest.codeList = request.codeList.stream()
            .map(codeRequest -> {
                CreateCodeRequest.CreateCode code =  new CreateCodeRequest.CreateCode();
                code.displayId = codeRequest.displayId;
                code.name = codeRequest.name;
                code.description = codeRequest.description;
                return code;
            }).toList();

        Long response = this.create(convertedRequest);

        return response;
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean delete(String codeGroupDisplayId) {
        CodeGroupJpaEntity codeGroup = codeGroupQueryRepository.findByDisplayId(codeGroupDisplayId);
        Assert.notNull(codeGroup, "Code group with DISPLAY_ID not found");

        codeQueryRepository.findAllByCodeGroup(codeGroup)
            .forEach(code -> codeQueryRepository.deleteByCodeGroup(codeGroup));

        codeGroupQueryRepository.deleteByDisplayId(codeGroupDisplayId);

        return true;
    }
    
}
*/
