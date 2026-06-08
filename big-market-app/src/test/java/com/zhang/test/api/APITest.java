package com.zhang.test.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/6/8 11:04
 **/

public class APITest {

    @Test
    public void test01(){
        List emptyList = Collections.EMPTY_LIST;
        System.out.println(emptyList);
        System.out.println(emptyList.size());


    }
}
