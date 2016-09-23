package com.sape.order.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTypeEnumTest {

    @Test
    public void testAccountTypeSize(){
        int accountTypeSize = AccountTypeEnum.values().length;
        assertTrue(accountTypeSize == 3);
    }

}