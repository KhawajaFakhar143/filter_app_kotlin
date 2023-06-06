package com.example.filterapp

import android.graphics.Bitmap
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter

data class ImageFilters(
    val name: String,
    val filters: GPUImageFilter,
   // val filterPreview: Bitmap
)
