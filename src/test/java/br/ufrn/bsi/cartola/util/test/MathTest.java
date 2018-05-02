package br.ufrn.bsi.cartola.util.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufrn.bsi.cartola.util.MathUtils;

public class MathTest {

    private MathUtils math;

    @Before
    public void setUp() {
        math = new MathUtils();
    }

    @Test
    public void sumSucessTest() {
        Integer result = math.sum(10, 10);
        assertEquals("teste-01", Integer.valueOf(20), result);
    }
}
