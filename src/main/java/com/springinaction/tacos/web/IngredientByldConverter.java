package com.springinaction.tacos.web;

import com.springinaction.tacos.Ingredient;
import com.springinaction.tacos.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component // 스캔 대상으로 Bean 생성
public class IngredientByldConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepository;

    // 생성자 주입
    @Autowired
    public IngredientByldConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    /* String 타입의 식자재 id 를 사용해서 DB 에 저장된 특정 식자재 데이터를 조회하여 Ingredient 객체로 변환하는 역할 */
    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        return optionalIngredient.isPresent() ? optionalIngredient.get() : null;
    }
}
