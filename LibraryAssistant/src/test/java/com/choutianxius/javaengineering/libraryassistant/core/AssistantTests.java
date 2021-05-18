package com.choutianxius.javaengineering.libraryassistant.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssistantTests {
    String testname = "张三";
    String testphone = "17300000000";
    @Test
    void constructorThenOk() {
        int id = 1;
        String name = testname;
        String phone = testphone;
        Assistant assistant = new Assistant(id, name, phone);
        assertEquals(id, assistant.getId());
        assertEquals(name, assistant.getName());
        assertEquals(phone,assistant.getPhone());
        assertEquals("freshman", assistant.getRank());
        assertEquals(0d, assistant.getCurrentHours());
        assertEquals(0d, assistant.getTotalHours());
    }

    @Test
    void whenIdIsNullThenException() {
        assertThrows(Exception.class, () -> new Assistant(null, testname, testphone));
    }

    @Test
    void whenNameIsNullThenException() {
        assertThrows(Exception.class, () -> new Assistant(1, null, testphone));
    }

    @Test
    void whenNameIsEmptyThenException() {
        assertThrows(Exception.class, () -> new Assistant(1, "", testphone));
    }

    @Test
    void whenNameIsBlankThenException() {
        assertThrows(Exception.class, () -> new Assistant(1, " ", testphone));
    }

    @Test
    void whenPhoneIsNullThenException() { assertThrows(Exception.class, () -> new Assistant(1, testname, null));}

    @Test
    void whenPhoneIsEmptyThenException() {
        assertThrows(Exception.class, () -> new Assistant(1, testname, ""));
    }

    @Test
    void whenPhoneIsBlankThenException() {
        assertThrows(Exception.class, () -> new Assistant(1, testname, " "));
    }

    /**
     * 暂时不考虑name和phone的格式问题
     */
    @Test
    void getterIdThenOk() {assertEquals(1, new Assistant(1, testname, testphone).getId());}

    @Test
    void getterNameThenOk() {assertEquals(testname, new Assistant(1, testname, testphone).getName());}

    @Test
    void getterPhoneThenOk() {assertEquals(testphone, new Assistant(1, testname, testphone).getPhone());}

    @Test
    void setterPhoneThenOk() {
        Assistant assistant = new Assistant(1, testname, testphone);
        assistant.setPhone("17355800000");
        assertEquals("17355800000", assistant.getPhone());
    }

    @Test
    void getterRankThenOk() {new Assistant(1, testname, testphone).getRank();}

    @Test
    void setterRankThenOk() {
        Assistant assistant = new Assistant(1, testname, testphone);
        assistant.setRank("skilled");
        assertEquals("skilled", assistant.getRank());
    }

    @Test
    void getterCHThenOk() {assertEquals(0d, new Assistant(1, testname, testphone).getTotalHours());}

    @Test
    void setterCHThenOk() {
        Assistant assistant = new Assistant(1, testname, testphone);
        assistant.setCurrentHours(30d);
        assertEquals(30d, assistant.getCurrentHours());
    }

    @Test
    void getterTHThenOk() {assertEquals(0d, new Assistant(1, testname, testphone).getTotalHours());}

    @Test
    void setterTHThenOk() {
        Assistant assistant = new Assistant(1, testname, testphone);
        assistant.setTotalHours(30d);
        assertEquals(30d, assistant.getTotalHours());
    }
}
