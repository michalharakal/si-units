/*
 * Copyright (c) 2022 Dr. Viktor Sirotin
 *  *
 *   * Permission is hereby granted, free of charge, to any person obtaining a copy
 *   * of this software and associated documentation files (the "Software"), to deal
 *   * in the Software without restriction, including without limitation the rights
 *   * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   * copies of the Software, and to permit persons to whom the Software is
 *   * furnished to do so, subject to the following conditions:
 *   * This Copyright header should still in file if you use it file without changes or
 *   * with changes or if you copy essential part of this file in some new file.
 *   *
 *   * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  * THE SOFTWARE.
 */

package eu.sirotin.siunits.core

const val COMPATIBILITY_ERR_PREFIX = "Can't process objects with different dimensions:"
const val EPS = 1.0E-12

abstract class TermUnit(val value: Double = 1.0, val description: UnitSpecification<*> ) : Comparable<TermUnit>, UnitPresentation {

    override fun compareTo(other: TermUnit): Int {
        checkCompatibility(other)
        return value.compareTo(other.value)
    }


    fun checkCompatibility(other: TermUnit) {
        if (this.description != other.description)
            throw IllegalArgumentException("$COMPATIBILITY_ERR_PREFIX 'this' is '${this.categorySymbols()} but 'other' is '${other.categorySymbols()}'")
    }


    override fun toString(): String {
        return "${this.value} ${unitSymbols()}"
    }

    override fun unitSymbols() : String = description.unitSymbol
    override fun categorySymbols(): String = description.categorySymbol
    fun show(format: String): String = "${String.format(format, value)} ${unitSymbols()}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TermUnit) return false

        if (value != other.value) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }
}



operator fun TermUnit.plus(x: TermUnit): TermUnit {
    this.checkCompatibility(x)
    return this.description.creator(this.value + x.value)
}

operator fun TermUnit.times(x: Number): TermUnit = this.description.creator(this.value * x.toDouble())
operator fun TermUnit.minus(x: TermUnit): TermUnit = this + (-1)*x


operator fun Number.times(x: TermUnit): TermUnit = x * this

operator fun TermUnit.div(x: Number): TermUnit = this.description.creator(this.value / x.toDouble())

//Not clear why compilation error occurs
//@Suppress("DANGEROUS_CHARACTERS")
//operator fun TermUnit.`%`(x: Number): TermUnit = this.description.creator(this.value / 100.0)




