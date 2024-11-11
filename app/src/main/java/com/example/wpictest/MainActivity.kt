package com.example.wpictest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initPopularFrames()
    }

    private fun initPopularFrames(){

        val recyclerView: RecyclerView = findViewById(R.id.home__rw__popular_frames)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = FramesRecyclerAdapter(getFrames())

    }


    private fun getFrames(): MutableList<FrameItem> {
        // If the order is messed up from the app or api... the recyclerview gets gaps
        // tototal time 2 h 16 min

        val framesFromSomewhere = mutableListOf(
            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img1)!!, true),
            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img2)!!, false),

            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img4)!!, true),
            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img3)!!, false),

            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img5)!!, true),
            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img7)!!, false),

            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img8)!!, true),
            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img6)!!, false),

            FrameItem(AppCompatResources.getDrawable(this, R.drawable.img9)!!, isPremium = false, is2ColumnWide = true),
        )

        return framesFromSomewhere
    }

}