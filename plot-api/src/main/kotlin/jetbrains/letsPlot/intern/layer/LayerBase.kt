/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.letsPlot.intern.layer

import jetbrains.letsPlot.intern.Layer
import jetbrains.letsPlot.intern.Options

abstract class LayerBase(
    mapping: Options,
    data: Any? = null,
    geom: GeomOptions,
    stat: StatOptions,
    position: PosOptions,
    show_legend: Boolean,
    sampling: SamplingOptions? = null
) : Layer(
    mapping = mapping,
    data = data,
    geom = geom,
    stat = stat,
    position = position,
    show_legend = show_legend,
    sampling = sampling
), OptionsCapsule {

    override val parameters by lazy { geom.parameters + stat.parameters + this.seal() }
}