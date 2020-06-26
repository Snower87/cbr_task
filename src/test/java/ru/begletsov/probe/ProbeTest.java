package ru.begletsov.probe;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProbeTest {

    @Test
    public void string_test() {
        Assert.assertEquals("111", new Probe().string_test());
    }
}