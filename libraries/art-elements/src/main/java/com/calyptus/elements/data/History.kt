package com.calyptus.artelement.data

import java.util.*
import kotlin.collections.ArrayList

class History {
    private val layers: ArrayList<Layer> = ArrayList()

    fun push(layer : Layer){
        layers.add(layer)
    }

    fun pop() : Layer {
        if(layers.isEmpty()){
            throw EmptyStackException()
        }
        val layer = layers[layers.size - 1]
        layers.remove(layer)
        return layer
    }

    fun getLayers() : ArrayList<Layer> {
        return layers
    }
}