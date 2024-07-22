package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SqlStatement {
    private String domain_NAME;
    private String sql_SKELETON;
    private int seq_NO;
    private String execute_ONLY;
    private String row_limit_CHECK;
    private String loop_ACCTS;
}
