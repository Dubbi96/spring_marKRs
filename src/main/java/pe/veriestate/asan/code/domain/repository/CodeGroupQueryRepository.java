package pe.marker.asan.code.domain.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pe.marker.asan.code.domain.entity.CodeGroupJpaEntity;
import pe.marker.asan.code.domain.entity.QCodeGroupJpaEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeGroupQueryRepository {

    private final JPAQueryFactory query;
    QCodeGroupJpaEntity codeGroup = QCodeGroupJpaEntity.codeGroupJpaEntity;

    public List<CodeGroupJpaEntity> findPage(Pageable page) {
        return query.selectFrom(codeGroup)
            .where(notDeleted())
            .offset(page.getOffset())
            .limit(page.getPageSize())
            .fetch();
    }

    public CodeGroupJpaEntity findByDisplayId(String displayId) {
        List<CodeGroupJpaEntity> result = query.selectFrom(codeGroup)
            .where(notDeleted().and(eqDisplayId(displayId)))
            .fetch();
        return result.isEmpty() ? null : result.get(0);
    }

    public Long deleteByDisplayId(String displayId) {
        return query.update(codeGroup)
            .set(codeGroup.deleted, LocalDateTime.now())
            .where(notDeleted().and(eqDisplayId(displayId)))
            .execute();
    }

    public BooleanExpression notDeleted() { return codeGroup.deleted.isNull(); }
    public BooleanExpression eqDisplayId(String displayId) { return codeGroup.displayId.eq(displayId); }
}
