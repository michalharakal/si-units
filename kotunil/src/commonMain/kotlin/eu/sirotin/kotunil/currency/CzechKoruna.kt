
package eu.sirotin.kotunil.currency

import eu.sirotin.kotunil.core.Expression
import eu.sirotin.kotunil.core.UnitSpecification
import kotlin.jvm.JvmField
import kotlin.js.JsExport
import kotlin.js.JsName

private val descriptionCzechKoruna = UnitSpecification(
    "CZK",
    "`Kč`"
) { v: Double -> CzechKoruna(v) }

/**
* Class for hold of  Czech koruna
* @constructor Creates a class for hold of  Czech koruna with given [value]
*/
@JsExport
class CzechKoruna(value : Double = 1.0) : Expression(value, description = descriptionCzechKoruna)
    
    /**
    * Creates object for hold of  Czech koruna
    */
    val Number.CZK : CzechKoruna
        /**
        * Returns value of object for hold of  Czech koruna
        */
        get() = CzechKoruna(this.toDouble())

    /**
    * Holder for  of  Czech koruna
    */
    @JsExport
    @JsName("CZK")
    @JvmField
    val CZK = CzechKoruna()   
    