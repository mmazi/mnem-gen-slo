package com.github.mmazi.mnemgen;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

public class MappingTest {
    @Test
    public void testToNumber() throws Exception {
        Assert.assertEquals(Mapping.toNumber("").intValue(), 0);
        Assert.assertEquals(Mapping.toNumber("računalnik").intValue(), 462527);
        Assert.assertEquals(Mapping.toNumber("RačuNALnik").intValue(), 462527);
        Assert.assertEquals(Mapping.toNumber("aha").intValue(), 0);
        Assert.assertEquals(Mapping.toNumber("UZBEKISTAN").intValue(), 97012);
    }

    @Test
    public void testGetWordsForNumber() throws Exception {
        Assert.assertTrue(Mapping.getWordsForNumber(36).contains("miš"));
    }

    @Test
    public void doUsefulStuff() throws Exception {
        for (int number : Arrays.asList(1234, 52, 9876, 8765, 2345, 34567, 58234, 42, 55234, 432, 9092, 8190)) {
            final Collection<String> words = Mapping.getWordsForNumber(number);
            System.out.println("========= Besede za " + number + ":");
            for (String word : words) {
                System.out.println(word);
            }
        }
    }


}
