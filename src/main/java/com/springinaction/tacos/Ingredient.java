package com.springinaction.tacos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) // JPA 를 사용하기 위해서는 인가 없는 생성자가 반드시 필요 (AccessLevel.PRIVATE 를 통해 클래스 외부에서는 사용하지 못하도록 설정)
@Entity
public class Ingredient  { // 타코 재료
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
