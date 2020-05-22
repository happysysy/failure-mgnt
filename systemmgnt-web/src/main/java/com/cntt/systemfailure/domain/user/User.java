package com.cntt.systemfailure.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column( length = 500, nullable = false)
    private String name;

    @Column( length = 500, nullable = true )
    private String position;

    @Column( length = 500, nullable = true )
    private String deptNm;

    @Builder
    public User( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

}
