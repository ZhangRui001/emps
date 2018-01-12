package test;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestEmpProTest {
    @Test
    public void test1(){
        java.sql.Date dd= new java.sql.Date(System.currentTimeMillis());
        Date now = dd;
        System.out.println(now);
    }

}