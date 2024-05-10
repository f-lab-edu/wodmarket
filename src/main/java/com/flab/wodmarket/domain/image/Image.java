package com.flab.wodmarket.domain.image;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Image {

    public int imgNo;

    public int itemNo;

    public String imgName;

    public String imgOrgName;

    public String imgUrl;

    public int seq;

    public Image(int imgNo, int itemNo, String imgName, String imgOrgName, String imgUrl, int seq) {
        this.imgNo = imgNo;
        this.itemNo = itemNo;
        this.imgName = imgName;
        this.imgOrgName = imgOrgName;
        this.imgUrl = imgUrl;
        this.seq = seq;
    }
}
