package com.jay.study.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {
    @Test
    public void rombok_works_correctly() {
        // Arrange
        String name = "test";
        int amount = 1000;

        // Act
        HelloResponseDto actual = new HelloResponseDto(name, amount);

        // Assert
        assertThat(actual.getName()).isEqualTo(name);
        assertThat(actual.getAmount()).isEqualTo(amount);
    }
}
