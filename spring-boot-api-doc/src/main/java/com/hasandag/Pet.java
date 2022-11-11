package com.hasandag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "My Pet Object",description = "My Pet Description")
public class Pet {

    @ApiModelProperty(value = "Pet object id")
    private int id;

    @ApiModelProperty(value = "Pet object name")
    private String name;

    @ApiModelProperty(value = "Pet object date")
    private Date date;
}
