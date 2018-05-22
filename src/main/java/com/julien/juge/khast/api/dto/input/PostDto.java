package com.julien.juge.khast.api.dto.input;

import lombok.Builder;
import lombok.Data;

import javax.xml.soap.Text;
import java.util.Date;

@Data
public class PostDto {

    protected String id;

    protected Date createdDate;

    protected EventDto event;

    protected TextDto text;

}
