
package eu.sirotin.kotunil.currency

import eu.sirotin.kotunil.core.Expression
import eu.sirotin.kotunil.core.UnitSpecification
import kotlin.jvm.JvmField

private val descriptionUAEDirham = UnitSpecification(
    "AED",
    "Dh"
) { v: Double -> UAEDirham(v) }

/**
* Class for hold of UAE dirham
* @constructor Creates a class for hold of UAE dirham with given [value]
*/
class UAEDirham(value : Double = 1.0) : Expression(value, description = descriptionUAEDirham)
    
    /**
    * Creates object for hold of UAE dirham
    */
    val Number.AED : UAEDirham
        /**
        * Returns value of object for hold of UAE dirham
        */
        get() = UAEDirham(this.toDouble())

    /**
    * Holder for  of UAE dirham
    */
    @JvmField()
    val AED = UAEDirham()   
    

/**
* Creates object for hold of UAE dirham
*/
val Number.Dh : UAEDirham
    /**
    * Returns value of object for hold of UAE dirham
    */
    get() = UAEDirham(this.toDouble())

/**
* One unit of UAE dirham
*/
@JvmField()
val Dh = UAEDirham()
