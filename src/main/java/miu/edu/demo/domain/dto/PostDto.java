package miu.edu.demo.domain.dto;

import lombok.Data;

@Data
public class PostDto {

    private String title;
    private String content;
    private long idUser;
}
