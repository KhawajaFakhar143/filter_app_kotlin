package com.example.filterapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filterapp.databinding.ActivityMainBinding
import jp.co.cyberagent.android.gpuimage.GPUImage
import jp.co.cyberagent.android.gpuimage.GPUImageView
import jp.co.cyberagent.android.gpuimage.filter.GPUImageColorInvertFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageColorMatrixFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageContrastFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilterGroup
import jp.co.cyberagent.android.gpuimage.filter.GPUImageHazeFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSepiaToneFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageZoomBlurFilter
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var bitmap: Bitmap
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val inputStream = assets.open("IMG_20230530_125649.jpg")
        bitmap = BitmapFactory.decodeStream(inputStream)
        binding.gpuimageview.setImage(bitmap) // this loads image on the current thread, should be run in a thread
        binding.gpuimageview.filter = GPUImageColorMatrixFilter()


        // Later when image should be saved saved:
        // gpuImageView.saveToPictures("GPUImage", "ImageWithFilter.jpg", null)
        bindAdapter()

    }

    private fun bindAdapter() {
        var filterList = Constants.getFiltersList()
        val adapter = FiltersAdapter(filterList) {
            binding.gpuimageview.filter = it
        }
        binding.filtersRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.filtersRecyclerView.adapter = adapter
    }
}