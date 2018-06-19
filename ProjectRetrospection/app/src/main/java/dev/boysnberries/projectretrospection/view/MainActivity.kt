package dev.boysnberries.projectretrospection.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.jakewharton.threetenabp.AndroidThreeTen
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.samples.getProducts

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         * Initialize AndroidThreeTen Clock API
         * [Source](https://github.com/JakeWharton/ThreeTenABP/blob/master/README.md)
         */
        AndroidThreeTen.init(this)

        val trackersView = findViewById<RecyclerView>(R.id.recycler_trackers)
        trackersView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        // TODO: get actual trackers
        val trackers = getProducts()

        trackersView.adapter = TrackerAdapter(trackers=trackers)
    }
}
