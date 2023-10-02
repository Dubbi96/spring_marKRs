package pe.marker.asan.code.domain.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import pe.marker.asan.code.domain.entity.CodeGroupJpaEntity;
import pe.marker.asan.code.domain.entity.CodeJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.marker.asan.code.domain.entity.QCodeJpaEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeQueryRepository {
    
    private final JPAQueryFactory query;
    QCodeJpaEntity code = QCodeJpaEntity.codeJpaEntity;

    public List<CodeJpaEntity> findAllByCodeGroup(CodeGroupJpaEntity codeGroup) {
        return query.selectFrom(code)
            .where(eqCodeGroup(codeGroup))
            .fetch();
    }

    public CodeJpaEntity findByDisplayId(String displayId) {
        List<CodeJpaEntity> result = query.selectFrom(code)
            .where(notDeleted().and(eqDisplayId(displayId)))
            .fetch();
        return result.isEmpty() ? null : result.get(0);
    }

    public Long deleteByCodeGroup(CodeGroupJpaEntity codeGroup) {
        return query.update(code)
            .set(code.deleted, LocalDateTime.now())
            .where(notDeleted().and(eqCodeGroup(codeGroup)))
            .execute();
    }

    public BooleanExpression notDeleted() { return code.deleted.isNull(); }
    public BooleanExpression eqCodeGroup(CodeGroupJpaEntity codeGroup) { return code.codeGroup.id.eq(codeGroup.getId()); }
    public BooleanExpression eqDisplayId(String displayId) { return code.displayId.eq(displayId); }
}
