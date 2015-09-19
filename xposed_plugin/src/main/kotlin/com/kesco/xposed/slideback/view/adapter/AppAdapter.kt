package com.kesco.xposed.slideback.view.adapter

import android.content.Context
import android.content.pm.ApplicationInfo
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kesco.adk.ui.bindViewById
import com.kesco.xposed.slideback.R
import com.kesco.xposed.slideback.domain.AppInfo
import java.util
import java.util.*

class AppAdapter(val ctx: Context) : RecyclerView.Adapter<AppAdapter.AppVH>() {

    val layoutInflater: LayoutInflater

    private val _apps = ArrayList<AppInfo>()

    var applist: List<AppInfo>
        get() = _apps
        set(value) {
            _apps.clear()
            _apps.addAll(value)
            notifyDataSetChanged()
        }

    init {
        layoutInflater = LayoutInflater.from(ctx)
    }

    override fun onBindViewHolder(holder: AppVH, position: Int) {
        val app = _apps.get(position)
        holder.tvAppName.text = app.name
        holder.ivAppIcon.setImageDrawable(app.icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppVH? {
        val view = layoutInflater.inflate(R.layout.item_apps, parent, false)
        return AppVH(view)
    }

    override fun getItemCount(): Int = _apps.size()

    class AppVH(view: View) : RecyclerView.ViewHolder(view) {
        val tvAppName: TextView by bindViewById(R.id.tv_app_name)
        val ivAppIcon: ImageView by bindViewById(R.id.iv_app_icon)
    }
}
