package com.flab.wodmarket.domain.image;

import com.flab.wodmarket.domain.image.dto.request.ImageInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {

    void save(ImageInfo imageInfo);
}
