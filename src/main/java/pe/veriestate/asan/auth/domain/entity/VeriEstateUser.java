package pe.veriestate.asan.auth.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import pe.veriestate.asan.common.domain.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@SuperBuilder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class VeriEstateUser extends BaseEntity {
    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "E_MAIL")
    private String email;

    @Column(name = "PROFILE_PICTURE")
    private String picture;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    public VeriEstateUser update(String userName, String email, String picture){
        this.userName = userName;
        this.email = email;
        this.picture = picture;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
