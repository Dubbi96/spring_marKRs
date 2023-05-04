package pe.marker.asan.auth.application.dto;

import lombok.Data;
import pe.marker.asan.auth.domain.entity.MarkrsUser;
import pe.marker.asan.auth.domain.entity.Role;

@Data
public class MemberProfile {
    private String name;
    private String email;
    private String provider;
    private String nickname;
    private String picture;

    public MarkrsUser toMember() {
        return MarkrsUser.builder()
                .userName(name)
                .email(email)
                .provider(provider)
                .picture(picture)
                .role(Role.USER)
                .build();
    }
}
