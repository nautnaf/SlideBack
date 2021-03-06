package com.kesco.adk.moko.slideback

import android.graphics.Canvas

public interface SlideListener {
    fun onSlideStart()
    fun onSlide(percent: Float, state: SlideState)
    fun onSlideFinish()
}

public enum class SlideEdge {
    LEFT, TOP, RIGHT, BOTTOM, NONE
}

public enum class SlideShadow {
    EDGE, FULL
}

public enum class SlideState {
    DRAGGING, IDLE, SETTLING
}

enum class Direction {
    Horizontal, Vertical
}

interface SlideViewDelegate {
    fun canViewDragged(pointerId: Int): Boolean
    fun clampViewPosition(distance: Int, direct: Direction): Int
    fun decorateDraggedView(canvas: Canvas)
    fun draggedViewDestination(xvel: Float, yvel: Float): Array<Int>
    fun draggedPercent(left: Int, top: Int): Float
}