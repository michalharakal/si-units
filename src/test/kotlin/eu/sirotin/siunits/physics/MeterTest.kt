package eu.sirotin.siunits.physics

import eu.sirotin.siunits.core.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


internal class MeterTest {

    @Test
    fun testMeterObject() {
        val v1 = 2.42.m

        assertEquals(2.42, v1.value)
        assertEquals("m", v1.symbol)
        assertEquals("2.42 m", v1.toString())
        assertEquals("eu.sirotin.siunits.physics.Meter", v1.javaClass.name)

    }

    @Test
    fun testMeterOperations() {
        val v1 = 2.m - 1.5.m + 2*1.5.m - 3.m

        assertEquals(0.5, v1.value)
        assertEquals("m", v1.symbol)
        assertEquals("0.5 m", v1.toString())
        assertEquals("eu.sirotin.siunits.physics.Meter", v1.javaClass.name)

    }

}