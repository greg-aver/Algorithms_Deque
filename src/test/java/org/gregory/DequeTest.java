package org.gregory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


class DequeTest {

    Deque<Integer> dequeIntActual;
    Deque<Integer> dequeIntExpected;

    @BeforeEach
    void setUp() {
        dequeIntExpected = new Deque<Integer>();
        dequeIntActual = new Deque<Integer>();
        dequeIntActual.addTail(1, 2, 3, 4, 5);
    }

    @AfterEach
    void tearDown() {
        dequeIntActual = null;
    }

    @Test
    void addTail() {
        dequeIntActual.addTail(0);
        dequeIntExpected.addTail(1, 2, 3, 4, 5, 0);
        assertThat(dequeIntActual, is(dequeIntExpected));
    }

    @Test
    void addFront() {
        dequeIntActual.addFront(0);
        dequeIntExpected.addTail(0, 1, 2, 3, 4, 5);
        assertThat(dequeIntActual, is(dequeIntExpected));
    }

    @Test
    void removeTail() {
        assertThat(dequeIntActual.removeTail(), is(5));
        assertThat(dequeIntActual.size(), is(4));
        assertThat(dequeIntActual.removeTail(), is(4));
        assertThat(dequeIntActual.size(), is(3));
        assertThat(dequeIntActual.removeTail(), is(3));
        assertThat(dequeIntActual.size(), is(2));
        assertThat(dequeIntActual.removeTail(), is(2));
        assertThat(dequeIntActual.size(), is(1));
        assertThat(dequeIntActual.removeTail(), is(1));
        assertThat(dequeIntActual.size(), is(0));
    }

    @Test
    void removeTailNull() {
        assertThat(dequeIntExpected.removeTail(), nullValue());
        assertThat(dequeIntExpected.size(), is(0));
        assertThat(dequeIntExpected.removeTail(), nullValue());
        assertThat(dequeIntExpected.size(), is(0));
        assertThat(dequeIntExpected.removeTail(), nullValue());
        assertThat(dequeIntExpected.size(), is(0));
        assertThat(dequeIntExpected.removeTail(), nullValue());
        assertThat(dequeIntExpected.size(), is(0));
    }

    @Test
    void removeFrontNull() {
        assertThat(dequeIntExpected.removeFront(), nullValue());
        assertThat(dequeIntExpected.size(), is(0));
        assertThat(dequeIntExpected.removeFront(), nullValue());
        assertThat(dequeIntExpected.size(), is(0));
        assertThat(dequeIntExpected.removeFront(), nullValue());
        assertThat(dequeIntExpected.size(), is(0));
        assertThat(dequeIntExpected.removeFront(), nullValue());
        assertThat(dequeIntExpected.size(), is(0));
        assertThat(dequeIntExpected.removeFront(), nullValue());
    }

    @Test
    void removeFront() {
        assertThat(dequeIntActual.removeFront(), is(1));
        assertThat(dequeIntActual.size(), is(4));
        assertThat(dequeIntActual.removeFront(), is(2));
        assertThat(dequeIntActual.size(), is(3));
        assertThat(dequeIntActual.removeFront(), is(3));
        assertThat(dequeIntActual.size(), is(2));
        assertThat(dequeIntActual.removeFront(), is(4));
        assertThat(dequeIntActual.size(), is(1));
        assertThat(dequeIntActual.removeFront(), is(5));
        assertThat(dequeIntActual.size(), is(0));
    }
    
     @Test
    void palindrome1Element() {
        assertThat(palindrome("q"), is(true));
        assertTrue(palindrome("O"));
    }

    @Test
    void palindrome5Element() {
        assertThat(palindrome("qwewq"), is(true));
        assertThat(palindrome("qwewe"), is(false));
    }

    @Test
    void palindrome4Element() {
        assertThat(palindrome("qwwq"), is(true));
    }

    @Test
    void palindrome4ElementMiddleDifferent() {
        assertThat(palindrome("qwYq"), is(false));
    }
}
