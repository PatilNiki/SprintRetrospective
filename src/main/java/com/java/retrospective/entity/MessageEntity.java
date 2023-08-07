package com.java.retrospective.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="message")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MessageEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    @NonNull private Integer id;
    @Column
    @NonNull private String message;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_user", referencedColumnName = "id")
    @NonNull private UserEntity user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_retrospective", referencedColumnName = "id")
    @NonNull private RetrospectiveEntity retrospective;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_swimlane", referencedColumnName = "id")
    @NonNull private SwimlaneEntity swimlane;

}
