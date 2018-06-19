package dev.boysnberries.projectretrospection.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import dev.boysnberries.projectretrospection.R
import dev.boysnberries.projectretrospection.data.Tracker
import dev.boysnberries.projectretrospection.data.samples.getTrackers

class MainActivity : Activity() {

    public val OPEN_TRACKER_KEY = "SELECTED_TRACKER"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val trackersView = findViewById<RecyclerView>(R.id.recycler_trackers)
        trackersView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        // TODO: get actual trackers
        val trackers = getTrackers()

        trackersView.adapter = TrackerAdapter(
                trackers=trackers,
                onClickCallback = {
                    val idx = trackersView.indexOfChild(it)
                    this.openTrackerEditor(trackers[idx])
                }
        )
    }

    fun openTrackerEditor(tracker: Tracker) {
        val intent = Intent(this, TrackerCreationActivity::class.java)
        intent.putExtra(OPEN_TRACKER_KEY, tracker)
        this.startActivity(intent)
    }
}
