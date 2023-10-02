package pe.marker.asan.auth.application.dto;

import lombok.Data;
import pe.marker.asan.auth.domain.entity.Role;
import pe.marker.asan.auth.domain.entity.VeriEstateUser;

@Data
public class MemberProfile {
    private String name;
    private String email;
    private String provider;
    private String nickname;
    private String picture;

    public VeriEstateUser toMember() {
        return VeriEstateUser.builder()
                .userName(name)
                .email(email)
                .provider(provider)
                .picture(picture)
                .role(Role.USER)
                .build();
    }
}
