package com.kesco.xposed.slideback.domain

import android.content.Context
import android.content.pm.PackageInfo
import android.graphics.drawable.Drawable

data class AppInfo(val name: String, val pack: String, val icon: Drawable)

fun genAppInfo(ctx: Context, packinfo: PackageInfo): AppInfo {
    val manager = ctx.packageManager
    val appName = packinfo.applicationInfo.loadLabel(manager).toString()
    val packName = packinfo.packageName
    val appIcon = packinfo.applicationInfo.loadIcon(manager)
    return AppInfo(appName, packName, appIcon)
}
