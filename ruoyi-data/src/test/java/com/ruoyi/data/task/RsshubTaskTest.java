package com.ruoyi.data.task;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author superz
 * @create 2023/5/10 9:48
 **/
public class RsshubTaskTest {
    @Test
    public void testFetch() {
        new RsshubTask().fetch("jiemian");
    }
}