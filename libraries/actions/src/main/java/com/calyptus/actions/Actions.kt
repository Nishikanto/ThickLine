package com.calyptus.actions

import android.content.Context
import android.content.Intent

object Actions {

    fun openArtBoardIntent(context: Context) = internalIntent(context, "action.artboard.open")

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}