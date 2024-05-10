package com.flab.wodmarket.domain.image.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ImageInfo {

    private Long imgNo;
    private Long itemNo;
    @NotEmpty(message = "원본 이미지 이름은 비어 있으면 안 됩니다")
    private String imgOrgName;
    private String imgName;
    @NotEmpty(message = "이미지 URL은 비어 있으면 안 됩니다")
    private String imgUrl;

}
