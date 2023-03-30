/*
 * Copyright (c) 2022.  Viktor Sirotin
 *
 *  *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  *  furnished to do so, subject to the following conditions:
 *  *  This Copyright header should still in file if you use it file without changes or
 *  * with changes or if you copy essential part of this file in some new file.
 *  *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  * THE SOFTWARE.
 *
 */

@file:Suppress("NonAsciiCharacters")

package eu.sirotin.kotunil.specialunits

import eu.sirotin.kotunil.core.Expression
import eu.sirotin.kotunil.core.times
import eu.sirotin.kotunil.core.div
import eu.sirotin.kotunil.derived.rad
import kotlin.math.PI


@Suppress("DANGEROUS_CHARACTERS")
val Number.`%`: Double
    /**
     * get Percentage
     */
    get()  = this.toDouble()*0.01

@Suppress("DANGEROUS_CHARACTERS")
/**
 * Percentage
 */
val `%` = 0.01

@Suppress("DANGEROUS_CHARACTERS")
/**
 * Percentage as double
 */
val Expression.`as %` : Double
    /**
     * get percentage as double
     */
    get()  = this.value*100.0


/**
 * degree
 */
val `°` = (PI/180)*rad

/**
 * arcminute
 */

val `′` = `°` / 60.0

/**
 * arcsecond
 */

val `″` = `′` / 60.0






