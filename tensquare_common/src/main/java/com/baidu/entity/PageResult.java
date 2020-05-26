package com.baidu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    private long total;//总记录数
    private List<T> rows;//的撒旦阿萨 das dsad asd asd

}
