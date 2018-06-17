package dev.boysnberries.projectretrospection.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import dev.boysnberries.projectretrospection.R

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trackersView = findViewById<RecyclerView>(R.id.recycler_trackers)
        trackersView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        // TODO: get actual trackers
        val trackers = listOf(
                "Tracker One",
                "Tracker Two",
                "Tracker Three",
                "Tracker Four",
                "Tracker Five",
                "Tracker Six"
        )

        trackersView.adapter = TrackerAdapter(trackers=trackers)
    }
}