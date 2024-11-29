package br.com.forumhub.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewTopic(

        @NotBlank
        String title,

        @NotBlank
        String message,

        @NotNull
        Long author,

        @NotNull
        Long course) {
}