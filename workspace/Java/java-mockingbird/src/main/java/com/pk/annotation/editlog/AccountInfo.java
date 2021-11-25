package com.pk.annotation.editlog;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountInfo {

    private String id;

    private String accountName;

    @FieldComparable(zhName = "公司")
    private String company;

    @FieldComparable(zhName = "薪水")
    private double salary;
}
