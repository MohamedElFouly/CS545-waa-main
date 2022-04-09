package miu.edu.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommentDto {
    private String name;
    private long idPost;
}
