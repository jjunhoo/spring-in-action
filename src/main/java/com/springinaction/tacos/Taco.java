package com.springinaction.tacos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // DB 에서 자동 생성해주는 ID 값 사용
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    /* 하나의 Taco 객체는 여러 개의 Ingredient 객체를 가질 수 있는데, 하나의 Ingredient 는 여러 Taco 객체에 포함될 수 있음 */
    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    /* Taco 객체가 저장되기 전 createdAt 속성을 현재 일자와 시간으로 설정 */
    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
